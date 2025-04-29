package com.bsejawal.java8.stream;

import com.bsejawal.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByJava8 {
    public static final List<Employee> employees = Employee.getTestData();

    public static void main(String[] args) {
        //Question 1
//        groupEmployeesByCity();

        //Question 2
//        groupEmployeesByDepartment();

        //Question 3
//        groupingByEmplomentStatus();

        //Question 4
//        sumOfSalaryInEachDepartment();

        //Question 5
//        highestSalaryInEachDepartment();

        //Question 6
//        groupByCitiAndThenStatus();

        //Question 7
//        groupBySalaryRange();

        //Question 8
//        employeeNameGroupByStatus();

        //Question 9
//        highestSalaryInADepartment();

        //Question 10
//        groupEmployeeWithOnlyActiveEmployees();

        //Question 11
        groupByDepartmentWithUniqueCitis();
    }

    /**
     * Question:1
     * Group employees by city:
     * Create a Map<String, List<Employee>> where the key is the city name.
     **/
    public static void groupEmployeesByCity() {
        // imperative method (before java8/stream)
        Map<String, List<Employee>> groupByCity = new HashMap<>();
        for (Employee employee : employees) {
            if (groupByCity.containsKey(employee.getCity())) {
                groupByCity.get(employee.getCity()).add(employee);
            } else {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(employee);
                groupByCity.put(employee.getCity(), employeeList);
            }
        }
        System.out.println("with imperative method" + groupByCity);

        //java8 Stream
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("#### number of employee in each employment status");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("#### number of employee in each department");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

    }


    /**
     * Question: 2
     * Group employees by department id (empDeptId):
     * Find how many employees are in each department.
     */
    public static void groupEmployeesByDepartment() {
        //imperative method (before java8/stream)
        Map<Integer, Integer> groupByDepartment = new HashMap<>();
        for (Employee employee : employees) {
            groupByDepartment.put(employee.getEmpDeptId(), groupByDepartment.getOrDefault(employee.getEmpDeptId(), 0) + 1);
        }
        System.out.println("with imperative method" + groupByDepartment);

        //java8/stream
        System.out.println("number of employee in each department with java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 3
     * Group employees by status ("ACTIVE"/"INACTIVE") and count them:
     * Return OR print a Map<String, Long> where key is status and value is number of employees.
     */
    public static void groupingByEmplomentStatus() {
        // imperative method before java8/stream
        Map<String, Long> groupingByEmploymentStatus = new HashMap<>();
        for (Employee employee : employees) {
            groupingByEmploymentStatus.put(employee.getStatus(), groupingByEmploymentStatus.getOrDefault(employee.getStatus(), 0L) + 1);
        }
        System.out.println("with imperative method" + groupingByEmploymentStatus);

        // java8/stream
        System.out.println("number of employee in each employment status with java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 4
     * Sum of salaries for each department (empDeptId):
     * Group employees by department and calculate total salary department-wise.
     */
    public static void sumOfSalaryInEachDepartment() {
        //imperative method (before java8/stream)
        Map<Integer, Integer> groupBySalary = new HashMap<>();
        for (Employee employee : employees) {
            if (groupBySalary.containsKey(employee.getEmpDeptId())) {
                groupBySalary.put(employee.getEmpDeptId(), groupBySalary.get(employee.getEmpDeptId()) + employee.getSalary());
            } else {
                groupBySalary.put(employee.getEmpDeptId(), employee.getSalary());
            }
        }
        System.out.println("with imperative method" + groupBySalary);


        //java8/stream
        System.out.println("sum of employee salary in each department with java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.summingInt(Employee::getSalary)))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 5
     * Find highest salary employee in each department:
     * Group by empDeptId and find the Employee with maximum salary.
     */
    public static void highestSalaryInEachDepartment() {
        //imperative method (before java8/stream)
        Map<Integer, Employee> highestSalaryEmployee = new HashMap<>();
        for (Employee employee : employees) {
            if (!highestSalaryEmployee.containsKey(employee.getEmpDeptId())) {
                highestSalaryEmployee.put(employee.getEmpDeptId(), employee);
            } else {
                if (employee.getSalary() > highestSalaryEmployee.get(employee.getEmpDeptId()).getSalary()) {
                    highestSalaryEmployee.put(employee.getEmpDeptId(), employee);
                }
            }
        }
        System.out.println("with imperative method" + highestSalaryEmployee);

        //java8/stream
        System.out.println("highest salary employee in each department with java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 6
     * Group employees by city and then by status (Nested grouping):
     * For each city, group employees based on their status ("ACTIVE"/"INACTIVE").
     * output: Map<String, Map<String, List<Employee>>>
     */
    public static void groupByCitiAndThenStatus() {
//imperative method (before java8/stream)
        Map<String, Map<String, List<Employee>>> groupByCitiAndThenStatus = new HashMap<>();
        for (Employee employee : employees) {
            String city = employee.getCity();
            String status = employee.getStatus();

            Map<String, List<Employee>> statusMap = groupByCitiAndThenStatus.getOrDefault(city, new HashMap<>());
            List<Employee> employeeList = statusMap.getOrDefault(status, new ArrayList<>());

            employeeList.add(employee);
            statusMap.put(status, employeeList);
            groupByCitiAndThenStatus.put(city, statusMap);
        }
        System.out.println("with imperative method" + groupByCitiAndThenStatus);

        //java8/stream
        System.out.println("groupByCitiAndStatus java8/stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.groupingBy(Employee::getStatus)))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 7
     * Group employees by salary slab (e.g., <5000, 5000-7000, >7000):
     * Example categories: "Low", "Medium", "High".
     */
    public static void groupBySalaryRange() {
        //imperative method (before java8/stream)
        Map<String, List<Employee>> groupBySalaryRange = new HashMap<>();
        for (Employee employee : employees) {
            if (employee.getSalary() < 500) {
                if (!groupBySalaryRange.containsKey("Low")) groupBySalaryRange.put("Low", new ArrayList<>());
                groupBySalaryRange.get("Low").add(employee);
            } else if (employee.getSalary() < 7000) {
                if (!groupBySalaryRange.containsKey("Medium")) groupBySalaryRange.put("Medium", new ArrayList<>());
                groupBySalaryRange.get("Medium").add(employee);
            } else {
                if (!groupBySalaryRange.containsKey("High")) groupBySalaryRange.put("High", new ArrayList<>());
                groupBySalaryRange.get("High").add(employee);
            }
        }
        System.out.println("with imperative method" + groupBySalaryRange);

        //java8/stream
        System.out.println("groupBySalaryRange java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(e -> {
                    if (e.getSalary() < 5000) return "Low";
                    else if (e.getSalary() < 7000) return "Medium";
                    else return "High";
                }))
                .entrySet()
                .forEach(System.out::println);

    }

    /**
     * Question 8
     * Group employees by status and collect names:
     * For each status, get a list of names (instead of Employee objects)
     */
    public static void employeeNameGroupByStatus() {
        // imperative method before java8/stream
        Map<String, List<String>> employeeNameGroupByStatus = new HashMap<>();
        for (Employee employee : employees) {
            if (!employeeNameGroupByStatus.containsKey(employee.getStatus()))
                employeeNameGroupByStatus.put(employee.getStatus(), new ArrayList<>());
            employeeNameGroupByStatus.get(employee.getStatus()).add(employee.getName());
        }
        System.out.println("with imperative method" + employeeNameGroupByStatus);

        // java8/stream
        System.out.println("number of employee in each employment status with java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.mapping(Employee::getName, Collectors.toList())))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 9
     * Find department with maximum total salary:
     * First group by empDeptId, sum their salaries, then find the highest one.
     */
    public static void highestSalaryInADepartment() {
        Map<Integer, Integer> totalSalaryEachDepartment = new HashMap<>();
        for (Employee employee : employees) {
            totalSalaryEachDepartment.put(employee.getEmpDeptId(), totalSalaryEachDepartment.getOrDefault(employee.getEmpDeptId(), 0) + employee.getSalary());
        }
        Map.Entry<Integer, Integer> entryWithMax = null;
        for (Map.Entry<Integer, Integer> entry : totalSalaryEachDepartment.entrySet()) {
            if (entryWithMax == null || entryWithMax.getValue() < entry.getValue()) {
                entryWithMax = entry;
            }
        }
        System.out.println("With Imperative method: " + entryWithMax.getKey() + " " + entryWithMax.getValue());

        //java8/stream
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.summingInt(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresentOrElse(e -> System.out.println("Department ID with " + e.getKey() + ", Total Salary " + e.getValue()),
                        () -> {
                            throw new RuntimeException("No Department found");
                        });
    }

    /**
     * Question 10
     * Group employees and filter only ACTIVE employees while grouping:
     * Group employees by department id, but include only those employees who are ACTIVE (without using filter() before collecting).
     * Can have an Empty INACTIVE list
     */
    public static void groupEmployeeWithOnlyActiveEmployees() {
        //imperative method
        Map<Integer, List<Employee>> employeeWithOnlyActiveEmployees = new HashMap<>();
        for (Employee employee : employees) {
            if (employee.getStatus() == "ACTIVE") {
                if (!employeeWithOnlyActiveEmployees.containsKey(employee.getEmpDeptId()))
                    employeeWithOnlyActiveEmployees.put(employee.getEmpDeptId(), new ArrayList<>());
                employeeWithOnlyActiveEmployees.get(employee.getEmpDeptId()).add(employee);
            }
        }
        System.out.println("with imperative method" + employeeWithOnlyActiveEmployees);

        // java8/stream
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.filtering(e-> e.getStatus().equals("ACTIVE"), Collectors.toList())))
                .entrySet()
                .forEach(System.out::println);
    }

    /**
     * Question 11
     * Group by Department and list unique cities employees belong to:
     * Result: Map<Integer, Set<String>> → department id to cities.
     */
    public static void groupByDepartmentWithUniqueCitis(){
        // imperative method (before java8/stream)
        Map<Integer, Set<String>> departmentWithUniqueCitis = new HashMap<>();
        for (Employee employee : employees) {
            if (!departmentWithUniqueCitis.containsKey(employee.getEmpDeptId())) departmentWithUniqueCitis.put(employee.getEmpDeptId(), new HashSet<>());
            departmentWithUniqueCitis.get(employee.getEmpDeptId()).add(employee.getCity());
        }
        System.out.println("with imperative method" + departmentWithUniqueCitis);

        //java8/stream
        System.out.println("groupByDepartmentWithUniqueCitis java8/Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDeptId, Collectors.mapping(Employee::getCity, Collectors.toSet())))
                .entrySet()
                .forEach(System.out::println);
    }

}


/**
 * INTERVIEW QUESTIONS
 * 🧠 Basic Level (using your Employee class)
 * 1. Group employees by city:
 * Create a Map<String, List<Employee>> where the key is the city name.
 * <p>
 * 2. Group employees by department id (empDeptId):
 * Find how many employees are in each department.
 * <p>
 * 3. Group employees by status ("ACTIVE"/"INACTIVE") and count them:
 * Return a Map<String, Long> where key is status and value is number of employees.
 * <p>
 * ⚡ Intermediate Level
 * 4. Sum of salaries for each department (empDeptId):
 * Group employees by department and calculate total salary department-wise.
 * <p>
 * 5 Find highest salary employee in each department:
 * Group by empDeptId and find the Employee with maximum salary.
 * <p>
 * 6. Group employees by city and then by status (Nested grouping):
 * For each city, group employees based on their status ("ACTIVE"/"INACTIVE").
 * <p>
 * 7. Group employees by salary slab (e.g., <5000, 5000-7000, >7000):
 * Example categories: "Low", "Medium", "High".
 * <p>
 * 8. Group employees by status and collect names:
 * For each status, get a list of names (instead of Employee objects).
 * <p>
 * 🔥 Advanced / Tricky Level
 * 9. Find department with maximum total salary:
 * First group by empDeptId, sum their salaries, then find the highest one.
 * <p>
 * 10. Group employees and filter only ACTIVE employees while grouping:
 * Group employees by department id, but include only those employees who are ACTIVE (without using filter() before collecting).
 * <p>
 * 11. Group by Department and list unique cities employees belong to:
 * Result: Map<Integer, Set<String>> → department id to cities.
 * <p>
 * 12. Multi-level Grouping: Department → Status → Employees:
 * Group first by empDeptId, and inside that by status ("ACTIVE"/"INACTIVE").
 * <p>
 * Custom mapping after grouping:
 * Group employees by city and collect the total salary per city (i.e., city-wise sum of salary).
 * <p>
 * ✨ Bonus Conceptual Questions
 * What is the difference between groupingBy and partitioningBy?
 * <p>
 * What happens if you use groupingByConcurrent instead of groupingBy?
 * <p>
 * When should you use collectingAndThen with groupingBy?
 * <p>
 * What if multiple employees have the same highest salary in a department? How would you handle a tie?
 * <p>
 * 🔥 Extra: Example Tricky Code Problem
 * Group employees by department ID and for each department, get the name of the employee with second highest salary. (not just highest)
 */