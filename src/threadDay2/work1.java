package threadDay2;

import sun.misc.Lock;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  11:01
 * 编写多线程应用程序，模拟多个人通过一个山洞。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
 * 随机生成10个人，同时准备过此山洞，显示一下每次通过山洞人的姓名。
 */
public class work1 {
    public static void main(String[] args)  {
        ReentrantLock lock= new ReentrantLock();
        String bt[] = {"阿飞", "阿球", "阿昊", "阿龙", "阿东", "阿7", "阿8", "阿9", "阿10", "阿鑫"};
        for (int i=0;i<bt.length;i++){
          lock.lock();
            Thread t = new Thread(new Cave(bt[i]));
              t.start();
              lock.unlock();
        }
//        Random random = new Random();
//        Set set = new HashSet<>();
//        while (set.size() < 10) {
//            int a = random.nextInt(10);
//            set.add(bt[a]);
//        }
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            String s = it.next();
//            synchronized (Cave.class) {
//                Thread t = new Thread(new Cave(s));
//                t.start();
//            }
//        }

    }
}
