/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_and_PArte2_ex1;

/**
 *
 * @author Miguel
 * @param <T>
 */
public class ArrayStack<T> implements StackADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    /*Construtor para criar uma arraystack com 100 de capacidade*/
    public ArrayStack() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /*Construtor para criar uma arraystack com a capacidade que quisermos*/
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T element) {

        stack[top] = element;
        top++;
    }

    @Override
    public T pop() {

        top--;
        T element = stack[top];
        stack[top] = null; // Optionally nullify the reference to the popped element.
        return element;
    }

    @Override
    public T peek() {

        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        // Implement the toString method as needed.
        return "ArrayStack with " + top + " elements";
    }

    public T evaluatePostfixExpression(String postfixExpression) {
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                // Se for um número, empilhe na pilha
                push((T) Integer.valueOf(token));
            } else if (token.equals("+")) {
                // Se for uma adição, desempilhe dois números, some e empilhe o resultado
                T operand2 = pop();
                T operand1 = pop();
                int result = (int) operand1 + (int) operand2;
                push((T) Integer.valueOf(result));
            } else if (token.equals("-")) {
                // Faça o mesmo para subtração, multiplicação e divisão
                T operand2 = pop();
                T operand1 = pop();
                int result = (int) operand1 - (int) operand2;
                push((T) Integer.valueOf(result));
            } else if (token.equals("*")) {
                T operand2 = pop();
                T operand1 = pop();
                int result = (int) operand1 * (int) operand2;
                push((T) Integer.valueOf(result));
            } else if (token.equals("/")) {
                T operand2 = pop();
                T operand1 = pop();
                int result = (int) operand1 / (int) operand2;
                push((T) Integer.valueOf(result));
            }
        }

        // O resultado final estará no topo da pilha
        return peek();
    }
}
