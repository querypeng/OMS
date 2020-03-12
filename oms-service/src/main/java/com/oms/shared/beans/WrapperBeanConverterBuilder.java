package com.oms.shared.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建器类，用于构建{@link WrapperBeanConverterImpl}。
 *
 * @author shishi
 */
public class WrapperBeanConverterBuilder {

    /**
     * {@link TypeConverter}列表进行转换。
     */
    private List<TypeConverter<?, ?>> converters;

    private WrapperBeanConverterBuilder() {
        this.converters = new ArrayList<>();
    }

    /**
     * 构造一个新的 {@link WrapperBeanConverterBuilder}。
     *
     * @return 新的 {@link WrapperBeanConverterBuilder}
     */
    public static WrapperBeanConverterBuilder create() {
        return new WrapperBeanConverterBuilder();
    }

    /**
     * 将{@link TypeConverter}放入构建器
     *
     * @param converter the {@link TypeConverter} to put
     *
     * @return 原始的 {@link WrapperBeanConverterBuilder}
     */
    public WrapperBeanConverterBuilder registerConverter(TypeConverter<?, ?> converter) {
        converters.add(converter);
        return this;
    }

    /**
     * 构建 {@link WrapperBeanConverterImpl}.
     *
     * @return  {@link WrapperBeanConverterImpl}
     */
    public WrapperBeanConverter build() {
        return new WrapperBeanConverterImpl(converters);
    }
}
