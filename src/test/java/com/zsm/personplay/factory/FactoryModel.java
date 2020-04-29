package com.zsm.personplay.factory;

/**
 * created by zsm on 2020/4/28
 */
public class FactoryModel {

}
class ProductA{
    public void method1(){
        System.out.println("ProductA method1 executed");
    }
}

class Application{
    private ProductA getproductA(){
        return new ProductA();
    }
    ProductA getObject(){
       return getproductA();
    }
}