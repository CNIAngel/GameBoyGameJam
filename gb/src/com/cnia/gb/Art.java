package com.cnia.gb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Art {

	public static String alpha = "ABCDEFGH"+"IJKLMNOP"+"QRSTUVWX"+"YZ.: 123"+"4567890-";
	
	public static Texture start, credits, select, gb, cni;
	public static TextureRegion[][] player, screen, object, glyph;
	
	public static BitmapFont font, smallFont;
	public static int fontSize = 39, smallFontSize = 14;
	
	public static void loadAll() {

		start = loadTexture("start.png");
		credits = loadTexture("credits.png");
		select = loadTexture("select.png");
		gb = loadTexture("gameboy.png");
		cni = loadTexture("cniangel.png");
		
		player = loadTexture("player.png", 16, 16);
		screen = loadTexture("screen.png", 160, 144);
		object = loadTexture("object.png", 16, 16);
		glyph = loadTexture("alpha.png", 16, 16);
	}
	
	/**
	 * Method loadTexture
	 * Loads a full texture like a background screen or a single sprite by
	 * providing a path in the art folder.
	 * Example: testTex = loadTexture("test.png");
	 * @param path
	 * @return texS
	 */
	public static Texture loadTexture(String path){
		return new Texture(Gdx.files.internal("data/art/"+path));
	}
	
	/**
	 * Method loadTexture
	 * Loads a full spritesheet for use of tile map rendering and animation.
	 * Prove a path in the art folder, the width of the singular tile, and the 
	 * height of the singular tile.
	 * Example: testTex[][] = loadTexture("test.png", 32, 32);
	 * @param path
	 * @param w
	 * @param h
	 * @return
	 */
	public static TextureRegion[][] loadTexture(String path, int w, int h) {
		Texture tex = new Texture(Gdx.files.internal("data/art/"+path));
		
		int xSlice = tex.getWidth() / w;
		int ySlice = tex.getHeight() / h;
		
		TextureRegion[][] result = new TextureRegion[xSlice][ySlice];
		
		for (int x = 0; x < xSlice; x++) {
			for (int y = 0; y <ySlice; y++) {
				result[x][y] = new TextureRegion(tex, x*w, y*h, w, h);
				result[x][y].flip(false, false);
			}
		}
		return result;
	}
	
	public static void drawFont(String msg, SpriteBatch b, float x, float y) {
		msg=msg.toUpperCase();	
		for(int i=0;i<msg.length();i++){
		int letter=alpha.indexOf(msg.charAt(i));
		int xx=letter%8;
		int yy=letter/8;
		b.draw(glyph[xx][yy], x+i*glyph[xx][yy].getRegionWidth(), y);
		}
	}
	
	public static void dispose() {
		start.dispose();
		credits.dispose();
		select.dispose();
		gb.dispose();
		cni.dispose();
	}

}
