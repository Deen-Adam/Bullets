import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class CGMoveALine extends JFrame {
	
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 140;
	
	public static final Color LINE_COLOR = Color.BLACK;
	public static final Color CANVAS_BACKGROUND = Color.CYAN;
	
	
	private int x1 = CANVAS_WIDTH / 2;
	private int y1 = CANVAS_HEIGHT / 8;
	private int x2 = x1;
	private int y2 = CANVAS_HEIGHT / 8 * 7;
	
	// the custome drawing canvas 
	private DrawCanvas canvas;
	
	
	public CGMoveALine(){
		
		//set up a panel for the buttons
		JPanel btnPanel = new JPanel ( new FlowLayout());
		JButton btnLeft = new JButton ("Move Left");
		btnPanel.add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				x1 -= 10;
				x2 -= 10;
				
				canvas.repaint();
				requestFocus(); // change the focus to JFrame to recieve Key Event
				
			}
		});
		
		//set up a custom drawing JPanel
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension (CANVAS_WIDTH, CANVAS_HEIGHT));
		
		// Add both panels to this JFrame
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.SOUTH);
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent evt ){
				
				switch(evt.getKeyCode()) {
				
				case KeyEvent.VK_LEFT:
					x1 -= 10;
					x2 -= 10;
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					x1 += 10;
					x2 += 10;
					repaint();
					break;
				}
			}
			
		});
		
		
	}
	
	// canvas inner class is a jpanel used fo custom drawing 

	public class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			setBackground(CANVAS_BACKGROUND);
			g.setColor(LINE_COLOR);
			g.drawLine(x1, y1, x2, y2); // draw the line
			
		}
		
	}
	
	
	// the entry main mehtod
	public static void main (String [] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				new CGMoveALine();
			}
		});
	}
}
