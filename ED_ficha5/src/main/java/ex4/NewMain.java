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
public class NewMain {
    public static void main(String[] args) {
        ArrayUnorderedList<Integer> unorderedList = new ArrayUnorderedList<>();

        unorderedList.addToRear(10);
        unorderedList.addToFront(5);
        unorderedList.addToRear(20);

        System.out.println("Unordered List: " + unorderedList);

        int removedElement = unorderedList.remove(5);

        System.out.println("Removed element: " + removedElement);
        System.out.println("Size: " + unorderedList.size());

        System.out.println("Contains 10: " + unorderedList.contains(10));
    }
}
