package ex3;

class Consumidor extends Thread {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            try {
                char c = buffer.consume();
                Thread.sleep(200); // Simula algum trabalho antes de consumir o próximo caractere
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}