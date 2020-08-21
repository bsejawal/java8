package com.bsejawal.pojo;

import java.util.List;
//src/main/java/com/bsejawal/pojo/User.java

public class User {
    private String name;
    private Integer age;
    private List<String> phoneNumbers;

    public User(String name, Integer age, List<String> phoneNumbers) {
        this.name = name;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
