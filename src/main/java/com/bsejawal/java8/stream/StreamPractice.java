package com.bsejawal.java8.stream;

import com.bsejawal.java8.stream.data.Employee;
import com.bsejawal.java8.stream.data.EmployeeDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> allEmployees = EmployeeDataBase.getAllEmployees();
        Double secondHighest = allEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .map(Employee::getSalary)
                .orElseThrow(() -> new IllegalStateException("Not found"));
        List<String> list = Arrays.asList("apple", "apple", "banana", "apple", "orange", "orange", "banana", "apple", "orange", "orange");
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
