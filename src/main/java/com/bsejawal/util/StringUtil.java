package com.bsejawal.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {
    public static void printArray(String[] strs){
        String s = String.join(", ", strs);
        System.out.println(s);
    }
}
