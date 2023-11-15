/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class SynchronizedArrayList {
    
    
    private ArrayList list = new ArrayList();
    
    public synchronized void add(Object o){
        list.add(o);
    }
    
    public synchronized ArrayList get(){
        return list;
    }
}
