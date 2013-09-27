package com.cnia.gb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cnia.gb.screen.TestScreen;

public class GBGame extends Game {
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public Input input;
	public FPSLogger logger;
	public float w, h;
	
	/* Screens */
	public TestScreen test;
	
	@Override
	public void create() {
		// So it doesn't bug me about the power of 2
		Texture.setEnforcePotImages(false);
		// Changes the rendering to a fixed step instad of all the time
		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();
		// Width and Height
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		input = new Input();
		logger = new FPSLogger();
		Gdx.input.setInputProcessor(input);
		Art.loadAll();
		
		if (test == null) test = new TestScreen(this);
		
		setScreen(test);
		
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
		input.tick();
		logger.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
