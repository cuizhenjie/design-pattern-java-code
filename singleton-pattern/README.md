# 单例模式（Singleton Pattern）

## Info

单例模式：确保一个类在全局仅有一个实例，并自行实例化并向整个系统提供这个实例，即为单例。
单例模式是一种**创建型模式**。

## 实现方式

这里仅罗列常用的两种方式，至于饿汉式及其他实现方式，感兴趣的可以网上搜索相关实现。

### 懒汉式 + 双重检验锁（线程安全）

使用 volatile 关键字可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。

```java

public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

```


### 静态内部类（线程安全）

当Singleton的类被加载时，静态内部类 SingletonHolder 没有被加载进内存。这种方式实现不仅延迟初始化，而且由虚拟机提供线程安全。

```java

public class Singleton {

    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}

```