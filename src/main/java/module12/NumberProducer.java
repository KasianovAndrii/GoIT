package module12;

import java.util.concurrent.BlockingQueue;

public class NumberProducer implements MyProducer {
    int n;
    boolean updated = false;
    private final BlockingQueue<String> queue;
    public NumberProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

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
                    if (n % 3 != 0 && n % 5 != 0 && n % 15 != 0)  {
                        queue.put(String.valueOf(n));
                    } else if (n % 5 != 0 && n % 3 == 0 && n % 15 == 0){
                        queue.put(String.valueOf(n));
                    } else if (n % 15 != 0 && n % 3 == 0 && n % 5 == 0){
                        queue.put(String.valueOf(n));
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}