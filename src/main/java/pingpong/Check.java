package pingpong;

import java.util.Scanner;


public class Check implements Runnable, Atomic {


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter answer to win: ");
        if (scanner.hasNext()) {
            isEntered.set(true);
        }
    }
}
