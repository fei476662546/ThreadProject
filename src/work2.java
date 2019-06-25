import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Create by 飞总
 * time on 2019/6/25  14:32
 * 2.编写一个用线程实现一个数字时钟的应用程序。该线程类要采用休眠的方式，把绝对大部分时间让系统使用。 
 */
public class work2 extends Thread {
    public void run(){
        int a=0;
        for (int i=0;i<10;i++) {
            a++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            System.out.println(a+"线程休眠1秒调用当前时间是："+sdf.format(new Date()));
        }
    }
    public static void main(String[] args) {
        work2 w=new work2();
        Thread t=new Thread(w);
        t.start();
    }

}
