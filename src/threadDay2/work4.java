package threadDay2;

import java.util.concurrent.ForkJoinPool;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  19:29
 * 利用多线程求解某范围素数,每个线程负责 1000范围：线程1找1-1000；
 * 线程 2 找 1001-2000；线程 3 找 2001-3000。编程程序将每个线程找到的素数及时打印。
 */
public class work4 extends Thread{
    public static void main(String[] args) {
        work4 work4=new work4();
        work4.start();
        two two= new two();
        two.start();
        third third=new third();
        third.start();
    }
    public static void sushu(int i){//调用这个方法可以得到素数
        int x = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                x++;
            }
        }
        if(x==1)
        {System.out.println("线程得到的素数有："+i);}
    }
  public void run() {
      for (int i = 1; i <= 1000; i++) {
         sushu(i);
      }
  }
}
 class two extends Thread{
    public void run() {
        for (int i = 1001; i <= 2000; i++) {
           work4.sushu(i);
        }
    }
}
 class third extends Thread{
    public void run() {

        for (int i = 2001; i <= 3000; i++) {
         work4.sushu(i);
        }
    }
}