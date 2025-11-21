package com.ust.formacion.functional;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);   

        //1- Functional Interface PREDICATE
        Predicate<Integer> predicate = n -> n % 2 == 0;
        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };

        //2- Functional Interface FUNCTION
        Function<Integer,Integer> mapper = n -> n * n;
        Function<Integer,Integer> mapper2 = new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };

        //3- Functional Interface CONSUMER
        Consumer<Integer> action = System.out::println;
        Consumer<Integer> action2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        /*
        numbers.stream()
            .filter(n -> n % 2 == 0)          //El parámetro de filter es una Functional interface PREDICATE, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es test(T t) que recibe un tipo T y devuelve un boolean
            .map(n -> n * n)                  //El parámetro de map es una Functional interface FUNCTION, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es R apply(T t) que recibe un tipo T y devuelve un tipo R
            .forEach(System.out::println);    //El parámetro de forEach es una Functional interface CONSUMER, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es void accept(T t) que recibe un tipo T y no devuelve nada  
         */
        numbers.stream()
            .filter(predicate2)          //El parámetro de filter es una Functional interface PREDICATE, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es test(T t) que recibe un tipo T y devuelve un boolean
            .map(mapper2)                //El parámetro de map es una Functional interface FUNCTION, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es R apply(T t) que recibe un tipo T y devuelve un tipo R
            .forEach(action2);           //El parámetro de forEach es una Functional interface CONSUMER, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es void accept(T t) que recibe un tipo T y no devuelve nada

        //4- Functional Interface BINARYOPERATOR
        BinaryOperator<Integer> accumulator = (a,b) -> a + b;                  //BinaryOperator implementado con una funcion lambda, es una subinterfaz de Function que recibe dos parametros del mismo tipo y devuelve un valor del mismo tipo
        BinaryOperator<Integer> accumulator2 = Integer::sum;                   //BinaryOperator implementado con una method reference, es una subinterfaz de Function que recibe dos parametros del mismo tipo y devuelve un valor del mismo tipo
        BinaryOperator<Integer> accumulator3 = new BinaryOperator<Integer>() { //BinaryOperator implementado con una clase anonima, es una subinterfaz de Function que recibe dos parametros del mismo tipo y devuelve un valor del mismo tipo
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };
        
        int sum = numbers.stream()
            .reduce(0, accumulator3); //El parámetro de reduce es una Functional interface BINARYOPERATOR, la funcion lambda implementa el unico metodo abstracto de dicha interfaz que es T apply(T t1, T t2) que recibe dos tipos T y devuelve un tipo T
        System.out.println("Sum: " + sum);

        //5- Functional Interface SUPPLIER
        //No tiene parametros de entrada y devuelve un valor
        Supplier<Integer> randomValueSupplier = () -> {
            Random rd = new Random();
            return rd.nextInt(100);
        };
        Supplier<Double> randomValueSupplier2 = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };

        System.out.println("Random Value: " + randomValueSupplier.get());

        //6- Functional Interface UNARYOPERATOR
        //Recibe un parametro de entrada y devuelve un valor del mismo tipo
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> square2 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };

        System.out.println("Square: " + square.apply(5));
        System.out.println("Square: " + square2.apply(10));     

        //7- Functional Interface BIPREDICATE recibe dos parametros de entrada y devuelve un boolean
        BiPredicate<Integer, Integer> isEqual = (a, b) -> a.equals(b);
        BiPredicate<Integer, Integer> isEqual2 = new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer a, Integer b) {
                return a.equals(b);
            }
        };

        System.out.println(("Is Equal: " + isEqual.test(5, 5)));
        System.out.println("Is Equal: " + isEqual2.test(5, 10));

        //8- Functional Interface BIFUNCTION recibe dos parametros de entrada y devuelve un valor
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> multiply2 = new java.util  .function.BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a * b;
            }
        };  
        
        System.out.println("Multiply: " + multiply.apply(5, 10));
        System.out.println("Multiply: " + multiply2.apply(3, 7));

        //9- Functional Interface BICONSUMER recibe dos parametros de entrada y no devuelve nada
        BiConsumer<Integer, Integer> printSum = (a, b) -> System.out.println(a + b);
        BiConsumer<Integer, Integer> printSum2 = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer a, Integer b) {
                System.out.println(a + b);
            }
        };  

        printSum.accept(5, 10);
        printSum2.accept(3, 7);

        
        IntBinaryOperator a1= (x,y) -> x + y;
        System.out.println(a1.applyAsInt(5, 6));
        IntConsumer a2= x -> System.out.println(x);
        IntFunction a3= x -> x * x;
        System.out.println(a3.apply(5));
        IntPredicate a4= x -> x % 2 == 0;
        System.out.println(a4.test(4));
        IntSupplier a5= () -> 42;
        System.out.println(a5.getAsInt());
        IntToLongFunction a6= x -> x * 100L;
        System.out.println(a6.applyAsLong(5));
        IntToDoubleFunction a7= x -> x * 100.0;
        System.out.println(a7.applyAsDouble(5));
        IntUnaryOperator a8= x -> x + 1;

        LongBinaryOperator a9= (x,y) -> x + y;
        System.out.println(a9.applyAsLong(5L, 6L));
        LongConsumer a10= null;
        LongFunction a11= null;
        LongPredicate a12= null;
        LongSupplier a13= null;
        LongToDoubleFunction a14= null;
        LongToIntFunction a15= null;
        LongUnaryOperator a16= null;

        DoubleBinaryOperator a17= (x,y) -> x + y;
        System.out.println(a17.applyAsDouble(5.0, 6.0));
        DoubleConsumer a18= null;
        DoubleFunction a19= null;
        DoublePredicate a20= null;
        DoubleSupplier a21= null;
        DoubleUnaryOperator a22= null;
        DoubleToIntFunction a23= null;
        DoubleToLongFunction a24= null;
    }
}
