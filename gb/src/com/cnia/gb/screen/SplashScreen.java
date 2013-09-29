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

public class SplashScreen implements Screen {
	
	GBGame game;
	SpriteBatch batch;
	Input input;
	OrthographicCamera cam;
	
	Sprite fgsp, bgsp, bgsp2, fgsp2, sp3, sel, str, cred;
	
	int position = 0;
	
	boolean drawmb = false;
	boolean  drawt = false;
	boolean finaL = false;
	boolean end = false;
	
	int counter = 0, moveCounter = 0, phase = 0, move2 = 0, count2 =0;
	
	public SplashScreen(GBGame game) {
		this.game = game;
		this.batch = game.batch;
		this.input = game.input;
		this.cam = game.camera;
		
		drawmb = false;
		drawt = false;
		
		Sfx.load(0);
		Sfx.play(0);
		
		bgsp = new Sprite(Art.screen[0][0]);
		fgsp = new Sprite(Art.gb);
		bgsp2 = new Sprite(Art.screen[1][0]);
		fgsp2 = new Sprite(Art.cni);
		sp3 = new Sprite(Art.screen[0][1]);
		sel = new Sprite(Art.select); str = new Sprite(Art.start); cred = new Sprite(Art.credits);
		
		setUpPositions();
		
		
	}
	
	public void setUpPositions() {
		fgsp.setY(48);
		fgsp.setX(40);
		bgsp2.setX(game.w);
		fgsp2.setX(game.w + 53);
		fgsp2.setY(48);
		sp3.setX(game.w);
		sp3.setY(-game.h);
		sel.setY(-50); cred.setY(-50); str.setY(-50);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		boolean zPressed = input.buttons[Input.Z];
		boolean xPressed = input.buttons[Input.X];
		
		if (zPressed != false && input.oldButtons[Input.Z]) {
			finaL = false;
			end = true;
			phase =  0;
			// Sprites
			sel = new Sprite(Art.select); str = new Sprite(Art.start); cred = new Sprite(Art.credits);
			// Position
			sp3.setX(0); sp3.setY(0);
			sel.setX(57); sel.setY(48);
			str.setX(73); str.setY(48);
			cred.setX(73); cred.setY(32);
		}
		
		if (end != false ) {
			if (xPressed != false && input.oldButtons[Input.X] && position == 0 ) {
				game.test = new TestScreen(game);
				game.setScreen(game.test);
			} else if (xPressed != false && input.oldButtons[Input.X] && position == 1) {
				game.cred = new CreditsScreen(game);
				game.setScreen(game.cred);
			}
		}
		
		// Phase one - Make the madefor sprites draw and start moving all of them tothe left till the made for
		// is the only one visible.
		selectorUpdate();
		
		batch.begin();
		bgsp.draw(batch);
		fgsp.draw(batch);
		bgsp2.draw(batch);
		fgsp2.draw(batch);
		sp3.draw(batch);
		str.draw(batch); sel.draw(batch); cred.draw(batch);
		batch.end();
		
		
		
		if (end != true) {
			transform();
			debug();
			Gdx.graphics.requestRendering(); 	
		}
		
		
	}
	
	private void transform() {
		if (drawmb != true) {
			counter++;
		} else {
			moveCounter++;
		}
		if (drawt != false && finaL != true) {
			count2++;
		} else {
			move2++;
		}
		if (counter > 105) {
			drawmb = true;
			
			counter = 0;
		}
		if (count2 > 105) {
			finaL = true;
			
			count2 = 0;
		}
		if (move2 > 2 && finaL != false) {
			sp3.setY(sp3.getY() + 2);
			bgsp2.setY(bgsp2.getY() + 2);
			fgsp2.setY(fgsp2.getY() + 2);
			move2 = 0;
			phase++;
		}
		if (moveCounter > 2 && drawt != true) {
			
			bgsp.setX(bgsp.getX() - 2);
			fgsp.setX(fgsp.getX() - 2);
			bgsp2.setX(bgsp2.getX() - 2);
			fgsp2.setX(fgsp2.getX() - 2);
			sp3.setX(sp3.getX() - 2);
			
			moveCounter = 0;
			phase++;
		}
		if (phase > 79 || phase > 71 && finaL != false) {
			drawt = true;
			if (finaL != false) {
				finaL = false;
				end = true;
				phase =  0;
				// Sprites
				sel = new Sprite(Art.select); str = new Sprite(Art.start); cred = new Sprite(Art.credits);
				// Position
				sel.setX(57); sel.setY(48);
				str.setX(73); str.setY(48);
				cred.setX(73); cred.setY(32);
			}
			phase = 0;
		}
	}
	
	private void debug() {
		System.out.println("Counter: "+counter+"Mover: "+moveCounter+"Phaser: "+phase);
	}
	private void selectorUpdate() {
		if (Gdx.input.isKeyPressed(Keys.DOWN) && position == 0) {
			sel.setY(sel.getY() - 16);
			position = 1;
		} else if (Gdx.input.isKeyPressed(Keys.UP) && position == 1) {
			sel.setY(sel.getY() + 16);
			position = 0;
		}
		
		
			
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
