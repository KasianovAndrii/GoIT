package module12;

import java.util.concurrent.*;

public class HomeTask1Version2 {
    public static void main(String[] args) throws  InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(producer, 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(consumer, 5, 5, TimeUnit.SECONDS);
        Thread.sleep(10000);
        executor.shutdown();
    }
}
