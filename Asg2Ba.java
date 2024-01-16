
import java.util.Random;

public class Asg2Ba extends Thread {
    int arr[];
    int sum = 0;
    
    public Asg2Ba() {
        Random r = new Random();
        arr = new int[100];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
    }
    
    public int getSum() {
        return sum;
    }
    
    @Override
    public void run() {
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
    } 
    
    public static void main(String[] args) throws InterruptedException {
        Asg2Ba t[] = new Asg2Ba[10];
        int sum = 0;
        
        for(int i=0; i<t.length; i++) {
            t[i] = new Asg2Ba();
            t[i].start();
        }
        
        for(int i=0; i<t.length; i++) {
            t[i].join();
            sum += t[i].getSum();
        }
        
        double avg = (double) sum / 1000;
        
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}