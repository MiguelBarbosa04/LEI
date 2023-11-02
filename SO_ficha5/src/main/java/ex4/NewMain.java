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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int startValue = i * 100;
            Thread thread = new Prints(startValue);
            thread.start();
            System.out.println("SOU A THREAD NÚMERO " + i + "E COMECEI AQUI");
        }
    }

}
