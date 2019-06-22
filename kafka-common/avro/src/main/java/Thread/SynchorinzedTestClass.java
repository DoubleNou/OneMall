package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

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

        ExecutorService service = new ScheduledThreadPoolExecutor(10);
        for (int i=0;i<10000;i++){
            int finalI = i;
        service.submit(()->{
            try {
                Thread.sleep(10);
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            list.add(finalI);
        });
        }

        System.out.println(list.size());

        Account account = new Account("结婚礼金",100);
        new Rawing(account, 80, "悲催的你").start();
        new Rawing(account, 90, "happy的她").start();

    }


    static class Account{
        private String name;
        private Integer money;

        public Account(String name, Integer money) {
            this.name = name;
            this.money = money;
        }
    }

    static class Rawing extends Thread{
        private Account account;
        private int drawMoney;
        private int packetTotal;

        public Rawing(Account account, Integer drawMoney, String name) {
            super(name);
            this.account = account;
            this.drawMoney = drawMoney;
        }

        @Override
        public void run() {

            if (account.money < 0){
                return;
            }
            account.money -= drawMoney;
            packetTotal += drawMoney;

            System.out.println(this.getName()+"----->账户余额"+account.money);
            System.out.println(this.getName()+"----->口袋中的钱"+packetTotal);

        }
    }
}
