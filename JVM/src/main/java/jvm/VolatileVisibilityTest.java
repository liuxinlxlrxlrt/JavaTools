package jvm;

public class VolatileVisibilityTest {
    private static volatile boolean initFlog = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("waiting data ...");
                while (!initFlog) {

                }
                System.out.println("============SUCCESS");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            public void run() {
                prepareData();
            }

        }).start();
    }

    public static void prepareData() {

        System.out.println("prepareing data ...");

        initFlog = true;
        System.out.println("prepare data end ...");
    }
}
