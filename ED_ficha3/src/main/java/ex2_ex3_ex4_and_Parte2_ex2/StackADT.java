/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3_ex4_and_Parte2_ex2;


/**
 *
 * @author Miguel
 */
public interface StackADT<T> {

    /**
     * Uma interface é uma maneira de declarar o comportamento de uma classe.
     * Nesta declaração não especificamos exatamente como acontece internamente
     * cada comportamento. Para uma interface são declarados somente o nome do
     * método e seus parâmetros. Esta especificação de parâmetros é feita
     * através de seus tipos. Adds one element to the top of this stack. 3. *
     * 
     * @param element element to be pushed onto stack 4.
     */
    void push(T element);

    /**
     * Removes and returns the top element from this stack. 7. * @return T
     * element removed from the top of the stack 8.
     */
    T pop();

    /**
     * Returns without removing the top element of this stack. 11. * @return T
     * element on top of the stack 12.
     */
    T peek();

    /**
     * Returns true if this stack contains no elements. 15. * @return boolean
     * whether or not this stack is empty 16.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this stack. 19. * @return int number of
     * elements in this stack 20.
     */
    int size();

    /**
     * Returns a string representation of this stack. 23. * @return String
     * representation of this stack 24.
     */
    @Override
    String toString();
}
