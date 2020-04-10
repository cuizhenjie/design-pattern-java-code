# 原型模式（Prototype Pattern）

## Info

原型模式：用于创建重复的对象，同时又能保证性能，属于创建型模式。

- 优点：
    - 比 new 对象性能好很多。
    - 简化对象的创建。

- 缺点：
    - 产品的组成部分必须相同，这限制了其使用范围。
    - 必须实现 Cloneable 接口。

- 适用场景：
    - 重复创建相似对象时的场景。
    - 对象的创建过程比较复杂或有很多循环次数时。

## 实现方式

### 实现原型模式


```java

public class Prototype implements Cloneable {


    @Override
    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }

}


```

### 运行效果

```shell

    public static void main(String[] args) {
        Prototype cp = new Prototype();
        for(int i = 0; i < 10; i++){
            Prototype cloneCp = (Prototype) cp.clone();
            cloneCp.print();
        }
    }

```

## 深拷贝、浅拷贝概念

使用原型的时候就涉及深拷贝和浅拷贝用法的区别。


### 浅拷贝

浅拷贝是只拷贝基本数据类型，对象内的数组、引用对象都不拷贝而是指向同一个引用对象的地址；
这样就会造成多个对象修改一个引用数据类型时，都会发生改变。

### 深拷贝

深拷贝不仅会拷贝基本数据类型，同时也会将引用的数据类型也同时进行拷贝。


----
