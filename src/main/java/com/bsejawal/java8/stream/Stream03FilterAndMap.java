package com.bsejawal.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03FilterAndMap {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "Alex", 10000),
                new Employee(102, "Brian", 20000),
                new Employee(103, "Charles", 30000),
                new Employee(104, "David", 40000),
                new Employee(105, "Edward", 50000)
                );

        List<Integer> collect = employeeList.stream().filter(e -> e.salary < 40000).map(e -> e.salary).collect(Collectors.toList());
        System.out.println(collect);
    }
}

class Employee{
    int empId;
    String name;
    int salary;

    public Employee(int empId, String name, int salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
}