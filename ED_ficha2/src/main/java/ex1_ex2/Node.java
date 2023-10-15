package ex1_ex2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */
public class Node<T> {

    T data;
    Node<T> next;

    // Constructor to create a new node
    // Next is by default initialized
    // as null
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}
