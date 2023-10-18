/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3_ex4_and_Parte2_ex2;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedStack<Integer> stack = new LinkedStack<>();
        String postfixExpression = "3 4 + 5 *";
        int result = stack.evaluatePostfixExpression(postfixExpression);
        System.out.println("Resultado: " + result);

    }

}
