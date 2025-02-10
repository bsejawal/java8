package com.bsejawal.java8.stream;

import com.bsejawal.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class GrouppingByJava8 {
    public static void main(String[] args) {
//        findEmployeeNameGroupingByCity();
        printTopSalaryEmployeeForEachDepartment();

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

    /**
     print top salary employee for each department
     */
    public static void printTopSalaryEmployeeForEachDepartment(){
        Map<Integer, Employee> topSalariesEmployee = getEmployeeData().stream()
                .collect(
                        Collectors.groupingBy(
                                e-> e.getEmpDeptId(),
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(e->e.getSalary())), Optional::get)
                        )
                );
        System.out.println("topSalariesEmployee = " + topSalariesEmployee);

    }


    private static List<Employee> getEmployeeData() {
        return Arrays.asList(
                new Employee(101, "siva", 101, "active", 2000),
                new Employee(102, "ready", 101, "active", 5000),
                new Employee(103, "raju", 102, "inactive", 6000),
                new Employee(104, "sunder", 102, "inaactive", 4000),
                new Employee(105, "sunil", 103, "active", 3500),
                new Employee(106, "sunath", 103, "inactive", 4200),
                new Employee(107, "suresh", 104, "active", 2050)
        );
    }

}
