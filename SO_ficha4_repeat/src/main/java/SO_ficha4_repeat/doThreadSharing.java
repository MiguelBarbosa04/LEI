/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO_ficha4_repeat;

/**
 *
 * @author Miguel
 */
public class doThreadSharing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SharedObj share = new SharedObj();
        Thread tarefa = new Thread(new Run(share), "Printer_thread");
        tarefa.start();

        for (int i = 0; i < 10; i++) {
            Thread tarefa2 = new Thread(new Run2(share, i));
            tarefa2.setName("Numbered_thread_" + i);
            tarefa2.start();

        }

        try {
            Thread.sleep(10000);
            tarefa.interrupt();
        } catch (InterruptedException e) {
        }
    }

}
