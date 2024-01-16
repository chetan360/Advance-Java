import java.util.Random;
import java.util.Scanner;

class Square extends Thread {
    private int x;

    Square(int n) {
        x = n;
    }

    public void run() {
        int sqr = x * x;
        System.out.println("Square of " + x + " = " + sqr);
    }
}

class Cube extends Thread {
    private int x;

    Cube(int n) {
        x = n;
    }

    public void run() {
        int cub = x * x * x;
        System.out.println("Cube of " + x + " = " + cub);
    }
}

class NumberGenerator extends Thread {
    private final Object lock = new Object();

    public void run() {
        Random random = new Random();

        System.out.println("How many random numbers do you want to generate?");
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();

        for (int i = 0; i < limit; i++) {
            synchronized (lock) {
                int randomInteger = random.nextInt(100);
                System.out.println("\nRandom Integer generated: " + randomInteger);

                Square s = new Square(randomInteger);
                Cube c = new Cube(randomInteger);

                if (randomInteger % 2 == 0) {
                    s.start();
                } else {
                    c.start();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
       }

        sc.close();
    }
}

public class Asg2Bc {
    public static void main(String args[]) {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.start();
    }
}