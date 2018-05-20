package console;

import java.util.Scanner;

public class Tester1 {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
		
		for (int i = 0; i < 100; i++) {
			cube.scramble();
			cube.solve();
		}
	}
	
}
