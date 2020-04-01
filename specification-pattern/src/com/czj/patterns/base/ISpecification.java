package com.czj.patterns.base;

/**
 * 规格接口
 *
 * @author czj
 */
public interface ISpecification<T> {

    /**
     * 是否满足条件
     *
     * @param candidate
     * @return
     */
    boolean isSatisfiedBy(T candidate);

    /**
     * and操作
     *
     * @param specification
     * @return
     */
    ISpecification<T> and(ISpecification<T> specification);

    /**
     * or操作
     *
     * @param specification
     * @return
     */
    ISpecification<T> or(ISpecification<T> specification);

    /**
     * not操作
     *
     * @return
     */
    ISpecification not();
}
