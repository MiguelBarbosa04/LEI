/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2Ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);

        System.out.println("Original List:");
        list.display();

        Integer[] array = listToArray(list);

        System.out.println("Array from List:");
        System.out.println(Arrays.toString(array));
    }

    public static <T> T[] listToArray(DoubleLinkedUnorderedList<T> list) {
        return list.toArray();
    }

}
