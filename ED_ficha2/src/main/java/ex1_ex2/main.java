package ex1_ex2;

import ex1_ex2.LinkedList;
import static ex1_ex2.LinkedList.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Start with the empty list. */
         LinkedList<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println("Lista de inteiros:");
        intList.printList();

        intList.remove(2);

        System.out.println("Lista de inteiros após remover o elemento 2:");
        intList.printList();

        LinkedList<String> strList = new LinkedList<>();
        strList.add("Hello");
        strList.add("World");

        System.out.println("Lista de strings:");
        strList.printList();
    }

}