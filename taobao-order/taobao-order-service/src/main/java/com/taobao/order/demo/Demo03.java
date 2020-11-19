package com.taobao.order.demo;

import lombok.var;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

//        conString("Lebron James", param -> System.out.println(param.toUpperCase()), param -> System.out.println(new StringBuilder(param).reverse().toString()));

        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        String[] arr = {"hello ","java"};
        Stream<String> arr1 = Stream.of(arr);



    }

    private static void convert(String name, Function<String, Integer> fun){
        Integer apply = fun.apply(name);
        System.out.println(apply);
    }


    private boolean checkString(String name, Predicate<String> pre1, Predicate<String> pre2){
       return pre1.and(pre2).test(name);
    }

    private boolean checkString(String name, Predicate<String> pre){
        boolean boo = pre.test(name);
        return boo;
    }

    private void printInfo(String[] strArray, Consumer<String> con1, Consumer<String> con2){

        for (String s : strArray) {
            con1.andThen(con2).accept(s);
        }
    }



    public static void conString(String name, Consumer<String> consumer1, Consumer<String> consumer2){
//        consumer1.accept(name);
//        consumer2.accept(name);
        consumer1.andThen(consumer2).accept(name);

    }



    public static String getString(Supplier<String> sup){
        return sup.get();
    }


    public static Integer getMax(Supplier<Integer> sup){
        return sup.get();
    }


}
