package module12;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable{
    int second = 0;
    private final BlockingDeque<String> queue;
    public Producer(BlockingDeque<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        second++;
        try {
            queue.put("Notification#" + second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Second = "+ second);
    }
}
