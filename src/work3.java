/**
 * Create by 飞总
 * time on 2019/6/25  14:58
 * .编写一个使用继承Thread类的方法实现多线程的程序。该类有两个属性，一个字符串代表线程名，
 * 一个整数代表该线程要休眠的时间。线程执行时，显示线程名和休眠时间。
 */
public class work3 extends Thread{
    private int time;

    public work3(String name, int time) {
        super(name);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "休眠了" + getTime() + "毫秒后开始执行---------");
        }
    }
    public static void main(String[] args) {
        work3 work3=new work3("作业三线程",2000);
        Thread t=new Thread(work3);
        t.start();
    }
}
