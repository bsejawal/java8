package com.bsejawal.java8.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortAMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("five",5);
        unsortedMap.put("six",6);
        unsortedMap.put("one",1);
        unsortedMap.put("ten",10);
        unsortedMap.put("two",2);

        LinkedHashMap<String, Integer> sortedMap = unsortedMap.entrySet().stream().sorted((e1, e2) ->{
            return e1.getValue() - e2.getValue();
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("unsortedMap = " + unsortedMap);
        System.out.println("sortedMap = " + sortedMap);
    }

}
