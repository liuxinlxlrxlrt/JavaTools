package jvm;

public class VolatileAtomicTest {
    public static volatile int num = 0;

    public static void increase() {
        num++;//num=num+1
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println(num);//结果<=10000
    }
}
