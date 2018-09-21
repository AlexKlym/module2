package pingpong;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {
    static volatile boolean isEntered = false;
    static  volatile boolean isFinished = false;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(new Ai(), 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Check(), 0, 2, TimeUnit.SECONDS);

        while (!isFinished){
            Thread.yield();
        }

        System.out.println("Too late! You loose");
        scheduledExecutorService.shutdownNow();
        System.exit(0);
    }

}
