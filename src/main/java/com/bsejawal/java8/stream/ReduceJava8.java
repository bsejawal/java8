package com.bsejawal.java8.stream;

import com.bsejawal.pojo.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceJava8 {
    public static final List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13);
    public static final List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
    public static final List<Employee> employees = Employee.getTestData();


    public static void main(String[] args) {
        //Question 1
//        findTheProduct();

        //Question 2
//        longestNameInList();

        //Question 3
//        sumOfAllSalaries();

        //Question 4
//        commaSeparatedStringFromList();

        //Question 5
//        highestSalary();

        //Question 6
//        countEvenNumbers();

        //Question 7
//        reverseAListInSingleString();

        //Question 8
        findAverageSalary();
    }


    /**
     * Question 1
     * Find the product of all numbers in the list.
     * Use reduce() to multiply all integers in numbers.
     */
    public static void findTheProduct() {
        int i = numbers.stream()
                .reduce((s, n) -> s * n)
                .get().intValue();
        System.out.println(i);
    }

    /**
     * Question 2
     * Find the longest name in the list using reduce.
     * Given a List<String>, use reduce() to find the longest string.
     */
    private static void longestNameInList() {
        String longestName = names.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2)
                .orElseGet(() -> "No name found");
        System.out.println("longestName = " + longestName);
    }

    /**
     * Question 3
     * Sum of all salaries using reduce (without Collectors.summingInt).
     * Use reduce() to sum all employee salaries.
     */
    private static void sumOfAllSalaries() {
        Optional<Integer> reduce =
                employees.stream()
                        .map(e -> e.getSalary())
                        .reduce((total, salary) -> total + salary);
        System.out.println("reduce = " + reduce.get());
    }

    /**
     * Question 4
     * Get a comma-separated string of names using reduce.
     * Example result: "Alice, Bob, Charlie, David"
     */
    private static void commaSeparatedStringFromList() {
        names.stream()
                .reduce((s1, s2) -> s1 + ", " + s2)
                .ifPresent(System.out::println);
    }

    /**
     * Question 5
     * Find the employee with the highest salary using reduce.
     * Combine employee objects in reduce() and keep the one with a higher salary.
     */
    private static void highestSalary() {
        employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .ifPresent(System.out::println);
    }

    /**
     * Question 6
     * Count even numbers using reduce (without filter or count).
     * Tricky one: manually count how many numbers in numbers list are even.
     */
    private static void countEvenNumbers(){
       int evenCount =  numbers.stream()
                .reduce(0, (count, num) -> count + (num % 2 == 0 ? 1 : 0), Integer::sum);
        System.out.println("evenCount = " + evenCount);

    }

    /**
     * Question 7
     * Reverse the list of strings using reduce.
     * Use reduce() to reverse a List<String> into a single string like "David Charlie Bob Alice"
     */
    private static void reverseAListInSingleString(){
        String s = names.stream()
                .reduce("", (acc, name) -> name + (acc.isEmpty() ? "":" ") + acc);
        System.out.println("reverseAList = " + s);

    }


    /**
     * Question 8
     * Find the average salary using reduce (manual version).
     * Compute total salary and count in a single pass using a custom object like Pair<Double, Integer>.
     */
    private static void findAverageSalary(){

        SalaryAccumulator result = employees.stream()
                .reduce(
                        new SalaryAccumulator(0.0, 0),
                        (acc, emp) -> new SalaryAccumulator(acc.total + emp.getSalary(), acc.count + 1),
                        SalaryAccumulator::combine
                );
        double average = result.count > 0 ? result.total/result.count : 0;
        System.out.println("average = " + average);


    }

}


class SalaryAccumulator {
    double total;
    int count;

    public SalaryAccumulator(double total, int count) {
        this.total = total;
        this.count = count;
    }

    public SalaryAccumulator combine(SalaryAccumulator other) {
        return new SalaryAccumulator(this.total + other.total, this.count + other.count);
    }
}

