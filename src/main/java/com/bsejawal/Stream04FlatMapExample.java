package com.bsejawal;

import com.bsejawal.pojo.User;

import java.util.Arrays;
import java.util.List;



public class Stream04FlatMapExample {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Bhesh", 30, Arrays.asList("1", "2")),
                new User("Netra", 37, Arrays.asList("3", "4")),
                new User("Nimesh", 35, Arrays.asList("5", "6")),
                new User("Gopi Jung", 50, Arrays.asList("7", "8", "20")),
                new User("Narendra", 50, Arrays.asList("9", "10")),
                new User("Sabin", 28, Arrays.asList("11", "12"))
        );
        System.out.println("Functional Style");
        users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("13")))
                .findAny()
                .ifPresent(System.out::println);
    }

    private static boolean isNotNarendra(String name){
        return !name.equals("Narendra");
    }
}
