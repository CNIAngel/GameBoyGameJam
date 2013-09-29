package com.cnia.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cnia.gb.Art;
import com.cnia.gb.GBGame;
import com.cnia.gb.Input;
import com.cnia.gb.Sfx;

public class CreditsScreen implements Screen {

	GBGame game;
	SpriteBatch batch;
	Input input;
	OrthographicCamera cam;
	
	Sprite sp;
	
	public CreditsScreen(GBGame game) {

		this.game = game;
		this.batch = game.batch;
		this.input = game.input;
		this.cam = game.camera;
		
		sp = new Sprite(Art.screen[1][1]);
		
		
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		boolean xPressed = input.buttons[Input.X];
		
		if (xPressed != false && input.oldButtons[Input.X]) {
			game.splash = new SplashScreen(game);
			game.setScreen(game.splash);
			Sfx.end(0);
		}
		
		batch.begin();
		sp.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		Sfx.dispose();
		Art.dispose();
	}

}
