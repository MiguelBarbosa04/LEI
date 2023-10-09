/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4_wildcards;

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

        Dicionario<String, Integer> dicionario = new Dicionario<>();
        dicionario.add("chave1", 10);
        dicionario.add("chave2", 20);

        System.out.println("Valor para chave1: " + dicionario.get("chave1")); // Deve imprimir 10
        System.out.println("Valor para chave2: " + dicionario.get("chave2")); // Deve imprimir 20
        System.out.println("Valor para chave3: " + dicionario.get("chave3")); // Deve imprimir null
    }

}
