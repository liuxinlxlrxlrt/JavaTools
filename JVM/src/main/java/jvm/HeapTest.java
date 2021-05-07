package jvm;

import java.util.ArrayList;

public class HeapTest {
    byte[] g = new byte[1024 * 100]; //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<HeapTest>();
        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
