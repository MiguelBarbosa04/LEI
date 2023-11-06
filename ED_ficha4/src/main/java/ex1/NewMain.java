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

        LinkedQueue<String> filaAtendimento = new LinkedQueue<>();

        // Adiciona pessoas à fila de atendimento
        filaAtendimento.enqueue("Cliente 1");
        filaAtendimento.enqueue("Cliente 2");
        filaAtendimento.enqueue("Cliente 3");
        filaAtendimento.enqueue("Cliente 4");
        filaAtendimento.enqueue("Cliente 5");

        // Simula o atendimento dos clientes
        while (!filaAtendimento.isEmpty()) {
            String cliente = filaAtendimento.dequeue();
            System.out.println("Atendendo o " + cliente);
            // Simula o tempo de atendimento
            try {
                Thread.sleep(1000); // 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(cliente + " atendido, obrigado e volte sempre");
        }

        System.out.println("Todos os clientes foram atendidos.");
    }

}
