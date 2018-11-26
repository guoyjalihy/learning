package com.xiao.designpatterns.factory.example.product;

public abstract class Pizza {
    public abstract String getName();
    public void prepare(){
        System.out.println("准备披萨");
    }
    public void bake(){
        System.out.println("烤披萨");
    }
    public void cut(){
        System.out.println("切披萨");
    }
    public void box(){
        System.out.println("打包披萨");
    }
}
