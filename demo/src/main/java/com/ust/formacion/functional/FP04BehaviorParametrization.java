package com.ust.formacion.functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04BehaviorParametrization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);   

        //Mucho codigo repetido solo para cambiar el comportamiento (condicion de filtrado)
        /*
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);

        numbers.stream()
            .filter(n -> n % 2 != 0)
            .forEach(System.out::println);
        */

        //Solucion: parametrizar el comportamiento mediante funciones lambda
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        printNumbersWithPredicate(numbers, isEven);
        printNumbersWithPredicate(numbers, isOdd);

        //Otra forma de llamar al metodo, creando la funcion lambda directamente en la llamada
        printNumbersWithPredicate(numbers, n -> n % 2 == 0);
        printNumbersWithPredicate(numbers, n -> n % 2 != 0);

        //toList() method only available in Java 16+
        //List<Integer> squaredNumbers = numbers.stream().map(n -> n * n).toList();

        //sustituimos esto por esto para parametrizar el comportamiento así la Function puede ser reutilizable
        //List<Integer> squaredNumbers2 = numbers.stream().map(mapper).collect(Collectors.toList());
        List<Integer> squaredNumbersWithFunction = listNumbersWithFunction(numbers, n -> n * n);
        List<Integer> cubedNumbersWithFunction = listNumbersWithFunction(numbers, n -> n * n * n);


        // Create a lambda that takes an integer and prints it
        java.util.function.Consumer<Integer> printLambda = n -> print(n);
        
        // Call the lambda
        printLambda.accept(5);
        
        // Or create and call directly
        ((java.util.function.Consumer<Integer>) n -> print(n)).accept(10);
    }

    private static void printNumbersWithPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
            .filter(predicate)
            .forEach(System.out::println);
    }

    private static List<Integer> listNumbersWithFunction(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
            .map(function)
            .collect(Collectors.toList());
    }

    private static void print(int number) {
        System.out.println(number);
    }
}
