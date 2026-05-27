package com.example;

import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кубын ирмэг: ");
        double side = scanner.nextDouble();
        Cube cube = new Cube(side);
        System.out.printf("Кубын талбай: %.1f\n", cube.calculateSquare());
        System.out.printf("Кубын эзэлхүүн: %.1f\n",  cube.calculateVolume());
        // System.out.println("Кубын эзэлхүүн: " + cube.calculateVolume());
        scanner.close();
    }
}
