package console;

import java.util.ArrayList;

public class RubiksCube {

	public RubiksCube(char[][] front, char[][] back, char[][] left, char[][] right, char[][] top, char[][] down) {
		this.left = left;
		this.right = right;
		this.down = down;
		this.top = top;
		this.front = front;
		this.back = back;
	}
	
	public RubiksCube() {
		init();
		connected = new ArrayList<RubiksCube>();
		
		moves.add("U");
		moves.add("D");
		moves.add("R");
		moves.add("L");
		moves.add("F");
		moves.add("B");
		moves.add("U'");
		moves.add("D'");
		moves.add("R'");
		moves.add("L'");
		moves.add("F'");
		moves.add("B'");
	}
	
	ArrayList<RubiksCube> connected;
	
	// hold the data of each side of the cube
	char[][] left;
	char[][] right;
	char[][] top;
	char[][] down;
	char[][] front;
	char[][] back;
	
	ArrayList<String> moves = new ArrayList<String>();

	// scramble the cube
	void scramble() {
		// moves contains the strings representing the algorithms
		ArrayList<String> moves = new ArrayList<String>();
		moves.add("U");
		moves.add("D");
		moves.add("R");
		moves.add("L");
		moves.add("F");
		moves.add("B");
		moves.add("U'");
		moves.add("D'");
		moves.add("R'");
		moves.add("L'");
		moves.add("F'");
		moves.add("B'");

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
	
	public void initConnected() {
		connected = new ArrayList<RubiksCube>();
		
		moves.add("U");
		moves.add("D");
		moves.add("R");
		moves.add("L");
		moves.add("F");
		moves.add("B");
		moves.add("U'");
		moves.add("D'");
		moves.add("R'");
		moves.add("L'");
		moves.add("F'");
		moves.add("B'");
		
		for (int i = 0; i < moves.size(); i++) {
			turn(moves.get(i), -1);
			connected.add(copyCube());
			turn(moves.get(i), -1);
			turn(moves.get(i), -1);
			turn(moves.get(i), -1);
		}
	}

	// testing method to display the cube
	public String toString() {
		String res = "";
		res += "     T\n";
		res += "      " + top[0][0] + top[0][1] + top[0][2] + "\n";
		res += "      " + top[1][0] + top[1][1] + top[1][2] + "\n";
		res += "      " + top[2][0] + top[2][1] + top[2][2] + "\n";
		res += "L    F    R\n";
		res += "" + left[0][0] + left[0][1] + left[0][2] + "  " + front[0][0] + front[0][1] + front[0][2]
				+ "  " + right[0][0] + right[0][1] + right[0][2] + "\n";
		res += "" + left[1][0] + left[1][1] + left[1][2] + "  " + front[1][0] + front[1][1] + front[1][2]
				+ "  " + right[1][0] + right[1][1] + right[1][2] + "\n";
		res += "" + left[2][0] + left[2][1] + left[2][2] + "  " + front[2][0] + front[2][1] + front[2][2]
				+ "  " + right[2][0] + right[2][1] + right[2][2] + "\n";
		res += "     D\n";
		res += "      " + down[0][0] + down[0][1] + down[0][2] + "\n";
		res += "      " + down[1][0] + down[1][1] + down[1][2] + "\n";
		res += "      " + down[2][0] + down[2][1] + down[2][2] + "\n";
		res += "     B\n";
		res += "      " + back[0][0] + back[0][1] + back[0][2] + "\n";
		res += "      " + back[1][0] + back[1][1] + back[1][2] + "\n";
		res += "      " + back[2][0] + back[2][1] + back[2][2] + "\n";
		res += "\n";
		return res;
	}

	// turn the cube according to a certain given algorithm
	private void turn(String algorithm) {
		// by calling with an ignore value, displaying the cube is easier
		turn(algorithm, -1);
		System.out.println(this);
	}

	// turn the cube according to the given algorithm
	private void turn(String algorithm, int ignore) {
		if (algorithm.equals("U")) {
			char[] f = copy(front[0]);
			char[] l = copy(left[0]);
			char[] b = copy(back[0]);
			char[] r = copy(right[0]);

			front[0] = r;
			left[0] = f;
			back[0] = l;
			right[0] = b;
			rotate(top);
			rotate(top);
			rotate(top);
		} else if (algorithm.equals("D")) {
			char[] f = copy(front[2]);
			char[] l = copy(left[2]);
			char[] b = copy(back[2]);
			char[] r = copy(right[2]);

			front[2] = l;
			left[2] = b;
			back[2] = r;
			right[2] = f;
			rotate(down);
			rotate(down);
			rotate(down);
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
			rotate(left);
			rotate(left);
			rotate(left);
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
			rotate(right);
			rotate(right);
			rotate(right);
		} else if (algorithm.equals("F")) {
			char[] u = { top[2][0], top[2][1], top[2][2] };
			char[] r = { right[0][0], right[1][0], right[2][0] };
			char[] d = { down[0][0], down[0][1], down[0][2] };
			char[] l = { left[0][2], left[1][2], left[2][2] };
			
			right[0][0] = u[0];
			right[1][0] = u[1];
			right[2][0] = u[2];
			down[0][0] = r[0];
			down[0][1] = r[1];
			down[0][2] = r[2];
			left[0][2] = d[0];
			left[1][2] = d[1];
			left[2][2] = d[2];
			top[2][0] = l[0];
			top[2][1] = l[1];
			top[2][2] = l[2];
			rotate(front);
			rotate(front);
			rotate(front);
		} else if (algorithm.equals("B")) {
			char[] u = { top[0][0], top[0][1], top[0][2] };
			char[] r = { right[0][2], right[1][2], right[2][2] };
			char[] d = { down[2][0], down[2][1], down[2][2] };
			char[] l = { left[0][0], left[1][0], left[2][0] };
			
			right[0][0] = d[0];
			right[1][0] = d[1];
			right[2][0] = d[2];
			down[0][0] = l[0];
			down[0][1] = l[1];
			down[0][2] = l[2];
			left[0][2] = u[0];
			left[1][2] = u[1];
			left[2][2] = u[2];
			top[2][0] = r[0];
			top[2][1] = r[1];
			top[2][2] = r[2];
			rotate(back);
			rotate(back);
			rotate(back);
		} else {
			if (algorithm.equals("U'")) {
				turn("U", -1);
				turn("U", -1);
				turn("U", -1);
			} else if (algorithm.equals("D'")) {
				turn("D", -1);
				turn("D", -1);
				turn("D", -1);
			} else if (algorithm.equals("L'")) {
				turn("L", -1);
				turn("L", -1);
				turn("L", -1);
			} else if (algorithm.equals("R'")) {
				turn("R", -1);
				turn("R", -1);
				turn("R", -1);
			} else if (algorithm.equals("F'")) {
				turn("F", -1);
				turn("F", -1);
				turn("F", -1);
			} else if (algorithm.equals("B'")) {
				turn("B", -1);
				turn("B", -1);
				turn("B", -1);
			}
		}
	}

	// helper method to rotate a 2d array clockwise
	private void rotate(char[][] array) {
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
		char[][] T = copy(top);
		char[][] D = copy(down);
		char[][] F = copy(front);
		char[][] B = copy(back);
		return new RubiksCube(F, B, L, R, T, D);
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
		return oneSideSolved(top) && oneSideSolved(back) && oneSideSolved(front) && oneSideSolved(left)
				&& oneSideSolved(right) && oneSideSolved(down);
	}
	
	
	void solve() {

	}
}
