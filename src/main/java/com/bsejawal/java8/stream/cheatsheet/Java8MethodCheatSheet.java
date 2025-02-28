package com.bsejawal.java8.stream.cheatsheet;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8MethodCheatSheet {
    public static void main(String[] args) {
        List<Employee> allEmployees = EmployeeDataBase.getAllEmployees();

        /**
         * forEach - forEach takes Consumer functionalInterface, Consumer interface has accept(T t) method but returns nothing
         */
        allEmployees.forEach(e -> System.out.println(e.getName() +" : " + e.getSalary()));
        allEmployees.forEach(System.out::print);

        /**
         * filter - filter takes Predicate, predicate has test(T t) method and returns boolean
         *  collect
         */
        Map<Integer, String> itDepartment = allEmployees.stream()
                .filter(e -> e.getDept().equals("IT") && e.getSalary() > 80000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(itDepartment);

        /**
         * map - map takes Function, and return stream, Function has method apply(T t) and return generic type R;
         * distinct
         */
        List<String> dept = allEmployees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(dept);

        /**
         * flatMap -
         */
        List<String> projectNames = allEmployees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(projectNames);

        /**
         * sorted
         */
        List<Employee> sortedEmployee = allEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("sortedEmployee = " + sortedEmployee);

        List<Employee> reverseOrderSortedEmployee = allEmployees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList());
        System.out.println("reverseOrderSortedEmployee = " + reverseOrderSortedEmployee);

        /**
         * min & max
         */
        Optional<Employee> minSalariedEmployee = allEmployees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println("minSalariedEmployee = " + minSalariedEmployee);
        Optional<Employee> maxSalariedEmployee = allEmployees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("maxSalariedEmployee = " + maxSalariedEmployee);

        /**
         * Groupingby
         */
        Map<String, List<Employee>> groupingby = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("groupingby = " + groupingby);
        //
        Map<String, List<String>> groupingByGenderAndListNameOnly = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("groupingByGenderAndListNameOnly = " + groupingByGenderAndListNameOnly);

        //grouping by count
        Map<String, Long> groupingByCounting = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.counting())));
        System.out.println("groupingByCounting = " + groupingByCounting);

        //findFirst
        Optional<Employee> findFirst = allEmployees.stream()
                .filter(e -> e.getDept().equals("IT"))
                .findFirst();
        if(findFirst.isPresent()) {
            System.out.println("findFirst = " + findFirst.get());
        }
        findFirst.ifPresent(e -> System.out.println(e.getName() +" : " + e.getDept()));


        //findAny
        allEmployees.stream()
                .filter(e -> e.getDept().equals("IT"))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("Employee not found"));

        // anyMatch, allMatch, noneMatch
        boolean anyMatch = allEmployees.stream()
                .anyMatch(e -> e.getDept().equals("IT"));

        //anymatch
        boolean allMatch = allEmployees.stream()
                .allMatch(e -> e.getSalary() > 50000);
        System.out.println("allMatch = " + allMatch);

        //nonMatch
        boolean nonMatch = allEmployees.stream()
                .allMatch(e-> e.getDept().equals("ABC"));
        System.out.println("nonMatch = " + nonMatch);

        //limit(long)
        List<Employee> topPaidEmployees = allEmployees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("topPaidEmployees = " + topPaidEmployees);

        //skip(long)
        List<Employee> skip = allEmployees.stream()
                .skip(5)
                .collect(Collectors.toList());


    }
}
