/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
public class Counter {
    long count = 0;
    
    public  void add(long value){
        this.count += value;
        System.out.println(count);
    }
}
