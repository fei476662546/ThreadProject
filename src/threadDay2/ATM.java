package threadDay2;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  20:31
 * 假设一个银行的ATM机，它可以允许用户存款也可以取款。现在一个账户上有存款200元，
 * 用户A和用户B都拥有在这个账户上存款和取款的权利。用户A将存入100元，而用户B将取出50元
 * ，那么最后账户的存款应是250元。实际操作过程如下：
 * (1) 先进行A的存款操作：
 * 得到账户的存款数额200，耗时2s。
 * 将账户数额增加100，耗时忽略不计
 * 将新生成的账户结果300返回到ATM机的服务器上，耗时2s
 * (2) 再进行B的取款操作：
 * 得到增加后账户存款数额300，耗时2s。
 * 判断取款额是否小于账户余额，若是，则将账户数额减少50，否则抛出异常信息，耗时忽略不计。
 * 将新生成的账户结果250返回到ATM机的服务器上，耗时2s。
 * 请根据以上要求，将A的操作和B的操作分别用线程来表示,编写一个Java程序实现该功能。
 */
public class ATM {
    String name;
    int money;

    public static void main(String[] args) {
        ATM a = new ATM();
        userA A = new userA(a);
        userB B = new userB(a);
        A.start();
        B.start();
    }
}

class userA extends Thread {
    private ATM a;

    userA(ATM a) {
        this.a = a;
    }

    public void run() {
        synchronized (a) {
            a.name = "阿球";
            a.money = 200;
            try {
                sleep(2000);
                System.out.println("账户的余额为" + a.money + "请执行操作——————————");
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a.money += 100;
            System.out.println(a.name + "已存入100，账户余额为" + a.money);
        }
    }
}

class userB extends Thread {
    private ATM a;

    userB(ATM a) {
        this.a = a;
    }

    public void run() {
        synchronized (a) {
            a.name = "阿飞";
            try {
                sleep(2000);
                System.out.println("账户的余额为" + a.money + "请执行操作——————————");
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int quMoney = 50;
            if (quMoney > a.money) {
                try {
                    throw new Exception("余额不足");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                a.money -= quMoney;
                try {
                    sleep(2000);
                    System.out.println(a.name + "取款了" + quMoney + ",  账户余额为：" + a.money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}