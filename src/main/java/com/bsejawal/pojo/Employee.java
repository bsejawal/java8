package com.bsejawal.pojo;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee{
    private int empId;
    private String name;
    private int salary;
    private String city;
    private int empDeptId;
    private String status;
}