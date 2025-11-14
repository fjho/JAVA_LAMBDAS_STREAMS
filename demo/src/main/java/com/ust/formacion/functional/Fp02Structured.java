package com.ust.formacion.functional;

import java.util.List;

public class Fp02Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        
        int sum = addListStructured(numbers);
        System.out.println(sum);
        System.out.println("-----------------");
        
    }  
    


    private static int addListStructured(List<Integer> numbers) {
        //how to loop?
        //how to store the sum?
        int result = 0;
        for (int number : numbers) {
            result = result + number;
        }
        return result;
    }
}
