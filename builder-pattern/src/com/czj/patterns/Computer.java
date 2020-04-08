package com.czj.patterns;

/**
 * 产品类
 *
 * @author czj
 */
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
     * 内部静态 builder 类
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
}
