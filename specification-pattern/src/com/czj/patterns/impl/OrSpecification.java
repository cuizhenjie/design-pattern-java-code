package com.czj.patterns.impl;

import com.czj.patterns.base.CompositeSpecification;
import com.czj.patterns.base.ISpecification;

/**
 * or的规格
 *
 * @author czj
 */
public class OrSpecification<T> extends CompositeSpecification<T> {

    /**
     * 传入两个规格
     */
    private ISpecification<T> left;
    private ISpecification<T> right;

    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    /**
     * or操作
     *
     * @param candidate
     * @return
     */
    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) || this.right.isSatisfiedBy(candidate);
    }
}
