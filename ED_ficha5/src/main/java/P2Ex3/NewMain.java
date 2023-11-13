/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2Ex3;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkedOrderedList<Integer> list = new DoubleLinkedOrderedList<>();

        list.add(3);
        list.add(1);
        list.add(2);

        System.out.println("Ordered List: ");
        list.display();
    }

}
