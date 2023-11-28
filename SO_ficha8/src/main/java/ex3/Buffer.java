package ex3;

import java.util.concurrent.Semaphore;

class Buffer {
    private char[] data;
    private int count;
    private int size;
    private Semaphore mutex;
    private Semaphore full;
    private Semaphore empty;

    public Buffer(int size) {
        this.size = size;
        this.data = new char[size];
        this.count = 0;
        this.mutex = new Semaphore(1);
        this.full = new Semaphore(0);
        this.empty = new Semaphore(size);
    }

    public void produce(char c) throws InterruptedException {
        empty.acquire(); // Aguarda até que haja espaço disponível no buffer
        mutex.acquire(); // Garante a exclusão mútua
        try {
            data[count++] = c;
            System.out.println("Produzido: " + c);
        } finally {
            mutex.release();
            full.release(); // Sinaliza que há dados disponíveis para consumir
        }
    }

    public char consume() throws InterruptedException {
        full.acquire(); // Aguarda até que haja dados disponíveis para consumir
        mutex.acquire(); // Garante a exclusão mútua
        try {
            char result = data[--count];
            System.out.println("Consumido: " + result);
            return result;
        } finally {
            mutex.release();
            empty.release(); // Sinaliza que há espaço disponível para produzir
        }
    }
}