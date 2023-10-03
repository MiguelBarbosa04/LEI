/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
import java.util.Scanner;

public class ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double number1, number2;
        
        
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Diga o número a : ");
        number1 = input.nextDouble();
        System.out.println("Diga o número B : ");
        number2 = input.nextDouble();

        System.out.println("Soma ->" + (number1 + number2));
        System.out.println("Subtracao ->" + (number1 - number2));
        System.out.println("Multiplicacao ->" + (number1 * number2));
        System.out.println("Divisao ->" + (number1 / number2));

    }

}
