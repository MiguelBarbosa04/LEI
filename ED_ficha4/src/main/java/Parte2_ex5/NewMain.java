/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cherry", "date", "fig", "grape"};
        List<MyQueue<String>> queues = new ArrayList<>();

        // Crie uma fila personalizada para cada string
        for (String str : strings) {
            MyQueue<String> queue = new MyQueue<>();
            queue.enqueue(str);
            queues.add(queue);
        }

        // Repetidamente aplique a operação de junção ordenada
        while (queues.size() > 1) {
            MyQueue<String> queue1 = queues.remove(0);
            MyQueue<String> queue2 = queues.remove(0);
            MyQueue<String> mergedQueue = mergeOrderedQueues(queue1, queue2);
            queues.add(mergedQueue);
        }

        // A fila final conterá apenas uma fila
        MyQueue<String> finalQueue = queues.get(0);
        System.out.println("Queue final: " + finalQueue.toString());
    }

    private static MyQueue<String> mergeOrderedQueues(MyQueue<String> queue1, MyQueue<String> queue2) {
        MyQueue<String> mergedQueue = new MyQueue<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            String str1 = queue1.first();
            String str2 = queue2.first();
            if (str1.compareTo(str2) <= 0) {
                mergedQueue.enqueue(queue1.dequeue());
            } else {
                mergedQueue.enqueue(queue2.dequeue());
            }
        }
        while (!queue1.isEmpty()) {
            mergedQueue.enqueue(queue1.dequeue());
        }
        while (!queue2.isEmpty()) {
            mergedQueue.enqueue(queue2.dequeue());
        }
        return mergedQueue;
    }
}
