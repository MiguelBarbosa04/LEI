/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author migue
 */
public class ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        char[] nome = {'A', 'n', 'a', ' ', 'S', 'a', 'n', 't', 'o', 's',
            '\n'};

        //Encontrar o espaco
        int espaco = -1;
        for (int i = 0; i < nome.length; i++) {
            if (nome[i] == ' ') {
                espaco = i;
            }

        }

        if (espaco != -1) {
            System.out.println("O ultimo nome é: ");
            for (int i = espaco; i < nome.length; i++) {
                System.out.println(nome[i]);
            }
            System.out.println("O primeiro nome é: ");
            for (int j = 0; j < espaco; j++) {
                System.out.println(nome[j]);
            }

        }

        int countVogais = 0;
        for (int i = 0; i < nome.length; i++) {
            if (nome[i] == 'a' || nome[i] == 'b' || nome[i] == 'A') {
                countVogais++;
            }

        }

        System.out.println("São " + countVogais + " vogais");

    }

}
