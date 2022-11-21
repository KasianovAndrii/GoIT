package module12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeTask1Version1 {
    public static void main(String[] args) throws InterruptedException {
        PassedSeconds passedSeconds = new PassedSeconds();
        TimeData timeData = new TimeData();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(timeData, 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(passedSeconds, 5, 5, TimeUnit.SECONDS);
        Thread.sleep(100000);
        executor.shutdown();
    }
}
