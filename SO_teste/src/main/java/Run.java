package ex1;

public class Run extends Thread{
    public ShareObj share;

    public Run(ShareObj s) {
        this.share = s;
    }

    public void run() {
        String myName = Thread.currentThread().getName();
        try {
            while (true) {
                if (Thread.interrupted()) return;
                Thread.sleep(1000);
                System.out.println("[" + myName + "] Number: " + share.getNumber()+ "(" + share.getName()+ ")");
            }
        } catch (InterruptedException e) {

        }
    }

    public void setShare(ShareObj s) {
        this.share = s;
    }
}
