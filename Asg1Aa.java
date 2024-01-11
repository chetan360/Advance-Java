
import java.util.ArrayList;

public class Asg1Aa {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Goa");
        
        for(int i=0; i<cities.size(); i++) {
            System.out.println(cities.get(i));
        }
        
        cities.removeAll(cities);
    }
}
