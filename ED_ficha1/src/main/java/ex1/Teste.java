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
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TwoTypePair<Integer, Integer> intPair = new TwoTypePair<>(5, 7);
        TwoTypePair<String, String> stringPair = new TwoTypePair<>("Primeiro", "Segundo");

        System.out.println("Int Pair:");
        System.out.println("First: " + intPair.getFirst());
        System.out.println("Second: " + intPair.getSecond());

        System.out.println("\nString Pair:");
        System.out.println("First: " + stringPair.getFirst());
        System.out.println("Second: " + stringPair.getSecond());
    }

}
