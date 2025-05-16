package com.bsejawal.thread.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class EmployeeDatabase {
    private static final File file = new File(Objects.requireNonNull(RunAsyncDemo.class.getClassLoader().getResource("employees.json")).getFile());
    public static  List<Employee> fetchEmployees() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
