/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_and_PArte2_ex1;

/**
 *
 * @author Miguel
 */
public class ex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayStack<Integer> stack = new ArrayStack<>();
        String postfixExpression = "3 4 + 5 *";
        Integer result = stack.evaluatePostfixExpression(postfixExpression);
        System.out.println("Resultado: " + result);
    }

}
