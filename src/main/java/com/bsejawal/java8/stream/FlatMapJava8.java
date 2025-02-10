package com.bsejawal.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapJava8 {
    public static void main(String[] args) throws Exception {
        List<Integer> list1 = Arrays.asList(1,2);
        List<Integer> list2 = Arrays.asList(4,5);
        List<Integer> list3 = Arrays.asList(7,8);
        List<List<Integer>> finalList = Arrays.asList(list1, list2, list3);
        List<Integer> finalListResult = finalList.stream().flatMap(x -> x.stream().map(y->y+10)).collect(Collectors.toList());
        System.out.println("finalListResult = " + finalListResult);

List<Customer> customers = getCustomers();
        System.out.println("customers = " + customers);

        List<String> phoneNumbers = customers.stream().flatMap(x -> x.phoneNumbers.stream()).collect(Collectors.toList());
        System.out.println("phoneNumbers = " + phoneNumbers);
        // with Object


    }

    public static List<Customer> getCustomers(){
        return
                Stream.of(
          new Customer(101, "Alex", "alex@gmail.com", Arrays.asList("98766556", "8878937875", "793579844")),
          new Customer(102, "Smith", "smith@gmail.com", Arrays.asList("98766556", "8878937875", "793579844")),
          new Customer(103, "Brian", "Brian@gmail.com", Arrays.asList("98766556", "8878937875", "793579844")),
          new Customer(104, "Andy", "Andy@gmail.com", Arrays.asList("98766556", "8878937875", "793579844")),
          new Customer(105, "Corry", "Corry@gmail.com", Arrays.asList("98766556", "8878937875", "793579844"))
        ).collect(Collectors.toList());
    }
}

class Customer{
    int id;
    String name;
    String email;
    List<String> phoneNumbers;

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
