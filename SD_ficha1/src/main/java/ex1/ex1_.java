package ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */
public class ex1_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] mat = {{11, 7, 333}, {-20, -23, 63}, {-22, 501, 10000}};

        int soma = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {
                soma += mat[i][j];

            }

        }
        System.out.println("A soma é:" + soma);

    }

}
