package com.ust.formacion.functional;

import java.util.List;

public class Fp01Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("Java", "Python", "JavaScript", "C++", "Spring", "Ruby", "Kotlin");
        printOddNumbersInListFunctional(numbers);
        printAllCoursesInListFunctional(courses);
        printSpringCoursesInListFunctional(courses);
        printlenghtName4CoursesInListFunctional(courses);
        printCubeOddNumbersInListFunctional(numbers);
        printAllLenghtNameCoursesInListFunctional(courses);
    }  

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        //filter - only odd numbers
        numbers.stream()
               .filter(number -> number % 2 != 0) //lambda expression
               .forEach(System.out::println);
        System.out.println("-----------------");
    }

    private static void printAllCoursesInListFunctional(List<String> courses) {
        courses.stream()
               .forEach(System.out::println);
        System.out.println("-----------------");
    }

    private static void printSpringCoursesInListFunctional(List<String> courses) {
        courses.stream()
               .filter(course -> course.contains("Spring"))
               .forEach(System.out::println);
        System.out.println("-----------------");
    }

    private static void printlenghtName4CoursesInListFunctional(List<String> courses) {
        courses.stream()
               .filter(course -> course.length()>=4)
               .forEach(System.out::println);
        System.out.println("-----------------");
    }


     private static void printCubeOddNumbersInListFunctional(List<Integer> numbers) {
        //filter - only even numbers
        numbers.stream()
               .filter(number -> number % 2 != 0) //lambda expression
               .map(number -> number * number * number)
               .forEach(System.out::println);
        System.out.println("-----------------");
    }  

    private static void printAllLenghtNameCoursesInListFunctional(List<String> courses) {
        courses.stream()
               .map(c -> c+": "+c.length())
               .forEach(System.out::println);
        System.out.println("-----------------");
    }
}
