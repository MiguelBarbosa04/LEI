/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        int sum = 0, sub = 0, multi = 0, divi = 0;
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNext()) {
            sum += myReader.nextInt();
            sub -= myReader.nextInt();
            multi *= myReader.nextInt();
            divi /= myReader.nextInt();
        }
        System.out.println("Sum : " + sum);
        System.out.println("Sub : " + sub);
        System.out.println("Multi : " + multi);
        System.out.println("Divi : " + divi);

    }

}
