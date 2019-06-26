package threadDay2;

/**
 * Create by mysteriousTime
 * time on 2019/6/26  18:50
 * 假设某家银行可接受顾客的汇款，每进行一步汇款，便可计算出汇款总额。
 * 现有两名顾客，每人都分 3 次.每次 100 元将钱汇入。试编写一个程序，来模拟顾客的汇款操作。
 */
public class work3 {
    String name;
    int money;

    public static void main(String[] args) {
        work3 w=new work3();
        person1 p1=new person1(w);
        person2 p2=new person2(w);
        p1.start();
        p2.start();
    }
}
class person1 extends Thread{
   private work3 w;
   person1(work3 w){
       this.w=w;
   }
    public void run(){
      synchronized (work3.class){
       for(int i=0;i<10;i++){
      w.money+=100;
      w.name="球一";
        System.out.println(w.name+"向银行存入了100元"+"此时银行账户有"+w.money+"元"+i);
           try {
               sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
          }
       }}}
}
class person2 extends Thread{
    private work3 w;
    person2(work3 w){
        this.w=w;
    }
    public void run(){
        synchronized (work3.class){
        for (int i=0;i<13;i++){
        w.money+=100;
        w.name="球五";
        System.out.println(w.name+"向银行存入了100元-----------"+"此时银行账户有"+w.money+"元"+i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }}}
}