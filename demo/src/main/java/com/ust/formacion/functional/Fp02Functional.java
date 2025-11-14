package com.ust.formacion.functional;

import java.util.List;

public class Fp02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        int sum = addListFunctional(numbers);
    }
    
    public static int sum(int a, int b){
        return a + b;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //1 convertir la lista en un stream
        int sum = numbers.stream().reduce(0, Fp02Functional::sum);
        System.out.println(sum);
        System.out.println("-----------------");
        return sum;
    }
}
