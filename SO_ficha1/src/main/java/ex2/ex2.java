/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author migue
 */
public class ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double number1, number2;

        

        
        number1 = Integer.parseInt(args[0]);
        
        number2 = Integer.parseInt(args[0]);

        System.out.println("Soma ->" + (number1 + number2));
        System.out.println("Subtracao ->" + (number1 - number2));
        System.out.println("Multiplicacao ->" + (number1 * number2));
        System.out.println("Divisao ->" + (number1 / number2));

    }

}
