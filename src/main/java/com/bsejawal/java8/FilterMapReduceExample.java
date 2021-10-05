package com.bsejawal.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class FilterMapReduceExample {
        public static void main(String[] args) {


            List<Integer> numbers = Arrays.asList(3,7,8,1,5,9);
            List<String> words = Arrays.asList("CoreJava", "Spring", "Hibernate");
            int sum = 0;
            for (int n : numbers){
                sum+=n;
            }
            System.out.println("sum = " + sum);

            //java8 approach
            int sum1 = numbers.stream().mapToInt(i->i).sum();
            System.out.println("sum1 = " + sum1);

            //java8 reduce approach
            Integer reduceSum = numbers.stream().reduce(0, (a,b)-> a+b);
            System.out.println("reduceSum = " + reduceSum);

            Integer reduceMultiplication = numbers.stream().reduce(1, (a,b) -> a*b);
            System.out.println("reduceMultiplication = " + reduceMultiplication);

            //Java8 method reference
            Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
            System.out.println("reduceSumWithMethodReference.get() = " + reduceSumWithMethodReference.get());

            Integer maxValue = numbers.stream().reduce(0,(a,b) -> a>b?a:b);
            System.out.println("maxValue = " + maxValue);

            Integer maxValueWithMethodReference = numbers.stream().reduce(Integer::max).get();
            System.out.println("maxValueWithMethodReference = " + maxValueWithMethodReference);

            String longestString =   words.stream().reduce((word1, word2)-> word1.length()>word2.length() ? word1 : word2).get();
            System.out.println("longestString = " + longestString);

            //getEmployees whose grade is A
            double avgSalary =  getEmployees().stream()
                    .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                    .map(employee -> employee.getSalary())
                    .mapToDouble(i->i)
                    .average().getAsDouble();
            System.out.println("avgSalary = " + avgSalary);

            double sumSalary =  getEmployees().stream()
                    .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                    .map(employee -> employee.getSalary())
                    .mapToDouble(i->i)
                    .sum();
            System.out.println("sumSalary = " + sumSalary);
        }

        static class Employee{
            private int id;
            private String name;
            private String grade;
            private double salary;

            public Employee(int id, String name, String grade, double salary) {
                this.id = id;
                this.name = name;
                this.grade = grade;
                this.salary = salary;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }
        }
        public static List<Employee> getEmployees(){
            return Stream.of(new Employee(101, "John", "A", 60000),
                    new Employee(109, "peter", "B", 30000),
                    new Employee(102, "mak", "A", 80000),
                    new Employee(103, "Kim", "A", 90000),
                    new Employee(104, "Json", "C", 15000))
                    .collect(Collectors.toList());
        }


}
