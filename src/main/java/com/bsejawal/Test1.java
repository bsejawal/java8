package com.bsejawal;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
//        System.out.println("###################    ");


//        Write a Java program that takes an input array of characters, groups the repetitive characters, and returns the results in the form of a key-value pair array. The key represents the character, and the value represents the count of that character in the input array.
//
//        For example:
//
//        Given the input:
//
//        char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        Your program should produce the output:
//        String[] output = {"a:2", "b:2", "c:3"};
        char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
       Map<Character, Integer> map = new HashMap<>();
       for(char c: input)
           map.put(c, map.getOrDefault(c, 0) + 1);


    }

    public static String[] groupCharacters(char[] input){

        Map<Character, Integer> map = new HashMap<>();

        for(char c: input){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        return map.entrySet().stream()
                .map(entry -> entry.getKey() +":" + entry.getValue())
                .toArray(String[]::new);



    }
}