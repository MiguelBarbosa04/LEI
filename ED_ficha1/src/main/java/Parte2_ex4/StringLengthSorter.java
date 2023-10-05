/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex4;

/**
 *
 * @author Miguel
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringLengthSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Miguel");
        stringList.add("João");
        stringList.add("Mário");
        stringList.add("Gonçalo");
        stringList.add("Diogo");

        ordenar(stringList);

        for (int i = 0; i < stringList.size(); i++) {
            String str = stringList.get(i);
            System.out.println("Elemento " + i + ": " + str);
        }

    }

    public static void ordenar(List<String> list) {

        Collections.sort(list, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
    }
}
