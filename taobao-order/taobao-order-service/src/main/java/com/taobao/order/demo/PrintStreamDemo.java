package com.taobao.order.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author Lawrence Li
 * @date 2020/10/22 11:25 AM
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream printStream = new PrintStream(new File("print.txt"));


        ArrayList<InputStream> list = new ArrayList<>();

        Iterator<InputStream> iterator = list.iterator();

        Enumeration<InputStream> enumeration = Collections.enumeration(list);

        Enumeration<InputStream> enu = new Enumeration<InputStream>(){

            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public InputStream nextElement() {
                return iterator.next();
            }
        };



    }
}
