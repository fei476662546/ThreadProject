package threadDay2;

import java.util.Random;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  14:58
 * 编写线程同步模拟应用程序： 
 *    (1) 大气环境数据为：温度，湿度，风速。 
 *    (2) 一个大气环境传感器测量环境数据需要5秒时间。    
 * (3) 一个计算机读取传感器的环境数据需要0.01秒时间。 
 * 模拟一个计算机读取大气环境传感器的读取的随机的温度，湿度和风速的100次。
 */
public class Atmosphere {
    public static Object readLock = new Object();//创建一个读锁
    public static Object writeLock = new Object();//创建一个写锁
    int temperature = 0;//温度
    int humidity = 0;//湿度
    int windSpeed = 0;//风速
    boolean isReady = false;//是否可读
    boolean isReaded = true;//是否可读写

    //大气传感器线程
    class AtmosphereSensor extends Thread {
        public void run() {
            try {
                c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void c() throws Exception {
            synchronized (writeLock) {
                while (true) {
                    if (isReaded) {
                        System.out.println("大气传感器正在收集数据，此过程需要五秒------");
                       sleep(5000);
                        temperature = (int) (Math.random() * 100);
                        humidity = (int) (Math.random() * 100);
                        windSpeed = (int) (Math.random() * 100);
                        System.out.println("大气传感器正在收集数据完毕，正在上传----");
                        isReaded = false;
                        isReady = true;
                        synchronized (readLock) {
                            readLock.notifyAll();
                        }
                        writeLock.wait();


                    } else {
                        System.out.println("电脑正在读取数据，大气传感器进入等待---");
                        writeLock.wait();
                    }
                }
            }
        }
    }

    class Computer extends Thread {
        public void run() {
            try {
                a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void a() throws Exception {
            synchronized (readLock){
            while (true) {
                if (isReady) {
                    System.out.println("电脑正在读取数据，请等待0.1秒");
                   sleep(100);
                    System.out.println("温度为：" + temperature);
                    System.out.println("湿度为：" + humidity);
                    System.out.println("风速为：" + windSpeed);
                    isReady = false;
                    isReaded = true;
                    System.out.println("数据传输完毕---");
                    isReady = false;
                    isReaded = true;
                    synchronized (writeLock) {
                        writeLock.notifyAll();
                    }
                    readLock.wait();
                } else {
                    System.out.println("大气传感器正在传输数据，电脑等待-----");
                    readLock.wait();
                }
            }
        }}
    }



    public static void main(String[] args) {
        Atmosphere atmosphere = new Atmosphere();
        Computer computer = atmosphere.new Computer();
        AtmosphereSensor atmosphereSensor = atmosphere.new AtmosphereSensor();

        Thread t1 = new Thread(atmosphereSensor);
        Thread t2 = new Thread(computer);
        t1.start();
        t2.start();
    }
}