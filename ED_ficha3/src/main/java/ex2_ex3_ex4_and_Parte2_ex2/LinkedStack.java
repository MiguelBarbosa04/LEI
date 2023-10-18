/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3_ex4_and_Parte2_ex2;

import java.util.EmptyStackException;

/**
 *
 * @author Miguel
 */
public class LinkedStack<T> implements StackADT<T> {

    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Trate o caso de pilha vazia
        }

        T element = top.data;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Trate o caso de pilha vazia
        }

        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
    
    public int evaluatePostfixExpression(String postfixExpression) {
        String[] tokens = postfixExpression.split(" ");
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                // Se o token for um número, empilhe na pilha
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                // Se o token for um operador, desempilhe dois operandos, aplique a operação e empilhe o resultado
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluateOperation(operand1, operand2, token);
                stack.push(result);
            }
        }

        // O resultado final estará no topo da pilha
        return stack.peek();
    }

    // Método auxiliar para verificar se uma string é um número
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    // Método auxiliar para verificar se uma string é um operador
    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    // Método auxiliar para avaliar a operação com base no operador
    private int evaluateOperation(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        throw new IllegalArgumentException("Operador inválido: " + operator);
    }
}
