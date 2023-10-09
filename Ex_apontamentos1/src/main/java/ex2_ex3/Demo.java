/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3;

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
        Codigo<String, Integer> codigo1 = new Codigo<>("IMP", 34);
        ValorM valor1 = new ValorM(10.2);
        ProdutoG2<String, Integer> produto1 = new ProdutoG2<>(codigo1, "Produto 1", valor1);

        Codigo<String, Integer> codigo2 = new Codigo<>("SEC", 1413);
        ValorM valor2 = new ValorM(21.4);
        ProdutoG2<String, Integer> produto2 = new ProdutoG2<>(codigo2, "Produto 2", valor2);

        System.out.println(produto1);
        System.out.println(produto2);
    }
}
