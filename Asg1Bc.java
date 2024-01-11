
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Asg1Bc {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, String> person = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new FileReader("names_and_numbers.txt"));
        
        String[] str;
        String line;
        while((line = br.readLine()) != null) {
            str = line.split("\t");
            person.put(str[0], str[1]);
        }
        
        for(Map.Entry<String, String> rec: person.entrySet()) {
            System.out.println("Key: " + rec.getKey() + " ==> Value: " + rec.getValue());
        }
    }
}
