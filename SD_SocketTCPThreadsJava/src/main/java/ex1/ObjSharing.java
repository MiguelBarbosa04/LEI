/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

public class ObjSharing {
    public static void main(String[] args) {
        int NThreads = 5;
        ArrayList<String> asFrases = new ArrayList<>();

        for (int i = 0; i < NThreads; i++)
            new Worker(asFrases, i).start();

        for (int j = 0; j < 6; j++) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            for (String asFrase : asFrases) System.out.println(asFrase);
        }
    }
}