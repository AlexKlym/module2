package pingpong;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Atomic {
     AtomicBoolean isEntered = new AtomicBoolean(false);
     AtomicBoolean isFinished = new AtomicBoolean(false);
     AtomicBoolean isTrue = new AtomicBoolean(true);
}
