import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;



class BounceFrame extends JFrame
{
	public BounceFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Bouncing Ball Using AWT and Multithreading");
		Container contentPane = getContentPane();
		canvas = new BallCanvas();
		contentPane.add(canvas, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "START",new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				addBall();
			}
		});

		addButton(buttonPanel, "CLOSE",new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				System.exit(0);
			}
		});
		
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall()
	{
		try
		{
			Ball b = new Ball(canvas);
			canvas.add(b);
			for (int i =1 ; i <= 1000; i++)
			{
				b.move();
				Thread.sleep(5);
			}
		}
		catch (InterruptedException exception)	
		{}
	}

	private BallCanvas canvas;
	public static final int WIDTH = 450;
	public static final int HEIGHT = 350;
}

class BallCanvas extends JPanel
{
	public void add(Ball b)
	{
		balls.add(b);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for (int i = 0; i < balls.size(); i++)
		{
			Ball b = (Ball)balls.get(i);
			b.draw(g2);
		}
	}

	private ArrayList balls = new ArrayList();
}

class Ball
{
	public Ball(Component c) 
	{ 
		canvas = c; 
	}
	
	public void draw(Graphics2D g2)
	{
		g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
	}

	public void move()
	{
		x += dx;
		y += dy;
		
		if (x < 0)
		{
			x = 0;
			dx = -dx;
		}
		
		if (x + XSIZE >= canvas.getWidth())
		{
			x = canvas.getWidth() - XSIZE;
			dx = -dx; 
		}
		
		if (y < 0)
		{
			y = 0;
			dy = -dy;
		}
		
		if (y + YSIZE >= canvas.getHeight())
		{
			y = canvas.getHeight() - YSIZE;
			dy = -dy;
		}
	
		canvas.paint(canvas.getGraphics());
	}

	private Component canvas;
	private static final int XSIZE = 5;
	private static final int YSIZE = 5;
	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;
}
public class ASG7Cb
{
	public static void main(String[] args)
	{
		JFrame frame = new BounceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}