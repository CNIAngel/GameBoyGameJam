package com.cnia.gb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Sfx {

	public static Music gameMuse;
	public static Music endMuse;
	
	public static void loadAll() {
		// TODO Auto-generated constructor stub
		//gameMuse = loadMusic("ugh.wav");
		//endMuse = loadMusic("pause.wav");
	}
	
	public static void playGameMusic() {
		gameMuse.play();
		gameMuse.setLooping(true);
	}
	
	public static void playEndMusic() {
		endMuse.play();
		endMuse.setLooping(true);
	}
	
	public static void stopGameMusic() {
		gameMuse.setLooping(false);
		gameMuse.stop();
	}
	
	public static void stopEndMusic() {
		endMuse.setLooping(false);
		endMuse.stop();
	}
	
	public static Music loadMusic(String name) {
		return Gdx.audio.newMusic(Gdx.files.internal("data/sfx/"+name));
	}

}
