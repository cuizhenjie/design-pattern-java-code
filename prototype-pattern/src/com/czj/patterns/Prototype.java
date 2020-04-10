package com.czj.patterns;

/**
 * 原型类
 *
 * @author czj
 */
public class Prototype implements Cloneable {

    public void print(){
        System.out.println("原型模式实现类");
    }

    /**
     * 克隆自身方法
     *
     * @return
     */
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
