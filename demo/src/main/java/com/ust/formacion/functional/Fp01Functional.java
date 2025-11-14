package com.ust.formacion.functional;

import java.util.List;

public class Fp01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
    }  

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //1 convertir la lista en un stream
        numbers.stream()
               //2 por cada elemento del stream, llamar a la funcion correspondiente
               //className::methodName --> method reference
               .forEach(Fp01Functional::printNumber);

        //other way less code, no auxiliary method needed
        numbers.stream().forEach(System.out::println);
        System.out.println("-----------------");
    }

    private static void printNumber(int number) {
        System.out.println(number);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //filter - only even numbers
        numbers.stream()
               //.filter(Fp02Functional::isEven) //if the result is true, the number is included in the new stream
                .filter(number -> number % 2 == 0) //lambda expression
               .forEach(System.out::println);
        System.out.println("-----------------");
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

     private static void printSquareEvenNumbersInListFunctional(List<Integer> numbers) {
        //filter - only even numbers
        numbers.stream()
               .filter(number -> number % 2 == 0) //lambda expression
               .map(number -> number * number)
               .forEach(System.out::println);
        System.out.println("-----------------");
    }   
}
