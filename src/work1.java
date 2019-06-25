import java.util.Random;

/**
 * Create by 飞总
 * time on 2019/6/25  10:58
 * 1.编写一个多线程类，该类的构造方法调用Thread类带字符串参数的构造方法。
 * 建立自己的线程名，然后随机生成一个休眠时间，再将自己的线程名和休眠多长时间显示出来。
 * 该线程运行后，休眠一段时间，该时间就是在构造方法中生成的时间。
 * 最后编写一个测试类，创建多个不同名字的线程，并测试其运行情况。 
 */
public class work1 extends Thread{
    private int time;
    public work1(String name) {
        super(name);
        Random random=new Random();
        int sleepTime=random.nextInt(5000);
        this.time=sleepTime;
        System.out.println(this.getName()+"进程开始休眠"+sleepTime+"毫秒");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"结束休眠，开始启动：.........");


    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int miao = random.nextInt(3000);
            System.out.println(this.getName() + "运行"+".....睡眠"+miao+"毫秒");
            try {
                sleep(miao);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        work1 t=new work1("球球线程");
        work1 n=new work1("飞飞线程");
        Thread t1=new Thread(t);
        Thread t2=new Thread(n);
        t1.start();
        t2.start();
    }
}
