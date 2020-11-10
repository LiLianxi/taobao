package com.taobao.order.demo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Lawrence Li
 * @date 2020/10/13 5:02 PM
 */
public class FileFilterDemo implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }
}
