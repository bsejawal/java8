package com.bsejawal.java8.stream.cheatsheet;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataBase {
    public static List<Employee> getAllEmployees() {
        // Sample projects
        Project project1 = Project.builder().projectCode("P001").name("AI Chatbot").client("Google").buLeadName("John Doe").build();
        Project project2 = Project.builder().projectCode("P002").name("E-commerce Platform").client("Amazon").buLeadName("Jane Smith").build();
        Project project3 = Project.builder().projectCode("P003").name("Healthcare Portal").client("UnitedHealth").buLeadName("Alice Johnson").build();
        Project project4 = Project.builder().projectCode("P004").name("Banking System").client("JP Morgan").buLeadName("Bob Martin").build();
        Project project5 = Project.builder().projectCode("P005").name("Social Media Analytics").client("Meta").buLeadName("Charlie Adams").build();
        Project project6 = Project.builder().projectCode("P006").name("Cloud Migration").client("Microsoft").buLeadName("Daniel Brown").build();
        Project project7 = Project.builder().projectCode("P007").name("Cybersecurity Enhancement").client("IBM").buLeadName("Eve Wilson").build();
        Project project8 = Project.builder().projectCode("P008").name("Retail AI Assistant").client("Walmart").buLeadName("Frank Carter").build();
        Project project9 = Project.builder().projectCode("P009").name("Logistics Optimization").client("FedEx").buLeadName("Grace Hall").build();
        Project project10 = Project.builder().projectCode("P010").name("Education Platform").client("Coursera").buLeadName("Hannah White").build();

        // Sample employees
        Employee emp1 = Employee.builder().id(101).name("Alice Brown").dept("IT").projects(Arrays.asList(project1, project2)).salary(85000).gender("Female").build();
        Employee emp2 = Employee.builder().id(102).name("Bob White").dept("Finance").projects(Arrays.asList(project3, project6)).salary(78000).gender("Male").build();
        Employee emp3 = Employee.builder().id(103).name("Charlie Green").dept("HR").projects(Arrays.asList(project2, project4, project7)).salary(72000).gender("Male").build();
        Employee emp4 = Employee.builder().id(104).name("David Black").dept("IT").projects(Arrays.asList(project1, project5)).salary(91000).gender("Male").build();
        Employee emp5 = Employee.builder().id(105).name("Eve Blue").dept("Marketing").projects(Arrays.asList(project3, project8)).salary(68000).gender("Female").build();
        Employee emp6 = Employee.builder().id(106).name("Frank Gray").dept("Operations").projects(Arrays.asList(project6, project9)).salary(75000).gender("Male").build();
        Employee emp7 = Employee.builder().id(107).name("Grace Hall").dept("IT").projects(Arrays.asList(project5, project10)).salary(89000).gender("Female").build();
        Employee emp8 = Employee.builder().id(108).name("Hannah White").dept("Finance").projects(Arrays.asList(project4, project7)).salary(83000).gender("Female").build();
        Employee emp9 = Employee.builder().id(109).name("Isaac Brown").dept("Legal").projects(Arrays.asList(project8, project9)).salary(70000).gender("Male").build();
        Employee emp10 = Employee.builder().id(110).name("Jack Wilson").dept("IT").projects(Arrays.asList(project1, project3, project10)).salary(94000).gender("Male").build();

        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10);
    }
}
