package com.czj.patterns.impl;

import com.czj.patterns.base.CompositeSpecification;
import com.czj.patterns.base.ISpecification;

/**
 * not规格
 *
 * @author czj
 */
public class NotSpecification<T> extends CompositeSpecification<T> {

    /**
     * 传入的规格
     */
    private ISpecification<T> specification;

    public NotSpecification(ISpecification<T> specification) {
        this.specification = specification;
    }

    /**
     * not操作
     * @param candidate
     * @return
     */
    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.specification.isSatisfiedBy(candidate);
    }
}
