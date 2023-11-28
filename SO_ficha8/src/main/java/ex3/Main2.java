package ex3;

public class Main2 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();
    }
}