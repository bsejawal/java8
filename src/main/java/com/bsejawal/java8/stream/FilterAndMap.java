package com.bsejawal.java8.stream;

import com.bsejawal.pojo.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMap {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                Employee.builder().empId(101).name("Alex").salary(10000).build(),
                Employee.builder().empId(102).name("Brian").salary(20000).build(),
                Employee.builder().empId(103).name("Charles").salary(30000).build(),
                Employee.builder().empId(104).name("David").salary(40000).build(),
                Employee.builder().empId(105).name("Edward").salary(50000).build()
                );

        List<Integer> collect = employeeList.stream().filter(e -> e.getSalary() < 40000).map(e -> e.getSalary()).collect(Collectors.toList());
        System.out.println(collect);
    }
}

