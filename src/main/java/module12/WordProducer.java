package module12;

import java.util.concurrent.BlockingQueue;

public class WordProducer implements MyProducer {
    int n;
    private final BlockingQueue<String> queue;
    public WordProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    boolean updated = false;
    @Override
    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    @Override
    public boolean isUpdated() {
        return updated;
    }


    @Override
    public void run() {
        while (true) {
            try {
                if(updated) {
                    updated = false;
                    if (n % 3 == 0 && n % 5 != 0 && n % 15 != 0)  {
                        queue.put("fizz");
                    } else if (n % 5 == 0 && n % 3 != 0 && n % 15 != 0){
                        queue.put("buzz");
                    } else if (n % 15 == 0 ){
                        queue.put("fizzbuzz");
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
