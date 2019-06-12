package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-12 12:57
 **/
public class SynchorinzedTestClass {


    static class webTickets implements Runnable{

        private int ticketNums;

        public webTickets(int ticketNums) {
            this.ticketNums = ticketNums;
        }

        @Override
        public void run() {
            while (ticketNums>0){
                try {
                    Thread.sleep(10);
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                System.out.println("车票售出："+Thread.currentThread().getName()+",剩余---->"+ticketNums);
                ticketNums--;
            }
        }
    }


    public static void main(String[] args) {
        //三种典型非线程安全的案例
        webTickets webTickets = new webTickets(100);
        new Thread(webTickets,"张三").start();
        new Thread(webTickets,"李四").start();
        new Thread(webTickets,"王五").start();


        List<Integer> list = new ArrayList<>();

        for (int i=0;i<10000;i++){
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(10);
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                list.add(finalI);
            }).start();

        }
        System.out.println(list.size());



    }
}
