package com.cnia.gb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Sfx {

	public static Music splash, kill, game;
	
	public static void load(int track) {
		// TODO Auto-generated constructor stub
		switch (track) {
		case 0: splash = loadMusic("splash.ogg"); break;
		case 1: game = loadMusic("game.ogg"); break;
		case 2: kill = loadMusic("kill.ogg"); break;
		}
	}
	
	public static void play(int track) {
		switch (track) {
		case 0: splash.play(); splash.setLooping(true); break;
		case 1: game.play(); game.setLooping(true); break;
		case 2: kill.play(); kill.setLooping(true); break;
		}
	}
	
	public static void end(int track) {
		switch (track) {
		case 0: splash.stop(); splash.setLooping(false); break;
		case 1: game.stop(); game.setLooping(false); break;
		case 2: kill.stop(); kill.setLooping(false); break;
		}
	}
	
	
	public static Music loadMusic(String name) {
		
		Music music = Gdx.audio.newMusic(Gdx.files.internal("data/sfx/"+name));
		
		return music;
	}
	
	public static void dispose() {
		game.dispose();
		splash.dispose();
		kill.dispose();
	}

}
