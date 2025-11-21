package com.ust.formacion.functional;

import java.util.List;

public class Fp02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        int sum = addListFunctionalCustomFunction(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        sum = addListFunctionalWithLambda(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        sum = addListFunctionalGenericFunction(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        int max = getMax(numbers);
        System.out.println(max);
        System.out.println("-----------------");
        int min = getMin(numbers);
        System.out.println(min);
        System.out.println("-----------------");
    }
    
    public static int sum(int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

    private static int addListFunctionalCustomFunction(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream().reduce(0, Fp02Functional::sum);
    }

    private static int addListFunctionalWithLambda(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    private static int addListFunctionalGenericFunction(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static int getMax(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x > y ? x : y);
    }  

    private static int getMin(List<Integer> numbers) {
        //stream of numbers -> one result value
        return numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x < y ? x : y);
    }
}
