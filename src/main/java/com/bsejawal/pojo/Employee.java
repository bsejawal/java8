package com.bsejawal.pojo;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee{
    private int empId;
    private String name;
    private int salary;
    private String city;
    private int empDeptId;
    private String status;

    public static List<Employee> getTestData(){
                List<Employee> employees = Arrays.asList(
                        Employee.builder()
                                .empId(1)
                                .name("Alice+")
                                .salary(6001)
                                .city("New York")
                                .empDeptId(103)
                                .status("INACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(1)
                                .name("Alice")
                                .salary(6000)
                                .city("New York")
                                .empDeptId(101)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(2)
                                .name("Bob")
                                .salary(7500)
                                .city("Los Angeles")
                                .empDeptId(102)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(3)
                                .name("Charlie")
                                .salary(5000)
                                .city("Chicago")
                                .empDeptId(101)
                                .status("INACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(4)
                                .name("David")
                                .salary(4500)
                                .city("Houston")
                                .empDeptId(103)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(5)
                                .name("Eve")
                                .salary(8000)
                                .city("Phoenix")
                                .empDeptId(102)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(6)
                                .name("Frank")
                                .salary(5500)
                                .city("Philadelphia")
                                .empDeptId(101)
                                .status("INACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(7)
                                .name("Grace")
                                .salary(7000)
                                .city("San Antonio")
                                .empDeptId(103)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(8)
                                .name("Heidi")
                                .salary(4800)
                                .city("San Diego")
                                .empDeptId(104)
                                .status("ACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(9)
                                .name("Ivan")
                                .salary(5200)
                                .city("Dallas")
                                .empDeptId(104)
                                .status("INACTIVE")
                                .build(),
                        Employee.builder()
                                .empId(10)
                                .name("Judy")
                                .salary(6200)
                                .city("San Jose")
                                .empDeptId(102)
                                .status("ACTIVE")
                                .build()
                );

                // Print to check
//                employees.forEach(System.out::println);
                return employees;
    }
}