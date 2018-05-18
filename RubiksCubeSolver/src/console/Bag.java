package console;

import java.util.ArrayList;

// a bag of rubik's cubes
public class Bag {

	ArrayList<RubiksCube> list = new ArrayList<RubiksCube>();
	
	void add(RubiksCube cube) {
		if (!contains(cube)) {
			list.add(cube);
		}
	}
	
	boolean contains(RubiksCube cube) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isEqual(cube)) {
				return true;
			}
		}
		return false;
	}
	
	void combine(Bag bag) {
		for (int i = 0; i < bag.list.size(); i++) {
			list.add(bag.list.get(i));
		}
	}
}
