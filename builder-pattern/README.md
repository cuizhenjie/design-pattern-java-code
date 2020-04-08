# 建造者模式（Builder Pattern）

## Info

建造者模式：将一个复杂的对象，通过多个步骤一步步来构建实现，属于创建型模式。

- 优点：
    - 降低创建复杂对象的复杂度。
    - 易于解耦，将创建对象和构建过程进行解耦，使用相同的创建过程来得到不同的产品。
    - 易于拓展，增加具体建造者无需修改原有类的代码，符合“开闭原则”。

- 缺点：
    - 产品的组成部分必须相同，这限制了其使用范围。
    - 如果类内部变化复杂，会增加很多的建造者类。

- 适用场景：
    - 需要生成的对象有复杂的内部结构，这些对象具备共性。
    - 隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。

## 实现方式

### 创建

- 首先创建一个静态内部类，把外部所有属性拷贝到静态内部类中。
- 静态内部类包含一个公共 public 构造函数，将必须传递的参数作为构造参数传入；静态内部类中必须传递参数需以 final 修饰，这样屏蔽除除构造函数外的赋值风险。
- 如存在可选参数，在静态内部类中的可选参数定义中需有默认值。
- 静态内部类提供可选参数赋值入口，类似类属性的 setter 函数，并保证返回同一个 builder 对象。
- 静态内部类实现一个 builder 方法，返回要创建的外部类对象；同时外部类中实现一个私有的构造函数，把静态内部类作为构造参数。

```java

public class Computer {

    /**
     * 必选参数
     */
    private String display;
    private String os;

    /**
     * 可选参数
     */
    private boolean isBluetoothEnabled;
    private boolean isNetworkEnabled;

    public Computer(Builder builder) {
        this.display = builder.display;
        this.os = builder.os;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isNetworkEnabled = builder.isNetworkEnabled;

    }

    public String getDisplay() {
        return display;
    }

    public String getOs() {
        return os;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public boolean isNetworkEnabled() {
        return isNetworkEnabled;
    }

    @Override
    public String toString() {
        return "Computer [display=" + display + ", os=" + os + ", isBluetoothEnabled="
                + isBluetoothEnabled + ", isNetworkEnabled=" + isNetworkEnabled + "]";
    }

    /**
     * 内部静态类
     */
    public static class Builder {

        /**
         * 必选参数
         */
        private final String display;
        private final String os;

        /**
         * 可选参数
         */
        private boolean isBluetoothEnabled = true;
        private boolean isNetworkEnabled = false;

        public Builder(String display, String os) {
            this.display = display;
            this.os = os;
        }

        public Builder isBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Builder isNetworkEnabled(boolean isNetworkEnabled) {
            this.isNetworkEnabled = isNetworkEnabled;
            return this;
        }

        /**
         * 构建对象
         *
         * @return
         */
        public Computer builder() {
            return new Computer(this);
        }

    }
    
    
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("三星屏", "Android 原生 OS")
                .isBluetoothEnabled(true)
                .builder();

        System.out.println(computer.toString());
    }
    
}

```

----
