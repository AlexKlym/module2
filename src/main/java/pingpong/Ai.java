package pingpong;

import static pingpong.Game.isEntered;
import static pingpong.Game.isFinished;

public class Ai implements Runnable {
    @Override
    public void run() {
        if(isEntered){
            System.out.println("Bamm!");
            isEntered = false;
            isFinished = false;

        }else {
            isFinished = true;
        }
    }
}
