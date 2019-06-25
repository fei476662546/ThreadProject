import java.security.PublicKey;

/**
 * Create by 飞总
 * time on 2019/6/25  10:40
 */
public class Test2 extends Thread {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
    }
}
