package com.bsejawal.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.regex.Pattern;

public class FilterJava8 {

    public static void main(String[] args) {

        Integer[] arr = new Integer[] { 100, 100, 9, 8, 200 };
        List<Integer> list = Arrays.asList(arr);
        OptionalDouble avg = list.stream().mapToInt(n -> n * n).filter(n -> n > 100).average();
        if (avg.isPresent())
            System.out.println(avg.getAsDouble());
        list.stream().mapToInt(n -> n * n).filter(n -> n > 100).forEach(System.out::println);
       Pattern p =  Pattern.compile("dfadf");
    }

}
