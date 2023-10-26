package ex1;

public class Run2 extends Thread{
    public ShareObj share;
    public int n;

    public Run2(ShareObj s, int i) {
        share = s;
        n = i;
    }

    public void run() {
        String myname = Thread.currentThread().getName();

        try {
            share.setNumber(n);
            Thread.sleep(n * 1000);
            System.out.println("["+myname+"] Number: " + share.getNumber());
            share.setName("share.name definido por : " +myname);
        } catch (InterruptedException e) {}
    }

    public void setShare(ShareObj s) {
        share = s;
    }
}
