/**
 * Create by mysteriousTime
 * time on 2019/6/25  20:43
 */
public class ResDemo  {
    public static void main(String[] args) {
        Res r=new Res();
        Input in=new Input(r);
        Output out=new Output(r);
        Thread t1=new Thread(in);
        Thread t2=new Thread(out);
        t1.start();
        t2.start();
    }
}
class Res {
    String name;
    String sex;
}

class Input implements Runnable {
    private Res r;
    Input(Res r) {
        this.r = r;
    }
    public void run() {
        int a = 0;
        while (true) {
            synchronized (r) {
                if (a == 0) {
                    r.name = "球球---------------";
                    r.sex = "男男.................";
                } else {
                    r.name = "xiao li";
                    r.sex = "woman";
                }
                a = (a + 1) % 2;
            }
        }
    }
}
class Output implements Runnable {
    private Res r;
    Output(Res r) {
        this.r = r;
    }
    public void run() {
        while (true) {
            synchronized (r) {
                System.out.println(r.name + "...." + r.sex);
            }
        }
    }
}