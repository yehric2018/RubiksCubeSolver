package gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import gfx.cube.RubiksCube;
import gfx.input.KeyManager;

public class Program implements Runnable {

	private String title;
	private int width, height;
	private Display display;
	private Handler handler;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Thread thread;
	private boolean running = false;
	
	private RubiksCube cube;
	
	private KeyManager keyManager;
	
	public Program(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().setVisible(true);
		
		this.handler = new Handler(this);
		
		this.cube = new RubiksCube(handler);
		
		keyManager = new KeyManager(handler);
		display.getFrame().addKeyListener(keyManager);
	}
	
	public void update() {
		keyManager.update();
		//cube.update();
	}
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		cube.render(g);
		
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
	}

	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	public RubiksCube getCube() {
		return cube;
	}
}
