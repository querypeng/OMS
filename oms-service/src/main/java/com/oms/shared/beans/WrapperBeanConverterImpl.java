package com.oms.shared.beans;

import net.jodah.typetools.TypeResolver;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.apache.commons.lang3.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 与{@link WrapperBeanCopier}不同，此实现通过自定义映射策略支持JavaBean转换。
 * 由于内部属性转换器和BeanCopier映射不是静态的，因此最好使实例静态以供全局使用。
 *
 * @author shishi
 */
public class WrapperBeanConverterImpl implements WrapperBeanConverter {

    /**
     * 提供自定义属性转换策略的cglib转换器
     */
    private final Converter converter;

    /**
     * 存储用于转换的源类型和类类型的{@link BeanCopier}的映射
     */
    private final Map<String, BeanCopier> beanCopierMap;

    /**
     * 构造一个{@link WrapperBeanConverter}的新实例
     *
     * @param converters 类型转换器
     */
    WrapperBeanConverterImpl(List<TypeConverter<?, ?>> converters) {
        this.converter = new ConverterAdapter(converters);
        this.beanCopierMap = new ConcurrentHashMap<>();
    }

    /**
     * 将给定源bean的属性值复制到目标bean中
     *
     * @param source 源 bean
     * @param target 目标 bean
     *
     * @see BeanCopier
     */
    @Override
    public void copyProperties(Object source, Object target) {
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(target, "target must not be null");

        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, converter);
    }

    /**
     * 将给定的源bean转换为指定类型的目标bean
     *
     * @param source 源 bean
     * @param clazz  指定类型的目标 bean
     * @param <T>    指定类型的目标
     *
     * @return 指定类型的目标 bean <code>T</code>
     */
    @Override
    public <T> T convert(Object source, Class<T> clazz) {
        T result;
        try {
            result = clazz.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("fail to create instance of type" + clazz.getCanonicalName(), e);
        }

        copyProperties(source, result);
        return result;
    }

    /**
     * 将给定的源bean转换为指定类型的目标bean
     * @param source
     * @param clazz
     * @param <T>
     * @return  指定类型的目标集合 bean <code>T</code>
     */
    @Override
    public <T> List<T> convert(List<?> source, Class<T> clazz) {
        Objects.requireNonNull(source, "source must not be null");
        return source.stream()
                .map(x -> convert(x, clazz))
                .collect(Collectors.toList());
    }

    /**
     * 获取源类和目标类的{@link BeanCopier}
     * 如果<code> BEAN_COPIER_MAP </code>中未包含新的，则创建一个新的
     *
     * @param source 源
     * @param target 目标
     *
     * @return 源类和目标类的BeanCopier
     */
    private BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
        String key = generateKey(source, target);
        return beanCopierMap.computeIfAbsent(key, x -> BeanCopier.create(source, target, true));
    }

    /**
     *
     * 通过源类和目标类获取<code> BEAN_COPIER_MAP </code>的key
     *
     * @param source 源
     * @param target 目标
     *
     * @return <code> BEAN_COPIER_MAP </code>的key（按源类和目标类）
     */
    private String generateKey(Class<?> source, Class<?> target) {
        return source.getCanonicalName().concat(target.getCanonicalName());
    }

    /**
     * 将{@link TypeConverter}转换为{@link Converter}的适配器类
     */
    static class ConverterAdapter implements Converter {

        private final Map<Class, List<ResolvedTypeConverter>> converterMap;

        ConverterAdapter(List<TypeConverter<?, ?>> converterMap) {
            this.converterMap = converterMap.stream()
                    .map(this::resolveTypeConverter)
                    .collect(Collectors.groupingBy(ResolvedTypeConverter::getSourceType));
        }

        @Override
        public Object convert(Object value, Class targetType, Object context) {
            if (value == null) {
                return null;
            }

            Class sourceType = value.getClass();

            if (ClassUtils.isAssignable(sourceType, targetType, true)) {
                return value;
            }

            for (Map.Entry<Class, List<ResolvedTypeConverter>> entry : converterMap.entrySet()) {
                Class converterSourceType = entry.getKey();
                List<ResolvedTypeConverter> converters = entry.getValue();

                if (ClassUtils.isAssignable(sourceType, converterSourceType, true)) {
                    for (ResolvedTypeConverter converter : converters) {
                        if (ClassUtils.isAssignable(converter.getTargetType(), targetType, true)) {
                            @SuppressWarnings("unchecked")
                            Object result = converter.convert(value);
                            return result;
                        }
                    }
                }
            }

            return null;
        }

        @SuppressWarnings("unchecked")
        private <S, T> ResolvedTypeConverter<S, T> resolveTypeConverter(TypeConverter<S, T> converter) {
            Class<?>[] classes = TypeResolver.resolveRawArguments(TypeConverter.class, converter.getClass());
            return new ResolvedTypeConverter<>(converter, (Class<S>) classes[0], (Class<T>) classes[1]);
        }

        /**
         * 实现了{@link TypeConverter}的源和目标类型的实现。
         *
         * @param <S> 源 type
         * @param <T> 目标 type
         */
        static class ResolvedTypeConverter<S, T> implements TypeConverter<S, T> {

            private final TypeConverter<S, T> delegatingConverter;

            private final Class<S> sourceType;

            private final Class<T> targetType;

            ResolvedTypeConverter(TypeConverter<S, T> delegatingConverter, Class<S> sourceType,
                                  Class<T> targetType) {
                this.delegatingConverter = delegatingConverter;
                this.sourceType = sourceType;
                this.targetType = targetType;
            }

            public Class<S> getSourceType() {
                return sourceType;
            }

            public Class<T> getTargetType() {
                return targetType;
            }

            @Override
            public T convert(S source) {
                return delegatingConverter.convert(source);
            }

        }
    }

}
