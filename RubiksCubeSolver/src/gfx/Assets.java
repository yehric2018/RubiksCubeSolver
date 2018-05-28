package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage whiteTop, redTop, orangeTop, yellowTop, blueTop, greenTop;
	public static BufferedImage whiteSide, redSide, orangeSide, yellowSide, blueSide, greenSide;
	
	public static void init() {
		BufferedImage sheet = ImageLoader.loadImage("res/textures/cubetiles.png");
	}
}
