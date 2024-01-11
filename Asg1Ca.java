
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class CityCodeApp {
    private JFrame frame;
    private HashMap<String, String> hm;
    private JTextArea ta;
    
    CityCodeApp() {
        hm = new HashMap<>();
         
        frame = new JFrame("City Hash Table");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ta = new JTextArea();
        JScrollPane scPen = new JScrollPane(ta);
        
        JTextField keyTf = new JTextField(20);
        JTextField valueTf = new JTextField(20);
        
        JButton addBtn = new JButton("Add");
        JButton rmBtn = new JButton("Remove");
        JButton searchBtn = new JButton("Search");
        
        JPanel p = new JPanel(new GridLayout(4,2));
        p.add(new JLabel("Search City:"));
        p.add(searchBtn);
        p.add(new JLabel("Key:"));
        p.add(keyTf);
        p.add(new JLabel("Value:"));
        p.add(valueTf);
        p.add(addBtn);
        p.add(rmBtn);
        
        addBtn.addActionListener((ActionEvent e) -> {
            addValuePair(keyTf.getText(), valueTf.getText());
            updateTextArea();
            keyTf.setText("");
            valueTf.setText("");
        });
        
        rmBtn.addActionListener((ActionEvent e) -> {
            removeKey(keyTf.getText());
            updateTextArea();
            keyTf.setText("");
            valueTf.setText("");
        });
        
        searchBtn.addActionListener((ActionEvent e) -> {
            searchCity(keyTf.getText());
            keyTf.setText("");
        });
        
        frame.add(scPen, BorderLayout.CENTER);
        frame.add(p, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    private void addValuePair(String key, String value) {
        hm.put(key, value);
    }
    
    private void removeKey(String key) {
        hm.remove(key);
    }
    
    private void updateTextArea() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry<String, String> entry: hm.entrySet()) {
            str.append("Key: ").append(entry.getKey()).append(" => Value: ").append(entry.getValue()).append("\n");
        }
        ta.setText(str.toString());
    }
    
    private void searchCity(String city) {
        if(hm.containsKey(city)) {
            JOptionPane.showMessageDialog(frame, "Std code: " + hm.get(city));
        } else {
            JOptionPane.showMessageDialog(frame, "City not found.");
        }
    }
}

public class Asg1Ca {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CityCodeApp();
        });
    }
}
