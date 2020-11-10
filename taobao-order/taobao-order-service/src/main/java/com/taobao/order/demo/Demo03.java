package com.taobao.order.demo;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Lawrence Li
 * @date 2020/10/30 3:11 PM
 */
public class Demo03 {
    public static void main(String[] args) {

//        String s = getString(() -> "james");
//        System.out.println(s);


//        int[] arr = {10,45,9,199,340};
//        Integer max = getMax(() -> {
//            int a = arr[0];
//            for (int i = 1; i < arr.length; i++) {
//
//            }
//            return a;
//        });
//        System.out.println(max);

        conString("Lebron James", param -> param.toUpperCase(), param -> System.out.println(new StringBuilder(param).reverse().toString()));
    }



    public static void conString(String name, Consumer<String> consumer1, Consumer<String> consumer2){
        consumer1.accept(name);
        consumer2.accept(name);
    }



    public static String getString(Supplier<String> sup){
        return sup.get();
    }


    public static Integer getMax(Supplier<Integer> sup){
        return sup.get();
    }


}
