package pingpong;

import java.util.concurrent.atomic.AtomicBoolean;


public class Ai implements Runnable, Atomic {


    @Override
    public void run() {
        if (isEntered.compareAndSet(false, true)) {
            System.out.println("Bamm!");
            isEntered.set(false);
            isFinished.set(false);

        } else {
            isFinished.set(true);
        }
    }

}
