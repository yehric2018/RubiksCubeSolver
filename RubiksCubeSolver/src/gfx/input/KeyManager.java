package gfx.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gfx.Handler;
import gfx.cube.GraphicsCube;

public class KeyManager implements KeyListener {
	
	private boolean keys[];
	private boolean shift;
	public boolean up, down, left, right, rotateRight, rotateLeft;
	
	private GraphicsCube cube;

	public KeyManager(Handler handler) {
		keys = new boolean[256];
		for (int i = 0; i < keys.length; i++)
			keys[i] = false;
		shift = false;
		
		cube = handler.getCube();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	public void update() {
		shift = keys[KeyEvent.VK_SHIFT];
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if (shift) {
			if (e.getKeyCode() == KeyEvent.VK_F)
				cube.turn("f");
			else if (e.getKeyCode() == KeyEvent.VK_B)
				cube.turn("b");
			else if (e.getKeyCode() == KeyEvent.VK_U)
				cube.turn("u");
			else if (e.getKeyCode() == KeyEvent.VK_D)
				cube.turn("d");
			else if (e.getKeyCode() == KeyEvent.VK_R)
				cube.turn("r");
			else if (e.getKeyCode() == KeyEvent.VK_L)
				cube.turn("l");
			else if (e.getKeyCode() == KeyEvent.VK_S)
				cube.solve();
		} else {
			if (e.getKeyCode() == KeyEvent.VK_F)
				cube.turn("F");
			else if (e.getKeyCode() == KeyEvent.VK_B)
				cube.turn("B");
			else if (e.getKeyCode() == KeyEvent.VK_U)
				cube.turn("U");
			else if (e.getKeyCode() == KeyEvent.VK_D)
				cube.turn("D");
			else if (e.getKeyCode() == KeyEvent.VK_R)
				cube.turn("R");
			else if (e.getKeyCode() == KeyEvent.VK_L)
				cube.turn("L");
			else if (e.getKeyCode() == KeyEvent.VK_S)
				cube.scramble();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
			cube.spin("UP");
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			cube.spin("DOWN");
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			cube.spin("LEFT");
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			cube.spin("RIGHT");
		System.out.println(cube);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
