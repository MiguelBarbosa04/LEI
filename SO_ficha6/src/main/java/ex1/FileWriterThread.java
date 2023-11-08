/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterThread extends Thread {

    private final String filename;
    private final int threadNumber;

    public FileWriterThread(String filename, int threadNumber) {
        this.filename = filename;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 1; i <= 200; i++) {
                synchronized (filename) {
                    bufferedWriter.write(i + " -- Thread name:" + threadNumber + "\n");
                }
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Modo de uso: java FileWriterThread <nome_do_arquivo>");
            System.exit(1);
        }

        String filename = args[0];

        for (int i = 0; i < 5; i++) {
            Thread thread = new FileWriterThread(filename, i);
            thread.start();
        }
    }
}

