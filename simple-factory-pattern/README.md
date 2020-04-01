# 简单工厂模式（Simple Factory Pattern）

## Info

简单工厂模式：是由一个工厂对象决定创建出哪一种产品类的实例，属于创建型模式。

- 优点：
    - 工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例，客户端可以免除直接创建产品对象的职责。
    - 客户端无需知道所创建具体产品的类名，只需知道参数即可。
    - 引入配置文件，可在不修改客户端代码的情况下更换和添加新的具体产品类。

- 缺点：
    - 工厂类集中了所有产品的创建逻辑，一旦不能工作，整个系统都受影响。
    - 使用简单工厂模式会增加系统中类的个数，增加系统的复杂度和理解难度。
    - 系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂。
    - 简单工厂模式使用了static工厂方法，造成工厂角色无法形成基于继承的等级结构。

- 适用场景：
    - 工厂类负责创建对的对象比较少，因为不会造成工厂方法中的业务逻辑过于复杂。
    - 客户端只知道传入工厂类的参数，对如何创建对象不关心。

## 实现方式

### 定义操作接口

```java

public interface Operation {

    /**
     * 计算方法
     * @param value1
     * @param value2
     * @return
     */
    int compute(int value1, int value2);
}

```

### 定义具体的操作类

```java

public class AddOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        return value1 + value2;
    }

}



public class MinusOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        return value1 - value2;
    }

}



public class MultiplyOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        return value1 * value2;
    }

}



public class DivideOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        if(value2 == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return value1 / value2;
    }

}


```

### 定义简单工厂类

```java

public class Factory {

    public static Operation createInstance(String symbol) {

        Operation instance = null;
        switch (symbol) {
            case "+":
                instance = new AddOperation();
                break;
            case "-":
                instance = new MinusOperation();
                break;
            case "*":
                instance = new MultiplyOperation();
                break;
            case "/":
                instance = new DivideOperation();
                break;
        }

        return instance;
    }

}

```

### 最后，调用示例

```java

public class App {

    public static void main(String[] args) {

        Operation addOperation = Factory.createInstance("+");
        Operation minusOperation = Factory.createInstance("-");
        Operation multiplyOperation = Factory.createInstance("*");
        Operation divideOperation = Factory.createInstance("/");

        System.out.println(addOperation.compute(2, 2));
        System.out.println(minusOperation.compute(2, 2));
        System.out.println(multiplyOperation.compute(2, 2));
        System.out.println(divideOperation.compute(2, 2));

    }
}

```

----
