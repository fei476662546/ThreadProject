import java.util.Random;

/**
 * Create by 飞总
 * time on 2019/6/25  15:08
 * .应用继承类Thread的方法实现多线程类，该线程3次休眠若干(随机)毫秒后显示线程名和第几次执行。 
 */
public class work4 extends Thread{
    public work4(String name) {
        super(name);
    }
    public void run(){
        int a=0;
        for (int i=0;i<3;i++){
            a++;
            Random random=new Random();
            try {
               int sleepTime= random.nextInt(8000);
                System.out.println(getName()+"开始休眠");
                sleep(sleepTime);
                System.out.println(getName()+"休眠了"+sleepTime+"毫秒之后"+"第"+a+"次开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        work4 w=new work4("阿球线程");
        Thread t=new Thread(w);
        t.start();
    }
}
