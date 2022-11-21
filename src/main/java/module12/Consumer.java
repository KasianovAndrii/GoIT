package module12;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private int second = 0;
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("5 second passed...");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
