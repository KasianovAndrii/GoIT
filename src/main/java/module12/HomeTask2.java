package module12;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class HomeTask2 {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        WordProducer wordProducer = new WordProducer(queue);
        NumberProducer numberProducer = new NumberProducer(queue);
        
        Runnable consumer = () -> {
            while(true) {
                while(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                try {
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                 throw new RuntimeException(e);
                }
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(numberProducer);
        executor.execute(wordProducer);
        executor.execute(consumer);
        for (int i = 1; i <= 100; i++) {
            wordProducer.setN(i);
            numberProducer.setN(i);
            while(wordProducer.isUpdated() || numberProducer.isUpdated()){
                Thread.sleep(100);
            }
        }
    }
}
