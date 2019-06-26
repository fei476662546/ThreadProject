package threadDay2;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  13:46
 *编写多线程应用程序，模拟多个人通过一个山洞。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
 *随机生成10个人，同时准备过此山洞，显示一下每次通过山洞人的姓名。
 */
public class Cave implements Runnable{
    String name;
    Cave(String name){
        this.name=name;
    }
    public void run(){
synchronized (Cave.class) {
    System.out.println(name + "开始进入山洞");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("五秒后" + name + "出来了");
}
    }
}
