/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex4;

/**
 *
 * @author Miguel
 * @param <T>
 */
public abstract class MyQueueUsingTwoStacks<T> implements QueueADT<T> {

    private MyStack<T> stack1;  // Para a inserção (enqueue)
    private MyStack<T> stack2;  // Para a remoção (dequeue)

    public MyQueueUsingTwoStacks() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        int totalSize = 0;

        while (!stack1.isEmpty()) {
            totalSize++;
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return totalSize;
    }

    @Override
    public void enqueue(T element) {
        // Mova todos os elementos de stack2 para stack1, invertendo a ordem
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // Em seguida, adicione o novo elemento a stack1
        stack1.push(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
}
