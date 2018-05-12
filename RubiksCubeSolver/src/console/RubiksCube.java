package console;

import java.util.ArrayList;

public class RubiksCube {

	public RubiksCube(char[][] front, char[][] back, char[][] left, char[][] right, char[][] up, char[][] down) {
		this.left = left;
		this.right = right;
		this.down = down;
		this.up = up;
		this.front = front;
		this.back = back;
	}

	public RubiksCube() {
		init();
		moves.add("U");
		moves.add("D");
		moves.add("R");
		moves.add("L");
		moves.add("F");
		moves.add("B");
		moves.add("u");
		moves.add("d");
		moves.add("r");
		moves.add("l");
		moves.add("f");
		moves.add("b");
	}

	// hold the data of each side of the cube
	char[][] left;
	char[][] right;
	char[][] up;
	char[][] down;
	char[][] front;
	char[][] back;

	// each of the twelve moves that can happen for any given cube
	ArrayList<String> moves = new ArrayList<String>();

	// scramble the cube
	void scramble() {
		// randomly select an algorithm to run 20 times
		for (int i = 0; i < 20; i++) {
			int rand = (int) (Math.random() * 12);
			System.out.println(moves.get(rand));
			turn(moves.get(rand));
		}
	}

	// initialize the cube
	void init() {
		// each side has 9 locations for colors at a time
		left = new char[3][3];
		right = new char[3][3];
		up = new char[3][3];
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
				up[r][c] = 'R';
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
	public String toString() {
		String res = "";
		res += "     U\n";
		res += "     " + up[0][0] + up[0][1] + up[0][2] + "\n";
		res += "     " + up[1][0] + up[1][1] + up[1][2] + "\n";
		res += "     " + up[2][0] + up[2][1] + up[2][2] + "\n";
		res += "L    F    R\n";
		res += "" + left[0][0] + left[0][1] + left[0][2] + "  " + front[0][0] + front[0][1] + front[0][2] + "  "
				+ right[0][0] + right[0][1] + right[0][2] + "\n";
		res += "" + left[1][0] + left[1][1] + left[1][2] + "  " + front[1][0] + front[1][1] + front[1][2] + "  "
				+ right[1][0] + right[1][1] + right[1][2] + "\n";
		res += "" + left[2][0] + left[2][1] + left[2][2] + "  " + front[2][0] + front[2][1] + front[2][2] + "  "
				+ right[2][0] + right[2][1] + right[2][2] + "\n";
		res += "     D\n";
		res += "     " + down[0][0] + down[0][1] + down[0][2] + "\n";
		res += "     " + down[1][0] + down[1][1] + down[1][2] + "\n";
		res += "     " + down[2][0] + down[2][1] + down[2][2] + "\n";
		res += "     B\n";
		res += "     " + back[0][0] + back[0][1] + back[0][2] + "\n";
		res += "     " + back[1][0] + back[1][1] + back[1][2] + "\n";
		res += "     " + back[2][0] + back[2][1] + back[2][2] + "\n";
		res += "\n";
		return res;
	}

	// turn the cube according to each character within the string given
	private void turns(String turn) {
		for (int i = 0; i < turn.length(); i++) {
			turn(turn.charAt(i) + "");
		}
	}

	// turn the cube according to a certain given algorithm
	void turn(String algorithm) {
		System.out.println("algorithm is " + algorithm);
		// by calling with an ignore value, displaying the cube is easier
		turn(algorithm, -1);
		System.out.println(this);
	}

	// turn the cube according to the given algorithm
	private void turn(String algorithm, int ignroe) {
		RubiksCube copy = copyCube();
		if (algorithm.equals("U")) {
			rotate(up);
			front[0][0] = copy.right[0][0];
			front[0][1] = copy.right[0][1];
			front[0][2] = copy.right[0][2];
			left[0][0] = copy.front[0][0];
			left[0][1] = copy.front[0][1];
			left[0][2] = copy.front[0][2];
			back[0][0] = copy.left[0][0];
			back[0][1] = copy.left[0][1];
			back[0][2] = copy.left[0][2];
			right[0][0] = copy.back[0][0];
			right[0][1] = copy.back[0][1];
			right[0][2] = copy.back[0][2];
		} else if (algorithm.equals("D")) {
			rotate(down);
			front[2][0] = copy.left[2][0];
			front[2][1] = copy.left[2][1];
			front[2][2] = copy.left[2][2];
			right[2][0] = copy.front[2][0];
			right[2][1] = copy.front[2][1];
			right[2][2] = copy.front[2][2];
			back[2][0] = copy.right[2][0];
			back[2][1] = copy.right[2][1];
			back[2][2] = copy.right[2][2];
			left[2][0] = copy.back[2][0];
			left[2][1] = copy.back[2][1];
			left[2][2] = copy.back[2][2];
		} else if (algorithm.equals("F")) {
			rotate(front);
			up[2][0] = copy.left[2][2];
			up[2][1] = copy.left[1][2];
			up[2][2] = copy.left[0][2];
			right[0][0] = copy.up[2][0];
			right[1][0] = copy.up[2][1];
			right[2][0] = copy.up[2][2];
			down[0][0] = copy.right[2][0];
			down[0][1] = copy.right[1][0];
			down[0][2] = copy.right[0][0];
			left[2][2] = copy.down[0][2];
			left[1][2] = copy.down[0][1];
			left[0][2] = copy.down[0][0];
		} else if (algorithm.equals("B")) {
			rotate(back);
			up[0][0] = copy.right[0][2];
			up[0][1] = copy.right[1][2];
			up[0][2] = copy.right[2][2];
			left[0][0] = copy.up[0][2];
			left[1][0] = copy.up[0][1];
			left[2][0] = copy.up[0][0];
			down[2][0] = copy.left[0][0];
			down[2][1] = copy.left[1][0];
			down[2][2] = copy.left[2][0];
			right[0][2] = copy.down[2][2];
			right[1][2] = copy.down[2][1];
			right[2][2] = copy.down[2][0];
		} else if (algorithm.equals("L")) {
			rotate(left);
			front[0][0] = copy.up[0][0];
			front[1][0] = copy.up[1][0];
			front[2][0] = copy.up[2][0];
			down[0][0] = copy.front[0][0];
			down[1][0] = copy.front[1][0];
			down[2][0] = copy.front[2][0];
			back[2][2] = copy.down[0][0];
			back[1][2] = copy.down[1][0];
			back[0][2] = copy.down[2][0];
			up[0][0] = copy.back[2][2];
			up[1][0] = copy.back[1][2];
			up[2][0] = copy.back[0][2];
		} else if (algorithm.equals("R")) {
			rotate(right);
			up[0][2] = copy.front[0][2];
			up[1][2] = copy.front[1][2];
			up[2][2] = copy.front[2][2];
			back[0][0] = copy.up[2][2];
			back[1][0] = copy.up[1][2];
			back[2][0] = copy.up[0][2];
			down[0][2] = copy.back[2][0];
			down[1][2] = copy.back[1][0];
			down[2][2] = copy.back[0][0];
			front[0][2] = copy.down[0][2];
			front[1][2] = copy.down[1][2];
			front[2][2] = copy.down[2][2];
		} else {
			for (int i = 0; i < 3; i++) {
				turn(algorithm.toUpperCase(), -1);
			}
		}
	}

	// helper method to rotate a 2d array counterclockwise
	private void rotate(char[][] array) {
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < array.length / 2; x++) {
				for (int y = x; y < array.length - x - 1; y++) {
					char temp = array[x][y];
					array[x][y] = array[y][array.length - 1 - x];
					array[y][array.length - 1 - x] = array[array.length - 1 - x][array.length - 1 - y];
					array[array.length - 1 - x][array.length - 1 - y] = array[array.length - 1 - y][x];
					array[array.length - 1 - y][x] = temp;
				}
			}
		}
	}

	// helper method to check if one side is solved
	private boolean oneSideSolved(char[][] side) {
		char color = side[0][0];
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (side[r][c] != color) {
					return false;
				}
			}
		}
		return true;
	}

	// helper method to return a copy of the cube
	RubiksCube copyCube() {
		char[][] L = copy(left);
		char[][] R = copy(right);
		char[][] U = copy(up);
		char[][] D = copy(down);
		char[][] F = copy(front);
		char[][] B = copy(back);
		return new RubiksCube(F, B, L, R, U, D);
	}

	// helper method to return a copy of a two dimensional char array
	private char[][] copy(char[][] table) {
		char[][] copy = new char[table.length][table[0].length];
		for (int r = 0; r < copy.length; r++) {
			for (int c = 0; c < copy[r].length; c++) {
				copy[r][c] = table[r][c];
			}
		}
		return copy;
	}

	// helper method to return a copy of a char array
	private char[] copy(char[] array) {
		char[] copy = new char[array.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = array[i];
		}
		return copy;
	}

	// check if the cube is solved
	private boolean solved() {
		return oneSideSolved(up) && oneSideSolved(back) && oneSideSolved(front) && oneSideSolved(left)
				&& oneSideSolved(right) && oneSideSolved(down);
	}

	// first step: gather the white edges
	void whiteEdges() {
		boolean whiteEdgesInPlace = front[0][1] == 'W' && front[1][0] == 'W' && front[1][2] == 'W' && front[2][1] == 'W'
				&& left[1][2] == 'B' && right[1][0] == 'G' && down[0][1] == 'O' && up[2][1] == 'R';

		while (!whiteEdgesInPlace) {
			if (back[1][0] == 'W') {
				turns("B");
			} else if (back[1][2] == 'W') {
				turns("b");
			} else if (back[2][1] == 'W') {
				turns("BB");
			} else if (left[0][1] == 'W') {
				turns("UbuB");
			} else if (left[1][0] == 'W') {
				turns("LUbuBl");
			} else if (left[1][2] == 'W') {
				turns("LLb");
			} else if (left[2][1] == 'W') {
				turns("Lbl");
			} else if (right[0][1] == 'W') {
				turns("uBUb");
			} else if (right[1][0] == 'W') {
				turns("RuBUb");
			} else if (right[1][2] == 'W') {
				turns("ruBUbR");
			} else if (right[2][1] == 'W') {
				turns("RRuBUbRR");
			} else if (front[0][1] == 'W' && up[2][1] != 'R') {
				turns("UU");
			} else if (front[1][0] == 'W' && left[1][2] != 'B') {
				turns("FUUf");
			} else if (front[1][2] == 'W' && right[1][0] != 'G') {
				turns("fUUF");
			} else if (front[2][1] == 'W' && down[0][1] != 'O') {
				turns("FFUUFF");
			} else if (up[0][1] == 'W') {
				turns("BldLBB");
			} else if (up[1][0] == 'W') {
				turns("UBuldLBB");
			} else if (up[1][2] == 'W') {
				turns("uBUldLBB");
			} else if (up[2][1] == 'W') {
				turns("uuBldLBB");
			} else if (down[0][1] == 'W') {
				turns("DrBR");
			} else if (down[1][0] == 'W') {
				turns("DDrBRd");
			} else if (down[1][2] == 'W') {
				turns("dDrBRD");
			} else if (down[2][1] == 'W') {
				turns("ddDrBRDD");
			}

			System.out.println("checkpoint");
			if (back[0][1] == 'W') {
				char adjacent = up[0][1];
				if (adjacent == 'B') {
					turns("BLL");
				} else if (adjacent == 'R') {
					turns("UU");
				} else if (adjacent == 'G') {
					turns("bRR");
				} else {
					turns("BBDD");
				}
			}
			System.out.println(this);
			System.out.println("next step");

			whiteEdgesInPlace = front[0][1] == 'W' && front[1][0] == 'W' && front[1][2] == 'W' && front[2][1] == 'W'
					&& left[1][2] == 'B' && right[1][0] == 'G' && down[0][1] == 'O' && up[2][1] == 'R';
		}
	}

	// second step: gather the white corners
	void whiteCorners() {
		boolean whiteCornersInPlace = front[0][0] == 'W' && up[2][0] == 'R' && left[0][2] == 'B' && front[2][0] == 'W'
				&& left[2][2] == 'B' && down[0][0] == 'O' && front[2][2] == 'W' && down[0][2] == 'O'
				&& right[2][0] == 'G' && front[0][2] == 'W' && right[0][0] == 'W' && up[2][2] == 'R';

		while (!whiteCornersInPlace) {
			
			
			if (up[0][0] == 'W') {
				if (left[0][0] == 'O') {
					turns("BLBl");
				} else if (left[0][0] == 'G') {
					turns("bbDBd");
				} else if (left[0][0] == 'R') {
					turns("UBu");
				} else if (left[0][0] == 'B') {
					turns("UBu");
				}
			}

			whiteCornersInPlace = front[0][0] == 'W' && up[2][0] == 'R' && left[0][2] == 'B' && front[2][0] == 'W'
					&& left[2][2] == 'B' && down[0][0] == 'O' && front[2][2] == 'W' && down[0][2] == 'O'
					&& right[2][0] == 'G' && front[0][2] == 'W' && right[0][0] == 'W' && up[2][2] == 'R';
		}
	}

	// solve the cube using the Fridrich method
	void solve() {
		whiteEdges();
		whiteCorners();
	}
}
