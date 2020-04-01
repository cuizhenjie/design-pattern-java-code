package com.czj.patterns.impl;

import com.czj.patterns.base.CompositeSpecification;
import com.czj.patterns.base.ISpecification;

/**
 * and的规格
 *
 * @author czj
 */
public class AndSpecification<T> extends CompositeSpecification<T> {

    /**
     * 传入的两个规格
     */
    private ISpecification<T> left;
    private ISpecification<T> right;

    public AndSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    /**
     * and操作
     *
     * @param candidate
     * @return
     */
    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) && this.right.isSatisfiedBy(candidate);
    }
}
