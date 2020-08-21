package com.bsejawal;

import java.util.Arrays;
import java.util.List;

//C:\Users\BSEJA\OneDrive - Bayer\Desktop\git-pull-request\java8stream\src\main\java\com\bsejawa\Stream01FilterExample.java

public class Stream01FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bhesh", "Netra","Nimesh", "Gopi Jung", "Narendra", "Sabin");
        System.out.println("Functional Style");
        names.stream()
                .filter(Stream01FilterExample::isNotNarendra)
                .forEach(System.out::println);
    }
    private static boolean isNotNarendra(String name){
        return !name.equals("Narendra");
    }
}
