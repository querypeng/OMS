package com.oms.shared.beans;

import net.sf.cglib.beans.BeanCopier;

import java.util.List;

/**
 *
 * @author shishi
 */
public interface WrapperBeanConverter {

    /**
     * 将给定源bean的属性值复制到目标bean中
     *
     * @param source 源bean
     * @param target 目标bean
     *
     * @see BeanCopier
     */
    void copyProperties(Object source, Object target);

    /**
     * 将给定的源bean转换为指定类型的目标bean
     *
     * @param source 源bean
     * @param clazz  指定类型的目标bean
     * @param <T>    目标类型
     *
     * @return 目标类型 <code>T</code>
     */
    <T> T convert(Object source, Class<T> clazz);

    /**
     * 将给定的源bean转换为指定类型的目标bean
     * @param source
     * @param clazz
     * @param <T>
     * @return 目标集合
     */
    <T> List<T> convert(List<?> source, Class<T> clazz);

}
