import java.awt.*;

/**
 * Create by 飞总
 * time on 2019/6/25  8:57
 */
public class Test1 extends Thread {
    public void run() {
        for (int x = 0; x < 60; x++)
            System.out.println("线程----------0执行" + x);
    }
    public static void main(String[] args) {
        Test1 x = new Test1();
        x.start();
        for (int a = 0; a < 60; a++)

            System.out.println("线程1执行" + a);

    }
//    public void run (){
//    }
//    public static void main(String[] args) {
//        String name=Thread.currentThread().getName();
//        System.out.println(name+"开始执行...");
//       Test1 test1=new Test1();
//       test1.start();
//        for (int i=0;i<100;i++){
//            System.out.println("线程"+name+"在打印"+i);
//        }
//        System.out.println("执行完毕");
//    }
}


