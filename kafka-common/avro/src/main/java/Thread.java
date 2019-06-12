/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-11 22:40
 **/
public class Thread {


    interface Like {
        void print(int a);
    }

    public static void main(String[] args) {

        Like like = new Like() {
            @Override
            public void print(int a) {
                System.out.println("lambda"+a);

            }
        };
        like.print(12);

        like = (int a)->{
            System.out.println("nihao"+a);
        };
        like.print(999);

        like = a -> {
            System.out.println(a+1);
        };
        like.print(88888);

        like = System.out::println;

        like.print(123123123);


         new java.lang.Thread(()->{
             System.out.println("线程");
         }).start();

    }


    static class Threa1 implements Runnable{

        @Override
        public void run() {
            System.out.println("线程");
        }
    }
}
