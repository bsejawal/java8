package com.bsejawal.pojo;

public class Employee{
    private int empId;
    private String name;
    private int salary;
    private String city;
    private int empDeptId;
    private String status;

//    new Employee(101, "siva", 101, "active", 2000)
    public Employee(int empId, String name, int empDeptId, String status, int salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.empDeptId = empDeptId;
        this.status = status;
    }

    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public Employee(int empId, String name, int salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", empDeptId=" + empDeptId +
                ", status='" + status + '\'' +
                '}';
    }
}