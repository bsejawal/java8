package com.bsejawal.thread.executorservice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableTask {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        HttpClient httpClient = HttpClient.newHttpClient();

        // List to hold all CompletableFuture objects
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        // Submit 5 asynchronous API calls
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            CompletableFuture<Void> future = CompletableFuture
                    // Run the API call in the executor's thread pool
                    .supplyAsync(() -> {
                        try {
                            // Build the API request
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos/" + taskId))
                                    .build();

                            // Send the request (blocking call, but runs in the executor's thread)
                            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                        } catch (Exception e) {
                            throw new RuntimeException("API call failed for task " + taskId, e);
                        }
                    }, executor)
                    // Process the response asynchronously
                    .thenAccept(response -> {
                        System.out.printf("Task %d: Response Code %d | Body: %s%n",
                                taskId, response.statusCode(), response.body());
                    })
                    // Handle exceptions
                    .exceptionally(ex -> {
                        System.err.println("Error in Task " + taskId + ": " + ex.getCause().getMessage());
                        return null;
                    });

            futures.add(future);
        }

        // Wait for all futures to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // Shutdown the executor
        executor.shutdown();
    }
}

