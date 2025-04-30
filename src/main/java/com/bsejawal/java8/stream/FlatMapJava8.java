package com.bsejawal.java8.stream;

import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Course {
    private String courseName;
    private List<String> students;
}


public class FlatMapJava8 {
    private static final List<List<Integer>> nestedNumbers = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
    );
    private static final List<String> sentences = Arrays.asList(
            "Java is powerful",
            "Streams are fun",
            "FlatMap is tricky"
    );
    private static final List<Course> courses = Arrays.asList(
            new Course("Math", Arrays.asList("Alice", "Bob")),
            new Course("Science", Arrays.asList("Charlie", "David")),
            new Course("Art", Arrays.asList("Eve", "Frank", "Grace"))
    );

    public static void main(String[] args) {

        //Question 1
//        flattenNestedIntegerList();

        //Question 2
//        getAllWordsFromListOfSentences();

        //Question 3
//        extractAllCharactersFromListOfSentences();

        //Question 4
//        listAllStudentsAcrossCourses();

        //Question 5
//        countUniqueStudents();

        //Question 6
//        GroupStudentsByFirstLetterOfTheirName();

        //Question 7
//        nestedFlatten();

        //Question 8
        allStudentCoursePairs();
    }

    /**
     * Question 1
     * Flatten nested integer list
     * 📌 From List<List<Integer>>, create a flat List<Integer>.
     */

    private static void flattenNestedIntegerList() {
        nestedNumbers.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    /**
     * Question 2
     * Get all words from list of sentences
     * 📌 Split each sentence by spaces and flatten into a single list of words.
     * Expected: ["Java", "is", "powerful", "Streams", "are", "fun", "FlatMap", "is", "tricky"]
     */
    private static void getAllWordsFromListOfSentences() {
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::println);
    }

    /**
     * Question 3
     * Unique characters from each sentence
     * 📌 Extract all characters from sentences, flatten them into a list of characters (as List<Character>), and remove duplicates.
     * Hint: Use flatMapToInt and distinct()
     */
    private static void extractAllCharactersFromListOfSentences() {

        sentences.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Question 4
     * List all students across courses
     * 📌 From List<Course>, get a flat List<String> of all student names.
     */
    private static void listAllStudentsAcrossCourses() {
        courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .forEach(System.out::println);
    }

    /**
     * Question 5
     * Count unique students
     * 📌 Using the same courses list, how many unique students are enrolled (some may appear in multiple courses)?
     */
    private static void countUniqueStudents() {
        Long count = courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .distinct()
                .collect(Collectors.counting());
        System.out.println(count);

    }

    /**
     * Question 6
     * Group students by first letter of their name
     * 📌 After flattening student names, group them by their starting character.
     * Result: Map<Character, List<String>>
     */
    private static void GroupStudentsByFirstLetterOfTheirName() {
        courses.stream()
                .flatMap(course -> course.getStudents().stream())
                .collect(Collectors.groupingBy(s -> s.charAt(0)))
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    }

    /**
     * Question 7
     * Flatten nested List<String> into single comma-separated String
     * List<List<String>> nestedWords = Arrays.asList(
     * Arrays.asList("a", "b"),
     * Arrays.asList("c", "d", "e")
     * );
     */
    private static void nestedFlatten() {
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d", "e")
        );
        String collect = nestedWords.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.joining(","));
        System.out.println(collect);


    }

    /**
     * Question 8
     * List all student-course pairs (cross product)
     * 📌 From List<Course>, create a List<String> like "Alice - Math", "Bob - Math", "Charlie - Science", etc.
     */
    private static void allStudentCoursePairs(){
        courses.stream()
                .flatMap(course -> course.getStudents().stream()
                        .map(student -> student +"-"+ course.getCourseName()))
                .forEach(System.out::println);
    }

}
