package com.bsejawal.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapJava8 {
    public static void main(String[] args) {



        List<String> vehicles = Arrays.asList("bus", "car","train","flight","bicycle", "Motor Cycle");
        List<Integer> numbers = Arrays.asList(1,3,4,2,0,3,4,5,6,7,7,9);
        List<User> userList = Arrays.asList(
                new User("1", "Bhesh", "password@123", "bsejawal@gmail.com"),
                new User("2", "Seema", "seema@password", "simakhadka100@gmail.com"),
                new User("3", "Omkala", "omkala@secretPassword", "omkalasejawal@gmail.com"),
                new User("3", "Netra", "SecretPassword", "netrasejwal@gmail.com")
        );


        /* transform  to uppercase and collect in a separate list object   */
        List<String> vechicleInUpperCase = vehicles.stream().map(vehicle -> vehicle.toUpperCase()).collect(Collectors.toList());
        System.out.println(vechicleInUpperCase.toString());

        /* find the length of the element and print   */
        vehicles.stream().map(v -> v.length()).forEach(i-> System.out.print(i+" "));
        System.out.println();
        vehicles.stream().map(v -> v.length()).forEach(System.out::print); // method reference
        System.out.println();

        /* multiply and store into list */
        List<Integer> numberCollect = numbers.stream().map(n -> n * 3).collect(Collectors.toList());
        System.out.println(numberCollect);

        /*transform to another object */
        List<UserDTO> userDTOs = userList.stream().map(user -> new UserDTO(user.id, user.name, user.email)).collect(Collectors.toList());
        System.out.println("userDTOs = " + userDTOs);


    }
}
class User{
    String id;
    String name;
    String password;
    String email;

    public User(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
class UserDTO{
    String id;
    String name;
    String email;

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
