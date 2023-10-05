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
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pair<Integer> intPair = new Pair<>(1, 2);
        Pair<String> stringPair = new Pair<>("Ola", "Tudo?");

        
        System.out.println(intPair.getFirst());
        System.out.println(intPair.getSecond());
        System.out.println(stringPair.getFirst());
        System.out.println(stringPair.getSecond());
       
        
        System.out.println(intPair.max());
    }

}
