
package ex3;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

public class Janela implements Runnable {

    private Monitor m;
    private int i;

    public Janela(Monitor m, int i) {
        this.m = m;
        this.i = i;
    }

    public void run() {
        String myname = Thread.currentThread().getName();
        JFrame f = new JFrame(myname);
        JLabel label1 = new JLabel(" # ");
        f.add(label1);
        f.setSize(150, 200);
        f.setLocation(i * 200, 100);
        f.setVisible(true);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            label1.setText("" + label1.getText() + "#");
        }
        f.dispose();
    }

    public static class Monitor {

        private int count = 0;

        public synchronized void acorda() {
            count++;
            if (count == 1) {
                this.notify();
            }
        }

        public synchronized void espera() {
            while (count != 1) {
                try {
                    this.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        Monitor mon = new Monitor();
        Thread ths[] = new Thread[8];

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(new Janela(mon, i), "Th" + i);
            ths[i].start();
        }

        System.out.println("[Main] - All_threads_created!");
        System.out.println("[Main] - Activting.threads!");

        try {
            for (int i = 0; i < ths.length; i++) {
                mon.acorda(); // Acorda uma thread por vez
                TimeUnit.SECONDS.sleep(1); // Aguarda um segundo antes de acordar a próxima
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[Main] - All - threads_ended!");
    }
}