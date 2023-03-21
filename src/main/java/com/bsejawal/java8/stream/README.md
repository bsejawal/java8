#Java 8
## Interview Questions
### Question 1. Convert the following code into java8 functional equivalent
```java
    List<Integer> numbers = List.of(1,2,3,4,5);
    int total = 0;
    for(Integer i : numbers){
        if(i % 2 == 0 )
            total += i * i;
    }

```
#### Answer <br />
First approach:
```java
 int total = list.stream()
                .mapToInt( i -> {
                    if(i % 2 == 0)
                        return i * i;
                    else return 0;
                        }

                ).sum();
    System.out.println("total = " + total);
```
Second approach:
```java
    int total = list.stream()
        .filter(i-> i % 2 ==0)
        .mapToInt(i -> i * i)
        .sum();
    System.out.println("total = " + total);
```
## map() vs flatMap()

| map() | flatMap() |
| :---------- | :----------|
It processes stream of values | It processes stream of stream values
It does only mapping | It perform mapping as well as flattering
It's mapper function produces single value for each input value.| It's mapper function produces multiple values for each input value
It is a One-To-One mapping| It is a One-To-Many mapping
Data Transformation: From stream to stream| Data Transformation: From Stream to Stream to Stream
Use this method when the mapper function is producing a single value for each input value | Use this method when the mapper function is producing multiple values for each input value.