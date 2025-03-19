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
                Employee.builder().name("Ram").city("Des Moines").build(),
                Employee.builder().name("Hari").city("Fairfield").build(),
                Employee.builder().name("James").city("Des Moines").build(),
                Employee.builder().name("Jack").city("Fairfield").build(),
                Employee.builder().name("John").city("Des Moines").build()
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
                Employee.builder().empId(102).name("ready").empDeptId(101).status("active").salary(5000).build(),
                Employee.builder().empId(103).name("raju").empDeptId(102).status("inactive").salary(6000).build(),
                Employee.builder().empId(104).name("sunder").empDeptId(102).status("inactive").salary(4000).build(),
                Employee.builder().empId(105).name("sunil").empDeptId(103).status("active").salary(3500).build(),
                Employee.builder().empId(106).name("sunath").empDeptId(103).status("inactive").salary(4200).build(),
                Employee.builder().empId(107).name("suresh").empDeptId(104).status("active").salary(2050).build()
        );
    }

}
