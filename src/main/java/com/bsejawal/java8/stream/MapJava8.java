package com.bsejawal.java8.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapJava8 {
    public static final List<String> fullNames = Arrays.asList(
            "Alice Johnson", "Bob Smith", "Charlie Brown", "David", "Eva Green", "Frank Ocean"
    );
    public static final List<String> prices = Arrays.asList("19.99", "5.50", "12.30", "100.00");

    public static void main(String[] args) {
        //Question 1
//        commaSepratedListOfStringsToListOfIntegers();

        //Question 2
//        stringListToLocalDateList();

        //Question 3
//        listDoubleRoundTo2DecimalPlaces();

        //Question 4
//        extractFileExtension();

        //Question 5
//        mapWithAverage();

        //Question 6
//        sentancesToListOfStringOfWords();

//        Question 7
//        extractFirstNameOnly();

        //Question 8
//        getTheLengthOfNames();

        //Question 9
//        upperCaseLastNameOnly();

        //Question 10
//        reverseEachName();

        //Question 11
//        extractInitials();

        //Question 12
//        convertStringToBigDecimal();

        //Question 13
//        stringToInteger();

        //Question 14
        filterPriceGreaterThan10();
    }


    /**
     * Question 1
     * You have a List<String> of comma-separated numbers, like: ["1,2,3", "4,5", "6,7,8,9"]
     * Flatten them into a single List<Integer>
     * (Hint: first map String ➔ List<Integer> ➔ flatMap)
     */
    public static void commaSepratedListOfStringsToListOfIntegers() {
        List<String> list = Arrays.asList("1,2,3", "4,5", "6,7,8,9");
        // imperative method
        List<Integer> newIntegerList = new ArrayList<>();
        for (String str : list) {
            for (String s : str.split(",")) {
                newIntegerList.add(Integer.parseInt(s));
            }
        }
        System.out.println("Imperative method" + newIntegerList);

        //java8/stream
        System.out.println("java8/stream method");
        list.stream()
                .map(s -> Arrays.stream(s.split(",")).map(s1 -> Integer.parseInt(s1)).collect(Collectors.toList()))
                .flatMap(List::stream)
                .forEach(System.out::println);

        // in question the hint suggested using a map first and flatMap later, but if we use flatMap first and map later, it will reduce code
        list.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }

    /**
     * Question 2
     * You have List<String> of dates in yyyy-MM-dd format. ➔ Convert into List<LocalDate>.
     * (Think about LocalDate.parse() inside map.)
     */
    public static void stringListToLocalDateList() {
        List<String> list = Arrays.asList("2023-05-14", "2022-11-30", "2024-01-22", "2021-07-08", "2025-04-29",
                "2020-12-01", "2023-09-17", "2022-03-05", "2024-08-10", "2021-10-25");
        //imperative method
        List<LocalDate> newLocalDateList = new ArrayList<>();
        for (String str : list) {
            newLocalDateList.add(LocalDate.parse(str));
        }
        System.out.println("Imperative method" + newLocalDateList);

        //java8/stream map
        System.out.println("java8/stream method");
        list.stream()
                .map(LocalDate::parse)
                .forEach(System.out::println);
        //extra: change back to String and then joining in a single string with comma separated
        System.out.print("extra: joining : " +
                list.stream()
                        .map(LocalDate::parse)
                        .map(LocalDate::toString)
                        .collect(Collectors.joining(", ")));
    }

    /**
     * Question 3
     * You have a List<Double> of prices. ➔ Round each price to 2 decimal places and return a new list.
     * (BigDecimal + map.)
     */
    private static void listDoubleRoundTo2DecimalPlaces() {
        List<Double> prices = Arrays.asList(19.987, 5.499, 3.3333, 100.0);
        //imperative method
        List<String> bigDecimals = new ArrayList<>();
        for (Double price : prices) {
            BigDecimal bigDecimal = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
            bigDecimals.add(bigDecimal.toString());
        }
        System.out.println("bigDecimals = " + bigDecimals);

        //java8/stream map
        List<Double> doubleStream = prices.stream()
                .map(d -> BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .collect(Collectors.toList());
    }

    /**
     * Question 4
     * List<String> of file names:
     * ["report.docx", "summary.pdf", "presentation.ppt"]
     * Extract only file extensions into a Set<String>.
     * (map file ➔ extract substring ➔ collect to Set.)
     */
    private static void extractFileExtension() {
        List<String> files = Arrays.asList("report.docx", "summary.pdf", "presentation.ppt");
        //imperative method
        Set<String> extractedExtension = new HashSet<>();
        for (String file : files) {
            extractedExtension.add(file.split("\\.")[1]);
        }
        System.out.println(extractedExtension);

        //java8/stream map
        System.out.println("java8/stream map");
        files.stream()
                .map(s -> s.split("\\.")[1])
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    /**
     * Question 5
     * You have a Map<String, List<Integer>> representing subjects and scores.
     * {"Math" = [90, 80], "Physics" = [85, 75]}
     * ➔ Create a new Map<String, Double> where value is average score for each subject.
     * <p>
     * (map each List ➔ average inside collector.)
     */
    private static void mapWithAverage() {
        Map<String, List<Integer>> data = new HashMap<>();
        data.put("Math", Arrays.asList(90, 80));
        data.put("Physics", Arrays.asList(85, 75));

        //imperative method
        Map<String, Double> averageScore = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            int sum = 0;
            for (Integer score : entry.getValue()) {
                sum += score;
            }
            double avg = sum / entry.getValue().size();
            averageScore.put(entry.getKey(), avg);
        }
        System.out.println(averageScore);

        //java8/stream map
        System.out.println("java8/stream map");
//        Map<String, Double> collect =
        data.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToDouble(Integer::doubleValue)
                                .average()
                ))
                .forEach((k, v) -> System.out.println(k + ": " + v));


    }

    /**
     * Question 6
     * You have a List<String> of sentences. ➔ Get a list of words (splitting on space) — without using flatMap yet.
     * <p>
     * (Notice the difference if you use map vs flatMap!)
     */
    private static void sentancesToListOfStringOfWords() {
        List<String> sentences = Arrays.asList(
                "If you're visiting this page, you're likely here because you're searching for a random sentence. Sometimes a random word just isn't enough, and that is where the random sentence generator comes into play. By inputting the desired number, you can make a list of as many random sentences as you want or need. Producing random sentences can be helpful in a number of different ways.",
                "For writers, a random sentence can help them get their creative juices flowing. Since the topic of the sentence is completely unknown, it forces the writer to be creative when the sentence appears.",
                "There are a number of different ways a writer can use the random sentence for creativity. The most common way to use the sentence is to begin a story. Another option is to include it somewhere in the story. A much more difficult challenge is to use it to end a story. In any of these cases, it forces the writer to think creatively since they have no idea what sentence will appear from the tool.");
        //imperative method
        List<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            words.addAll(Arrays.asList(sentence.trim().replace(".", "").replace(",", "").split("\\s")));
        }
        System.out.println(words);

        //java8/Stream map
        sentences.stream()
                .map(s -> Arrays.asList(s.split("\\s")))
                .reduce(new ArrayList<>(), (acc, list) -> {
                    acc.addAll(list);
                    return acc;
                })
                .forEach(System.out::println);

        //with flatmap
        sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s")))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    /**
     * Question 7
     * Convert fullNames list to only first names (e.g., “Alice” from “Alice Johnson”).
     * Watch out for single names like “David”.
     * <p>
     * Expected Output: ["Alice", "Bob", "Charlie", "David", "Eva", "Frank"]
     */
    private static void extractFirstNameOnly() {
        //imperative method
        List<String> firstNames = new ArrayList<>();
        for (String s : fullNames) {
            if (s.contains(" "))
                firstNames.add(s.split("\\s")[1]);
            else
                firstNames.add(s);
        }
        System.out.println("firstNames = " + firstNames);

        //java8/stream
        fullNames.stream()
                .map(s -> s.contains(" ") ? s.split("\\s")[0] : s)
                .forEach(System.out::println);
    }

    /**
     * Question 8
     * Map each name to its length (number of characters).
     * Expected Output: [13, 9, 14, 5, 10, 11]
     */
    private static void getTheLengthOfNames() {
        fullNames.stream()
                .map(s -> s.length())
                .forEach(System.out::println);
    }

    /**
     * Question 9
     * Uppercase all last names only
     * 📌 Convert only the last name to uppercase. For example, "Alice Johnson" → "Alice JOHNSON".
     * <p>
     * Expected Output: ["Alice JOHNSON", "Bob SMITH", "Charlie BROWN", "David", "Eva GREEN", "Frank OCEAN"]
     */
    private static void upperCaseLastNameOnly() {
        fullNames.stream()
                .map(s -> {
                    if (s.contains(" ")) {
                        String[] split = s.split("\\s");
                        return split[0] + " " + split[1].toUpperCase();
                    } else {
                        return s;
                    }
                })
                .forEach(System.out::println);
    }

    /**
     * Question 10
     * Reverse each name
     * 📌 Convert "Alice Johnson" → "nosnhoJ ecilA".
     */
    private static void reverseEachName() {
        fullNames.stream()
                .map(fullName -> new StringBuilder(fullName).reverse().toString())
                .forEach(System.out::println);

    }

    /**
     * Question 11
     * Extract initials
     * 📌 Convert names to initials. "Alice Johnson" → "A.J.", "David" → "D."
     * <p>
     * Expected Output: ["A.J.", "B.S.", "C.B.", "D.", "E.G.", "F.O."]
     */
    private static void extractInitials() {
        fullNames.stream()
                .map(fullName -> {
                    int index = fullName.indexOf(" ");
                    if (index != -1)
                        return fullName.substring(0, 1) + ". " + fullName.substring(index + 1, index + 2) + ".";
                    else return fullName.substring(0, 1) + ". ";
                }).forEach(System.out::println);
    }

    /**
     * Question 12
     * Convert string prices to BigDecimal
     * 📌 Convert List<String> to List<BigDecimal> using .map().
     */
    public static void convertStringToBigDecimal() {
        prices.stream()
                .map(s -> new BigDecimal(s))
                .forEach(System.out::println);

    }

    /**
     * Question 13
     * Convert string prices to integers by truncating
     * 📌 "19.99" → 19, "5.50" → 5, etc.
     */
    public static void stringToInteger() {
        prices.stream()
                .map(s -> new BigDecimal(s).intValue())
                .forEach(System.out::println);
    }

    /**
     * Question 14
     * Filter only prices > 10 and collect as doubles
     * 📌 Use map + filter in chain. Final type: List<Double>
     */
    private static void filterPriceGreaterThan10() {
        prices.stream()
                .map(s -> new BigDecimal(s).doubleValue())
                .filter(p -> p > 10)
                .forEach(System.out::println);
    }
}
