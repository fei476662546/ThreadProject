/**
 * Create by 飞总
 * 请通过实现Runnable接口和继承Thread类分别创建线程，要求：除了main线程之外，还要创建一个新的线程
 * 。Main线程重复100次“main“，新线程重复100次输出“new”。 
 * time on 2019/6/25  18:41
 */
public class work5 implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("main");
        }
    }

    public static void main(String[] args) {
        work5 w5 = new work5();
        newThread n = new newThread();
        Thread t1 = new Thread(w5);
        Thread t2 = new Thread(n);
        t1.start();
        t2.start();
    }
}

class newThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("new");
        }
    }
}
