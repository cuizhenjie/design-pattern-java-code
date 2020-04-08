# 抽象工厂模式（Abstract Factory Pattern）

## Info

抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，属于创建型模式。

- 优点：
    - 将具体产品的创建延迟到具体的工厂的子类中，减少客户端和具体产品类之间的依赖，降低耦合性。
    - 新增一类产品时，只需增加具体产品类和对应的工厂子类，符合开闭原则。
    - 每个工厂子类负责创建对应的产品，符合单一职责。

- 缺点：
    - 规定了所有可能被创建的产品集合，产品簇中扩展新的产品困难。
    - 增加了系统的抽象性和理解难度。

- 适用场景：
    - 客户端（应用层）不依赖于产品类实例如何被创建、实现等细节。
    - 将一个系列的产品统一到一起创建。


## 实现方式

### 创建抽象工厂类

定义工厂的抽象类。

```java

public abstract class AbstractFactory {

    public abstract Pad createPad();

    public abstract Phone createPhone();
}

```

### 创建抽象产品类

定义抽象的产品类。

```java

public interface Pad {

    void playGame();

}

public interface Phone {

    void call();
}


```

### 创建具体产品类

定义具体的产品实现类。

```java

public class IPhone implements Phone {

    @Override
    public void call() {
        System.out.println("使用 iphone 手机拨打电话");
    }
}

public class MiPhone implements Phone {

    @Override
    public void call() {
        System.out.println("使用 小米手机拨打电话");
    }
}

public class ApplePad implements Pad {

    @Override
    public void playGame() {
        System.out.println("使用 苹果 pad 玩游戏");
    }
}

public class MiPad implements Pad {

    @Override
    public void playGame() {
        System.out.println("使用 小米 pad 玩游戏");
    }
}

```

### 创建具体工厂类

定义多种具体的工厂实现类。

```java

public class AppleFactory extends AbstractFactory {

    @Override
    public Pad createPad() {
        return new ApplePad();
    }

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

public class MiFactory extends AbstractFactory {

    @Override
    public Pad createPad() {
        return new MiPad();
    }

    @Override
    public Phone createPhone() {
        return new MiPhone();
    }
}

```

### 抽象工厂实例化方式

```java

public class App {

    public static void main(String[] args) {

        // 小米工厂
        AbstractFactory miFactory = new MiFactory();

        Pad miPad = miFactory.createPad();
        miPad.playGame();

        Phone miPhone = miFactory.createPhone();
        miPhone.call();


        // 苹果工厂
        AbstractFactory appleFactory = new AppleFactory();

        Pad iPad = appleFactory.createPad();
        iPad.playGame();

        Phone iPhone = appleFactory.createPhone();
        iPhone.call();
    }
}


```


## 以上遵循组合/聚合复用原则（Composition/Aggregate Reuse Principle, CARP）

也就是尽量使用组合聚合等关联关系来实现，其次考虑使用继承；因 Java 不支持多继承，而且子类继承父类将使得子类变得脆弱，一旦父类行为发生变化，子类也将受到影响。

- 抽象类：被继承体现的是："is a" 的关系。抽象类中定义的是该继承体系的共性功能。
- 接口：被实现体现的是："like a" 的关系。接口中定义的是该继承体系的扩展功能。

故抽象工厂类使用 abstract，其余产品类等使用 interface 定义。

----
