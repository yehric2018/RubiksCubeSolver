package gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private int width, height;
	private String title;
	private JFrame frame;
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		init();
	}
	private void init() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		canvas.setBackground(Color.BLACK);
		
		frame.add(canvas);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public Canvas getCanvas() {
		return canvas;
	}
}
