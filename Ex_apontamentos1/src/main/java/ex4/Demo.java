/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

/**
 *
 * @author Miguel
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] chaves = new String[5];
        Integer[] valores = new Integer[5];

        Dicionario<String, Integer> dicionario = new Dicionario<>(5);

        dicionario.add("chave1", 10);
        dicionario.add("chave2", 20);

        System.out.println("Valor associado à chave1: " + dicionario.get("chave1")); // Deve imprimir 10
        System.out.println("Valor associado à chave2: " + dicionario.get("chave2")); // Deve imprimir 20
        System.out.println("Valor associado à chave3: " + dicionario.get("chave3")); // Deve imprimir null
    }

}
