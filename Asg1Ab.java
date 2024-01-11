
import java.util.Iterator;
import java.util.LinkedList;

public class Asg1Ab {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();
        
        friends.add("Swapnil");
        friends.add("Rushi");
        friends.add("Gaurav");
        
        Iterator<String> itr = friends.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
