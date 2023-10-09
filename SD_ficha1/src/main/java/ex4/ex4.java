/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String primeiro, ultimo;

        Scanner input = new Scanner(System.in);

        System.out.println("Diga o seu primeiro nome: ");
        primeiro = input.nextLine();
        System.out.println("Diga o seu ultimo nome: ");
        ultimo = input.nextLine();

        System.out.println(ultimo);
        System.out.println(primeiro);
    }

}
