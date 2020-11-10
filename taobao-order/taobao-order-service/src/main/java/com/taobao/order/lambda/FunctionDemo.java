package com.taobao.order.lambda;

/**
 * @author Lawrence Li
 * @date 2020/11/6 10:25 AM
 */
public class FunctionDemo {

    public static void main(String[] args) {

//        useAddable((int a,int b) -> {
//            return a + b;
//        });

//        useAddable(( a, b) -> a + b);


//        useFlyable(param -> System.out.println(param));

        useFlyable(param -> System.out.println(param + "world"));

        Runnable r = () -> {
            int a = 10;
            System.out.println("hello world");
        };

    }

    public static void useAddable(Addable a){
        int add = a.add(10, 50);
        System.out.println(add);
    }

    public static void useFlyable(Flyable f){
        f.fly("hello world");
    }

}
