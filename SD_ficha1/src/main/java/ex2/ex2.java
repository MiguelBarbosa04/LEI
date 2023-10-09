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
        // TODO code application logic here
        int[] lista = {12, 5, -21, 10, -345, 22, 50, -125, 80, -1};

        int multi = 1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > 0) {
                multi *= lista[i];
            }

        }
        System.out.println("A multiplicacao é:" + multi);
    }

}
