# 设计模式（Design Pattern）

软件设计模式（Software Design Pattern），又称设计模式，是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。
它描述了在软件设计过程中的一些不断重复发生的问题，以及该问题的解决方案。其目的是为了提高代码的可重用性、代码的可读性和代码的可靠性。

## 设计模式的七大原则

### 单一职责原则（Single Responsibility Principle, SRP）

单一职责原则规定一个类应该有且仅有一个引起它变化的原因，否则类应该被拆分。

作用：降低类耦合度、提高类可读性、提高系统维护性、降低变更引起的风险。

注：单一职责同样也适用于方法。一个方法应该尽可能做好一件事情。如果一个方法处理的事情太多，其颗粒度会变得很粗，不利于重用。

### 开闭原则（Open Closed Principle, OCP）

软件实体应当对扩展开放，对修改关闭。

作用：对软件测试友好、可提高代码的可复用性、可提供软件的可维护性。

### 里氏替换原则（Liskov Substitution Principle, LSP）

任何基类可以出现的地方，子类一定可以出现；子类可以扩展父类的功能，但不能改变父类原有的功能。

作用：克服重写父类造成的可复用变差问题、保证类的扩展不会给已有系统引入新的错误等。

### 依赖倒置原则（Dependence Inversion Principle, DIP）

高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象。

作用：降低类的耦合性、提高系统稳定性、减少并发开发造成风险、提供代码可读性和可维护性。

### 接口隔离原则（Interface Segregation Principle, ISP）

客户端不应该被迫依赖于它不使用的方法；要为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。

作用：将臃肿庞大的接口分解为多个粒度小的接口，预防外来变更的扩散、提高了系统的高内聚、保证系统的稳定性。

### 迪米特法则（Law of Demeter, LoD）

一个类对自己依赖的类知道的越少越好，也称最少知道原则。

作用：低耦合、高内聚。

### 组合/聚合复用原则（Composition/Aggregate Reuse Principle, CARP）

也称合成复用原则；在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。

作用：维持类的封装性、新旧类的耦合度低、复用灵活性高。

使用法则：
    1、子类是基类的一个特殊种类，而不是基类的一个角色。区分 `Has-A` 和 `Is-A` 。只有 `Is-A` 关系才符合继承关系，`Has-A` 关系应当用聚合来描述。
    2、永远不会出现需要将子类换成另外一个类的子类的情况。如果不能肯定将来是否会变成另外一个子类的话，就不要使用继承。
    3、子类具有扩展基类的责任，而不是具有置换掉（override）或注销掉（Nullify）基类的责任。如果一个子类需要大量的置换掉基类的行为，那么这个类就不应该是这个基类的子类。
    4、只有在分类学角度上有意义时，才可以使用继承。不要从工具类继承。

## 设计模式分类

- 创建型模式（五种）
    - 单例模式 [单例模式 Java 示例](./singleton-pattern)
    - 简单工厂模式 [简单工厂模式 Java 示例](./simple-factory-pattern)
    - 抽象工厂模式 [抽象工厂模式 Java 示例](./abstract-factory-pattern)
    - 建造者模式
    - 原型模式

- 结构型模式（七种）
    - 适配器模式 
    - 装饰器模式
    - 代理模式
    - 外观模式
    - 桥接模式
    - 组合模式
    - 享元模式

- 行为型模式（十一种）
    - 策略模式
    - 模板方法模式
    - 观察者模式
    - 迭代子模式
    - 责任链模式
    - 命令模式
    - 备忘录模式
    - 状态模式
    - 访问者模式
    - 中介者模式
    - 解释器模式

- 规格模式（设计模式外的一种）[规格模式 Java 示例](./specification-pattern)
    
## 参考链接

[面向对象设计原则](https://blog.csdn.net/fanyun_01/)
