package com.oms.shared.beans;

import net.sf.cglib.beans.BeanCopier;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * {@link BeanCopier}的包装器wrapper类，在JavaBean之间提供便利和高性能的转换
 *
 * @author shishi
 */
public class WrapperBeanCopier {

    /**
     * 存储用于转换的源类型和类类型的{@link BeanCopier}的映射
     */
    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    private WrapperBeanCopier() {
    }

    /**
     * 将给定源bean的属性值复制到目标bean中
     *
     * @param source 源bean
     * @param target 目标bean
     *
     * @see BeanCopier
     */
    public static void copyProperties(Object source, Object target) {
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(target, "target must not be null");

        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    /**
     * 将给定的源bean转换为指定类型的目标bean
     *
     * @param source 源bean
     * @param clazz  指定类型的目标bean
     * @param <T>    目标类型
     *
     * @return 指定类型的目标bean <code>T</code>
     */
    public static <T> T convert(Object source, Class<T> clazz) {
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
     * @return  指定类型的目标集合   <code>T</code>
     */
    public static <T> List<T> convert(List<?> source, Class<T> clazz){
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
    private static BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
        String key = generateKey(source, target);
        return BEAN_COPIER_MAP.computeIfAbsent(key, x -> BeanCopier.create(source, target, false));
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
    private static String generateKey(Class<?> source, Class<?> target) {
        return source.getCanonicalName().concat(target.getCanonicalName());
    }

}

