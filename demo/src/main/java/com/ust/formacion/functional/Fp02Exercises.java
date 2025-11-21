package com.ust.formacion.functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<Integer> numbersAux;
        List<String> courses = List.of("Java", "Python", "JavaScript", "C++", "Spring", "Ruby", "Kotlin", "JavaScript");

        int sum = getSquareSum(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        sum = getCubeSum(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        sum = getOddSum(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        getDistinctsCourses(courses);
        System.out.println("-----------------");
        getSortedCourses(courses);
        System.out.println("-----------------");
        getDistinctsSortedCourses(courses);
        System.out.println("-----------------");
        numbersAux = getListWithEvenNumbers(numbers);
        System.out.println(numbersAux);
        System.out.println("-----------------");
        numbersAux = getListWithCoursesNamesLenght(courses);
        System.out.println(numbersAux);
        System.out.println("-----------------");

    }

    private static int getSquareSum(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream()
            .map(n-> n*n)
            .reduce(0,Integer::sum);
    } 

    private static int getCubeSum(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream()
            .map(n-> n*n*n)
            .reduce(0,Integer::sum);
    } 

    private static int getOddSum(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream()
            .filter(n->n%2!=0)
            .reduce(0,Integer::sum);
    } 

    private static void getDistinctsCourses(List<String> courses) {
        courses.stream().distinct().forEach(System.out::println);
    } 

    private static void getSortedCourses(List<String> courses) {
        courses.stream().sorted().forEach(System.out::println); //------>Natural Order 
        System.out.println("-----------------");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); //------>Reverse Natural Order 
        System.out.println("-----------------");
        courses.stream().sorted(Comparator.comparing(str->str.length())).forEach(System.out::println); //------>Custom order
        System.out.println("-----------------");
        courses.stream().sorted(Comparator.<String,Integer>comparing(str->str.length()).reversed()).forEach(System.out::println); //------>Reverse Custom order
    } 

    private static void getDistinctsSortedCourses(List<String> courses) {

        courses.stream().distinct().sorted().forEach(System.out::println);
    }

    private static List<Integer> getListWithEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
    }

    private static List<Integer> getListWithCoursesNamesLenght(List<String> courses) {
        return courses.stream().distinct().sorted().map(String::length).collect(Collectors.toList());
    }
}
