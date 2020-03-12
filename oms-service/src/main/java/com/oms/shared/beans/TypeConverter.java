package com.oms.shared.beans;

/**
 *
 * @author shishi
 */
@FunctionalInterface
public interface TypeConverter<S, T> {
    /**
     * 将源对象转换为目标对象
     *
     * @param source 源对象
     *
     * @return 目标对象
     */
    T convert(S source);
}
