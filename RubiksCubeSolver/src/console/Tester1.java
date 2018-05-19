package console;

import java.util.Scanner;

public class Tester1 {

	public static void main(String[] args) {
		RubiksCube cube = new RubiksCube();
		System.out.println(cube);
		
		cube.scramble();
		
		for (int i = 0; i < 100; i++) {
			cube.scramble();
			cube.solve();
			cube.yellowSide();
		}
		
//		Scanner scan = new Scanner(System.in);
//		if (scan.next().equals("solve")) {
//			cube.solve();
//		}
//		System.out.println(cube);
//		
//		if (scan.next().equals("solve")) {
//			cube.yellowSide();
//		}
//		System.out.println(cube);
	}
	
}
