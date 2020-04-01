package com.czj.patterns.base;

import com.czj.patterns.impl.AndSpecification;
import com.czj.patterns.impl.NotSpecification;
import com.czj.patterns.impl.OrSpecification;

/**
 * 可以被复合的规则的抽象类
 *
 * @author czj
 */
public abstract class CompositeSpecification<T> implements ISpecification<T> {

    /**
     * and操作
     *
     * @param specification
     * @return
     */
    @Override
    public ISpecification<T> and(ISpecification<T> specification) {
        return new AndSpecification(this, specification);
    }

    /**
     * or操作
     *
     * @param specification
     * @return
     */
    @Override
    public ISpecification<T> or(ISpecification<T> specification) {
        return new OrSpecification(this, specification);
    }

    /**
     * not操作
     *
     * @return
     */
    @Override
    public ISpecification<T> not() {
        return new NotSpecification(this);
    }
}
