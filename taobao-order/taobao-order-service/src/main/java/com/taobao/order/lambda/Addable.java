package com.taobao.order.lambda;

/**
 * @author Lawrence Li
 * @date 2020/11/6 10:55 AM
 */
public interface Addable {

    int add(int a, int b);

    default void show(){
        System.out.println("hello ");
    }

    default void show3(){

    }

    static void method1(){
        System.out.println("hi");
    }
    static void method2(){

    }


//    private void hello(){
//        System.out.println();
//    }
}
