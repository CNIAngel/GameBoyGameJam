package com.cnia.gb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Art {

	// Sleep
	
	public static TextureRegion[][] player;
	
	public static BitmapFont font, smallFont;
	public static int fontSize = 39, smallFontSize = 14;
	
	public static void loadAll() {

		player = loadTexture("player.png", 16, 16);
		
		font = loadBitmapFont("Dynarec.ttf", fontSize, false);
		smallFont = loadBitmapFont("Dynarec.ttf", smallFontSize, false);
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
	
	public static BitmapFont loadBitmapFont(String path, int size, boolean isFixedWidth)
	{
		BitmapFont output;
		String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
		FreeTypeFontGenerator ftg = new FreeTypeFontGenerator(
				Gdx.files.internal("data/art/" + path));
		output = ftg.generateFont(size, FONT_CHARACTERS, false);
		if (isFixedWidth)
			output.setFixedWidthGlyphs(FONT_CHARACTERS);
		ftg.dispose();
		return output;
	}

}
