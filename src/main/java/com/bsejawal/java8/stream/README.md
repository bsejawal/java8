## Java Stream Tricky Interview Questions

1. Given the list of employee below, find out following using stream APIs. Use following data : [EmployeeDataBase](https://github.com/bsejawal/java8/blob/master/src/main/java/com/bsejawal/java8/stream/cheatsheet/EmployeeDataBase.java)
    1. Find name of the employee whose salary is second highest
    2. Find name of the employee whose salary is Nth highest
    3. Find the count of employee in each Project where Employee can have many Project
    4. After finding count of employee in each Project print them like String[] projects = 'Banking System'=2, 'Healthcare Portal'=3
    5. Return a Employee name only whose projectCode is P001 where Employee can have many Projects
    6. Find the employee who has worked on the maximum number of distinct projects.

2. Given a list of integers: `` List<Integer> list= Arrays.asList(10,15,8,49,25,98,98,15,32, 101, 1002) `` find out following using Stream APIs
    1. All even numbers
    2. double of even numbers
    3. Numbers starting with 1
    4. find duplicates
    5. sort all values in descending order
    6. find maximum value element
    7. partition them into primes and non-primes using streams.
    8. Compute the sum of squares of all even numbers in the list
      ```
      imperative code look like this, you need to convert to java8 stream:
      int total = 0;
      for (Integer i : numbers) {
      if (i % 2 == 0)
           total += i * i;
      }
      ```
    8. From a stream of numbers, generate all pairs (as a list of int arrays of size 2) whose sum is even.
```
Input example: [1, 2, 3, 4, 5]
Output example: [(1,3), (2,4), (4,2), (3,1), ...]
```

3. What is the different between map() vs flatMap()

| map() | flatMap() |
| :---------- | :----------|
It processes stream of values | It processes stream of stream values
It does only mapping | It perform mapping as well as flattering
It's mapper function produces single value for each input value.| It's mapper function produces multiple values for each input value
It is a One-To-One mapping| It is a One-To-Many mapping
Data Transformation: From stream to stream| Data Transformation: From Stream to Stream to Stream
Use this method when the mapper function is producing a single value for each input value | Use this method when the mapper function is producing multiple values for each input value.

4. From following list of string
   ``` List<String> list = Arrays.asList("apple", "apple", "banana", "apple", "orange", "orange", "banana", "apple", "orange", "orange") ```
- Count second most frequent word in list
- find the longest string alphabetically.
- Given a list of strings, return a map where the keys are the first character of the string, and the value is the concatenation of all strings starting with that character, sorted alphabetically.
```
Input example: ["apple", "ant", "bat", "ball", "cat"]
Output example: { 'a': "antapple", 'b': "ballbat", 'c': "cat" }
```

6. You are given a String input = "abcdefgh";. Write a Java program using Java 8+ Streams to split the characters of the string into two new strings: One containing characters at even index. Another containing characters at odd index.
7.  Write a Java stream program that takes an input array of characters, groups the repetitive characters, and returns the results in the form of a key-value pair array. The key represents the character, and the value represents the count of that character in the input array.
#####
For example:
Given the input:

``` char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}; ```

Your program should produce the output:
``` String[] output = {"a:2", "b:2", "c:3"}; ``` 
