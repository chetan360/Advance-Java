import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Asg2Cb extends JFrame {

    private BallPanel ballPanel;
    private JButton startButton;
    private Thread ballThread;

    public Asg2Cb() {
        setTitle("Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballPanel = new BallPanel();
        startButton = new JButton("Start");
        startButton.addActionListener((ActionEvent e) -> {
            startBallMovement();
        });

        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    private void startBallMovement() {
        if (ballThread == null || !ballThread.isAlive()) {
            ballThread = new Thread(() -> {
                moveBallVertically();
            });
            ballThread.start();
        }
    }

    private void moveBallVertically() {
        int y = 0;
        while (true) {
            try {
                Thread.sleep(20); // Adjust the speed of the ball
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            y += 5; // Adjust the vertical movement step
            
            if(y > ballPanel.getHeight() - 50) {
                y = 0;
            }
            ballPanel.setBallPosition(200, y); // Ball size: 50x50 (adjust as needed)
            ballPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Asg2Cb().setVisible(true);
        });
    }
}

class BallPanel extends JPanel {
    private int ballX;
    private int ballY;

    public void setBallPosition(int x, int y) {
        this.ballX = x;
        this.ballY = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(ballX, ballY, 50, 50);
    }
}
