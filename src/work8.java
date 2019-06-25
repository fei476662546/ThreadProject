import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by 飞总
 * time on 2019/6/25  18:57
 * 8.请创建一个线程，指定一个限定时间（如60s），线程运行时，大约每3s输出1次当前所剩时间，
 * 直至给定的限定时间用完。考点：sleep方法
 */
public class work8 extends Thread{
    private int time;

    public work8(String name, int time) {
        super(name);
        this.time = time;
    }
public void run(){
        while (time>0){
            time--;
            System.out.println(getName()+"开始执行-----");
            System.out.println("执行完毕，休眠三秒。剩余时间为"+time);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
    public static void main(String[] args) {
//        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
//        System.out.println(sdf.format(new Date()));
//        try {
//            Thread.sleep(10000);
//            System.out.println(sdf.format(new Date()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        work8 w8=new work8("阿挺线程", 10);
        Thread t=new Thread(w8);
        t.start();
    }
}
