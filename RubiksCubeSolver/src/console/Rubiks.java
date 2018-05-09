package console;

import java.util.ArrayList;

public class Rubiks {

	public static void main(String[] args) {
		init();
		displayCube();
		scramble();
	}

	// hold the data of each side of the cube
	static char[][] left;
	static char[][] right;
	static char[][] top;
	static char[][] down;
	static char[][] front;
	static char[][] back;

	// scramble the cube
	static void scramble() {
		// moves contains the strings representing the algorithms
		ArrayList<String> moves = new ArrayList<String>();
		moves.add("U");
		moves.add("D");
		moves.add("R");
		moves.add("L");

		// randomly select an algorithm to run 20 times
		for (int i = 0; i < 20; i++) {
			int rand = (int) (Math.random() * 4);
			turn(moves.get(rand));
		}
	}

	// initialize the cube
	static void init() {
		// each side has 9 locations for colors at a time
		left = new char[3][3];
		right = new char[3][3];
		top = new char[3][3];
		down = new char[3][3];
		front = new char[3][3];
		back = new char[3][3];

		// each side originally starts with one color
		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				front[r][c] = 'W';
			}
		}

		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				top[r][c] = 'R';
			}
		}

		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				back[r][c] = 'Y';
			}
		}

		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				down[r][c] = 'O';
			}
		}

		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				left[r][c] = 'B';
			}
		}

		for (int r = 0; r < front.length; r++) {
			for (int c = 0; c < front.length; c++) {
				right[r][c] = 'G';
			}
		}
	}

	// testing method to display the cube
	static void displayCube() {
		System.out.println("     T");
		System.out.println("      " + top[0][0] + top[0][1] + top[0][2]);
		System.out.println("      " + top[1][0] + top[1][1] + top[1][2]);
		System.out.println("      " + top[2][0] + top[2][1] + top[2][2]);
		System.out.println("L    F    R");
		System.out.println("" + left[0][0] + left[0][1] + left[0][2] + "  " + 
		front[0][0] + front[0][1] + front[0][2]
				+ "  " + right[0][0] + right[0][1] + right[0][2]);
		System.out.println("" + left[1][0] + left[1][1] + left[1][2] + "  " + 
				front[1][0] + front[1][1] + front[1][2]
				+ "  " + right[0][0] + right[0][1] + right[0][2]);
		System.out.println("" + left[2][0] + left[2][1] + left[2][2] + "  " + 
				front[2][0] + front[2][1] + front[2][2]
				+ "  " + right[0][0] + right[0][1] + right[0][2]);
		System.out.println("     D");
		System.out.println("      " + down[0][0] + down[0][1] + down[0][2]);
		System.out.println("      " + down[1][0] + down[1][1] + down[1][2]);
		System.out.println("      " + down[2][0] + down[2][1] + down[2][2]);
		System.out.println("     B");
		System.out.println("      " + back[0][0] + back[0][1] + back[0][2]);
		System.out.println("      " + back[1][0] + back[1][1] + back[1][2]);
		System.out.println("      " + back[2][0] + back[2][1] + back[2][2]);
		System.out.println("\n");
	}

	// turn the cube according to a certain given algorithm
	static void turn(String algorithm) {
		// by calling with an ignore value, displaying the cube is easier
		turn(algorithm, -1);
		displayCube();
	}

	// turn the cube according to the given algorithm
	static void turn(String algorithm, int ignore) {
		// FIX: rotate the given side for each algorithm
		if (algorithm.equals("U")) {
			char[] f = front[0];
			char[] l = left[0];
			char[] b = back[0];
			char[] r = right[0];

			front[0] = r;
			left[0] = f;
			back[0] = l;
			right[0] = b;
		} else if (algorithm.equals("D")) {
			char[] f = front[2];
			char[] l = left[2];
			char[] b = back[2];
			char[] r = right[2];

			front[2] = l;
			left[2] = b;
			back[2] = r;
			right[2] = f;
		} else if (algorithm.equals("L")) {
			char[] f = { front[0][0], front[1][0], front[2][0] };
			char[] d = { down[0][0], down[1][0], down[2][0] };
			char[] b = { back[0][2], back[1][2], back[2][2] };
			char[] t = { top[0][0], top[1][0], top[2][0] };

			front[0][0] = t[0];
			front[1][0] = t[1];
			front[2][0] = t[2];
			down[0][0] = f[0];
			down[1][0] = f[1];
			down[2][0] = f[2];
			back[0][2] = d[0];
			back[1][2] = d[1];
			back[2][2] = d[2];
			top[0][0] = b[0];
			top[1][0] = b[1];
			top[2][0] = b[2];
		} else if (algorithm.equals("R")) {
			char[] f = { front[0][2], front[1][2], front[2][2] };
			char[] d = { down[0][2], down[1][2], down[2][2] };
			char[] b = { back[0][0], back[1][0], back[2][0] };
			char[] t = { top[0][2], top[1][2], top[2][2] };

			front[0][2] = d[0];
			front[1][2] = d[1];
			front[2][2] = d[2];
			down[0][2] = b[0];
			down[1][2] = b[1];
			down[2][2] = b[2];
			back[0][0] = t[0];
			back[1][0] = t[1];
			back[2][0] = t[2];
			top[0][2] = f[0];
			top[1][2] = f[1];
			top[2][2] = f[2];
		} else if (algorithm.equals("F")) {

		} else if (algorithm.equals("B")) {

		} else {
			if (algorithm.equals("U'")) {
				turn("U", -1);
			} else if (algorithm.equals("D'")) {
				turn("D", -1);
			} else if (algorithm.equals("L'")) {
				turn("L", -1);
			} else if (algorithm.equals("R'")) {
				turn("R", -1);
			} else if (algorithm.equals("F'")) {
				turn("F", -1);
			} else if (algorithm.equals("B'")) {
				turn("B", -1);
			}
		}
	}

	// solve the cube
	static void solve() {

	}
}
