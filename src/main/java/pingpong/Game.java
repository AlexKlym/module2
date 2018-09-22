package pingpong;

import java.util.concurrent.*;

public class Game implements Atomic {


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(new Ai(), 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Check(), 0, 2, TimeUnit.SECONDS);

        while (!isFinished.equals(isTrue)) {
            Thread.yield();
        }

        System.out.println("Too late! You loose");
        scheduledExecutorService.shutdownNow();
        System.exit(0);
    }

}
