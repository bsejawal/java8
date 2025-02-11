package com.bsejawal.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03MapperIntExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bhesh", "Netra","Nimesh", "Gopi Jung", "Narendra", "Sabin");
        System.out.println("Functional Style");
        List<User03> userList =  names.stream()
                .filter(Stream03MapperIntExample::isNotNarendra)
                .map(User03::new)
                .collect(Collectors.toList());
        int sum =  userList.stream().mapToInt(User03::getAge)
                .sum();
        System.out.println(sum);


    }
    private static boolean isNotNarendra(String name){
        return !name.equals("Narendra");
    }
}

class User03{
    private String name;
    private Integer age;

    public User03(String name) {
        this.name = name;
        this.age = 30;
    }
    public User03(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
