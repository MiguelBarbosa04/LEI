package ex3;

class Produtor extends Thread {
    private Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String frase = "Hello World";
        for (char c : frase.toCharArray()) {
            try {
                buffer.produce(c);
                Thread.sleep(100); // Simula algum trabalho antes de produzir o próximo caractere
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}