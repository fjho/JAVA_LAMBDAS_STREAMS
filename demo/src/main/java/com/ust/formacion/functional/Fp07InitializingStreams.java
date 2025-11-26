package com.ust.formacion.functional;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class CourseDetailed2 {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public CourseDetailed2() {
    }

    public CourseDetailed2(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String toString() {
        return name + " " + category + " " + reviewScore + " " + numberOfStudents;
    }  
}

public class Fp07InitializingStreams {
    public static void main(String[] args) {
        //INITIALIZATIONS OF STREAMS
        System.out.println("-------------------------------INITIALIZATIONS OF STREAMS-------------------------------");
            //initialize stream with List.of()
            System.out.println("-------------------------------List.of()-------------------------------");
            System.out.println("Max: "+List.of(12,9,13,4,6,2,4,12,15).stream().peek(System.out::println).max(Integer::compare));

            System.out.println("-------------------------------");

            //initialize stream with Stream.of()
            System.out.println("-------------------------------Stream.of()-------------------------------");
            System.out.println("Max: "+Stream.of(12,9,13,4,6,2,4,12,15).peek(System.out::println).max(Integer::compare));
            Stream.of(new CourseDetailed2("Java", "Programming", 95, 2000)).forEach(System.out::println);
            
            System.out.println("-------------------------------");

            //initialize stream with Arrays.stream()
            //no need to box/unbox Integer to int or viceversa
            System.out.println("-------------------------------Arrays.stream()-------------------------------");
            int[] numbersArray = {12,9,13,4,6,2,4,12,15};
            System.out.println("Max: "+Arrays.stream(numbersArray).peek(System.out::println).max());

            System.out.println("-------------------------------");

            //initialize stream with Stream.builder()
            System.out.println("-------------------------------Stream.builder()-------------------------------");
            Stream<Integer> streamBuilder = Stream.<Integer>builder()
                                                    .add(12)
                                                    .add(9)
                                                    .add(13)
                                                    .add(4)
                                                    .add(6)
                                                    .add(2)
                                                    .add(4)
                                                    .add(12)
                                                    .add(15)
                                                    .build();
            System.out.println("Max: "+streamBuilder.peek(System.out::println).max(Integer::compare));
            System.out.println("-------------------------------");

            //Initialize stream with Stream.generate()
            System.out.println("-------------------------------Stream.generate()-------------------------------");
            Stream<String> streamGenerate = Stream.generate(() -> "element").limit(5);
            streamGenerate.forEach(System.out::println);
            System.out.println("-------------------------------");

            //initialize stream with IntStream.range() and IntStream.rangeClosed()
            System.out.println("Sum: "+IntStream.range(0, 10).peek(System.out::println).sum());
            System.out.println("-------------------------------");

            System.out.println("Sum: "+IntStream.rangeClosed(0, 10).peek(System.out::println).sum());
            IntStream.rangeClosed(0, 10).forEach(System.out::println);
            System.out.println("-------------------------------");

            IntStream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
            System.out.println("-------------------------------");

            IntStream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
            System.out.println("-------------------------------");

            IntStream.iterate(2, n -> n * 2).limit(10).forEach(System.out::println);
            System.out.println("-------------------------------");

        System.out.println("-------------------------------WORKING WITH BIG NUMBERS (BIGINTEGER)-------------------------------");
            //Esto devuelve 0 pq se pasa del maximo valor de un Integer
            System.out.println("Factorial: "+IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
            //Esto devuelve negativo pq se pasa del maximo valor de un Long
            System.out.println("Factorial: "+LongStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
            //para solucionarlo usar BigInteger
            System.out.println("Factorial: "+IntStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
            System.out.println("-------------------------------");

        
        System.out.println("-------------------------------JOINING ELEMENTS OF A STREAM------------------------------");
        List<String> names = List.of(
            "Ana", "Berta", "Carlos", "Daniel", "Eva", "Francisco", "Gabriela", "Hector", "Irene", "Javier"
        );
        List<String> names2 = List.of(
            "Ana", "Berta", "Carlos", "Daniel", "Eva", "Francisco", "Gabriela", "Hector", "Irene", "Javier"
        );

         //join al  elemnts of a list with comma
         System.out.println(names.stream().collect(Collectors.joining(", ")));
         System.out.println("-------------------------------");

         System.out.println("-------------------------------FLATMAPS------------------------------");
         //we want to split each name into an array of characters
         //1-first option->this dosent work because map returns an stream of String arrays
         List<String[]> splitNames = names.stream().map(name -> name.split("")).collect(Collectors.toList());
         System.out.println(splitNames);
         //[[Ljava.lang.String;@5010be6, [Ljava.lang.String;@685f4c2e, [Ljava.lang.String;@7daf6ecc, 
         // [Ljava.lang.String;@2e5d6d97, [Ljava.lang.String;@238e0d81, [Ljava.lang.String;@31221be2, [Ljava.lang.String;@377dca04, 
         // [Ljava.lang.String;@728938a9, [Ljava.lang.String;@21b8d17c, [Ljava.lang.String;@6433a2]

         //2-second option with flatMap->Works!
         //flatmap: replace each element of a stream with 
         List<String> splitNames2 = names.stream().map(name -> name.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
         System.out.println(splitNames2);

         System.out.println("-------------------------------");

         //create all possible couples of names (producto cartesiano)
         System.out.println(names.stream()
              .flatMap(name1 -> names2.stream().map(name2 -> List.of(name1, name2)))
              .collect(Collectors.toList()));


        System.out.println("-------------------------------");
        //create couples of names with the same number of characters
        System.out.println(names.stream()
             .flatMap(name1 -> names2.stream()
                 .filter(name2 -> name2.length() == name1.length())
                 .map(name2 -> List.of(name1, name2)))
             .collect(Collectors.toList()));
        System.out.println("-------------------------------");

        //create couples of names that are equal
        System.out.println(names.stream()
             .flatMap(name1 -> names2.stream()
                 .map(name2 -> List.of(name1, name2)))
                .filter(couple -> couple.get(0).equals(couple.get(1)))
             .collect(Collectors.toList()));
        System.out.println("-------------------------------");
    }
}
