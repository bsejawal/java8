package com.bsejawal.java8.stream;

import com.bsejawal.pojo.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrouppingBy {
    public static void main(String[] args) {
        findEmployeeNameGroupingByCity();

    }

    /**
     Question:
        Employee has two fields name and city. You need to find group by employee by city.
     input:
        name: Ram, city: Des Moines
        name: Hari, city: Fairfield
        name: Shyam, city: Des Moines
        name: Gita, city: Fairfield
     output:
        Des Moines: Ram, Shyam
        Fairfield: Hari, Gita
     **/
    public static void findEmployeeNameGroupingByCity() {

        List<Employee> employees = Arrays.asList(
                new Employee("Ram", "Des Moines"),
                new Employee("Hari", "Fairfield"),
                new Employee("Shyam", "Des Moines"),
                new Employee("Gita", "Fairfield")
        );
        Map<String, List<Employee>> groupBy = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("groupBy = " + groupBy);
        //gropingby city and print city and it's employee name only
        Map<String, List<String>> groupBy1 = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("groupBy1 = " + groupBy1);


    }

}
