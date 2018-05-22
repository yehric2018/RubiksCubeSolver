package gfx;

import gfx.cube.GraphicsCube;
import gfx.input.KeyManager;

public class Handler {
	private Program program;
	public Handler(Program program) {
		this.program = program;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public KeyManager getKeyManager() {
		return program.getKeyManager();
	}
	
	public GraphicsCube getCube() {
		return program.getCube();
	}
}
