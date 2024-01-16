import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallMovementApp extends JFrame {

    private JPanel ballPanel;
    private JButton startButton;
    private Thread ballThread;

    public BallMovementApp() {
        setTitle("Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBallMovement();
            }
        });

        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    private void startBallMovement() {
        if (ballThread == null || !ballThread.isAlive()) {
            ballThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    moveBallVertically();
                }
            });
            ballThread.start();
        }
    }

    private void moveBallVertically() {
        int y = 0;
        while (y < ballPanel.getHeight()) {
            try {
                Thread.sleep(20); // Adjust the speed of the ball
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            y += 5; // Adjust the vertical movement step
            ballPanel.repaint();
            drawBall(50, y); // Ball size: 50x50 (adjust as needed)
        }
    }

    private void drawBall(int x, int y) {
        ballPanel.getGraphics().clearRect(0, 0, ballPanel.getWidth(), ballPanel.getHeight());
        ballPanel.getGraphics().setColor(Color.BLUE);
        ballPanel.getGraphics().fillOval(x, y, 50, 50);
    }
}

public class Asg2Cb {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BallMovementApp().setVisible(true);
            }
        });
    }
}
