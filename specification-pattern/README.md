# 规格模式（Specification Pattern）

## Info

规格模式：组合模式+策略模式的实现，经常在 DDD 中使用，用来将业务规则（通常是隐式业务规则）封装成独立的逻辑单元，从而将隐式业务规则提炼为显示概念，并达到代码复用的目的。
常用于数据查询，可任意组合复用查询条件。


## 实现方式

### 定义规格接口，核心方法 isSatisfiedBy()

```java
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

```

### 定义可以被复合的规则的抽象类

```java

public abstract class CompositeSpecification<T> implements ISpecification<T> {
    @Override
    public ISpecification<T> and(ISpecification<T> specification) {
        return new AndSpecification(this, specification);
    }
    @Override
    public ISpecification<T> or(ISpecification<T> specification) {
        return new OrSpecification(this, specification);
    }
    @Override
    public ISpecification<T> not() {
        return new NotSpecification(this);
    }
}

```

### and, not, or 相关子类实现

```java

public class AndSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> left;
    private ISpecification<T> right;

    public AndSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) && this.right.isSatisfiedBy(candidate);
    }
}



public class NotSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> specification;

    public NotSpecification(ISpecification<T> specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.specification.isSatisfiedBy(candidate);
    }
}



public class OrSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> left;
    private ISpecification<T> right;

    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) || this.right.isSatisfiedBy(candidate);
    }
}

```

### 便于使用，新增规格工厂类，接入 Lambda 以对泛型支持友好。

```java

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

```

### 调用示例

```java

public class App {

    public static void main(String[] args) {

        List<String> sourceList = new ArrayList();
        sourceList.add("123456789-");
        sourceList.add("===123-");
        sourceList.add("-1-");
        sourceList.add("super");

        // 规则1，字符中需包含-
        ISpecification<String> spec1 = new SpecificationFactory<>(s -> s.indexOf("-") > 0);
        // 规则2，字符长度需大于5
        ISpecification<String> spec2 = new SpecificationFactory<>(s -> s.length() > 9);
        // 规则3，字符==super
        ISpecification<String> spec3 = new SpecificationFactory<>(s -> s.equals("super"));

        // 规则1  and  规则2  or 规则3
        ISpecification<String> specifications = spec1.and(spec2)
                .or(spec3);

        sourceList.stream()
                .map(s -> specifications.isSatisfiedBy(s))
                .forEach(System.out::println);
    }
}


```

## 参考链接
[Specification-Pattern](https://cloud.tencent.com/developer/article/1528935)