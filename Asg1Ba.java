
import java.util.Scanner;
import java.util.TreeSet;

public class Asg1Ba {
    public static void main(String[] args) {
        TreeSet<Integer> sorted = new TreeSet();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many values : ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " elements:");
        for(int i=0; i<n; i++) {
            sorted.add(sc.nextInt());
        }
        
        System.out.println(sorted);
    }
}
