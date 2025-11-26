package com.ust.formacion.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Fp11Threads {
    public static void main(String[] args) throws IOException {

        //threads example with procedimental approach
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("PROC: "+ Thread.currentThread().getName() + " - Count: " + i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();


        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");


        //thread example with functional approach
        Runnable runnable2 = () -> {
                    IntStream.rangeClosed(0, 10000).parallel()
                        .forEach(n->System.out.println("FUNC: "+ Thread.currentThread().getName() + " - Count: " + n));
                };

                
            Thread thread11= new Thread(runnable2);
            Thread thread22 = new Thread(runnable2);
            Thread thread33 = new Thread(runnable2);
            thread11.start();
            thread22.start();
            thread33.start();
    }
}
