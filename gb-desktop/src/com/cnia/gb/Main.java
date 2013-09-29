package com.cnia.gb;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Puzzle Rush";
		cfg.useGL20 = false;
		cfg.width = 160;
		cfg.height = 144;
		cfg.resizable = false;
		
		new LwjglApplication(new GBGame(), cfg);
	}
}
