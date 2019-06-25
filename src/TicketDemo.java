import jdk.nashorn.internal.ir.IfNode;
import sun.security.krb5.internal.Ticket;

/**
 * Create by 飞总
 * time on 2019/6/25  9:50
 */
public class TicketDemo extends Thread {
    private int ticket = 6;

    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket>0){
            System.out.println(currentThread().getName() + "窗口正在出票");}


        }
    }

    public static void main(String[] args) {
        TicketDemo t = new TicketDemo();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();

    }

}
