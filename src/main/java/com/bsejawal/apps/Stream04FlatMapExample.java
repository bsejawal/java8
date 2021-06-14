package com.bsejawal.apps;

import com.bsejawal.pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Stream04FlatMapExample {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Bhesh", 30, Arrays.asList("14","62")),
                new User("Netra", 37, Arrays.asList("71","92")),
                new User("Nimesh", 35, Arrays.asList("19","092")),
                new User("Gopi", 50, Arrays.asList("451","2563")),
                new User("Narendra", 49, Arrays.asList("451","552")),
                new User("Sabin", 28, Arrays.asList("155","2552"))

        );

        System.out.println("Functional Style");
        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter( s ->  s.equals("14")))
                .findAny();
        stringOptional.ifPresent(System.out::println);


    }
    public static boolean isNotNarendra(String name){
        return !name.equals("Narendra");
    }
}
