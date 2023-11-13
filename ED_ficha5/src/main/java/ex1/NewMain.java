/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayOrderedList<Integer> orderedList = new ArrayOrderedList<>();

        orderedList.add(10);
        orderedList.add(5);
        orderedList.add(20);
        orderedList.add(2);

        System.out.println("Ordered List: " + orderedList);

     
    }

}
