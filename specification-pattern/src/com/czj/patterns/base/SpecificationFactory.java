package com.czj.patterns.base;


import java.util.function.Function;

/**
 * 规格工厂类
 *
 * @author czj
 */
public class SpecificationFactory<T> extends CompositeSpecification<T> {

    private Function<T, Boolean> expression;

    public SpecificationFactory(Function<T, Boolean> expression) {
        if(expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.expression.apply(candidate);
    }
}
