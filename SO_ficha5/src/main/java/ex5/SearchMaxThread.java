/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author Miguel
 */
public class SearchMaxThread extends Thread {

    private int[] array;
    private int startIndex;
    private int endIndex;
    private int maxValue = Integer.MIN_VALUE;

    public SearchMaxThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
    }

    public int getMaxValue() {
        return maxValue;
    }
}

