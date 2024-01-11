
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Asg1Bb {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("Chetan", 3);
        map.put("Ram", 2);
        map.put("Krishn", 1);
        map.put("Radha", 5);
        map.put("Sita", 4);
        
        System.out.println("Before sorting HashMap:");
        display(map);
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
        
        System.out.println("\nAfter sorting HashMap:");
        display(sortedMap);
    }

    private static void display(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " ==> Value: " + entry.getValue());
        }
    }
}