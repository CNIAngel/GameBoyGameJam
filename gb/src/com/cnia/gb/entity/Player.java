package com.cnia.gb.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cnia.gb.Art;
import com.cnia.gb.GBGame;
import com.cnia.gb.Input;

public class Player {
	
	// I need to sleep at some point
	// Oh my goddess I'm so stupid
	public int LEFT=0, RIGHT=1, UP=2, DOWN=3;

	public GBGame game;
	public Sprite currentSprite;
	public Rectangle bounds;
	public Vector2 position= new Vector2(0, 0), currentPosition= new Vector2(0, 0);
	
	
	public Player(GBGame game) {
		this.game = game;
		
		// Load up the stuff
		try {
			currentSprite = new Sprite(Art.player[0][0]);
		} catch (Exception e) {
			System.out.println("SPRITE NOT LOADING! TRY AGAIN!");
		}
		bounds = new Rectangle();
		currentPosition = new Vector2();
		position = new Vector2();
		
		// Set it up yo
		currentPosition.set(16, 16);
		position.set(currentPosition);
		bounds.set(position.x, position.y, 16, 16);
		currentSprite.setBounds(position.x, position.y, 16, 16);
	}
	
	public void update(float delta) {
		boolean leftPressed = game.input.buttons[Input.LEFT];
		boolean rightPressed = game.input.buttons[Input.RIGHT];
		boolean upPressed = game.input.buttons[Input.UP];
		boolean downPressed = game.input.buttons[Input.DOWN];
		
		if (leftPressed == true && !rightPressed == true && !downPressed == true && !upPressed == true) {
			if (!(currentPosition.x < 0)) {
				currentPosition.sub(16, 0);
				position.set(currentPosition);
				updateSprite(0);
			} else {
				currentPosition.sub(0, 0);
				position.set(currentPosition);
				updateSprite(0);
			}
		}
		if (rightPressed == true && !leftPressed == true && !downPressed == true && !upPressed == true) {
			if (!(currentPosition.x > game.w - bounds.width)) {
				currentPosition.add(16, 0);
				position.set(currentPosition);
				updateSprite(1);
			} else {
				currentPosition.add(0, 0);
				position.set(currentPosition);
				updateSprite(1);
			}
		}
		if (upPressed == true && !downPressed == true && !leftPressed == true && !rightPressed == true) {
			if (!(currentPosition.x > game.w - bounds.width)) {
				currentPosition.add(0, 16);
				position.set(currentPosition);
				updateSprite(2);
			} else {
				currentPosition.add(0, 0);
				position.set(currentPosition);
				updateSprite(2);
			}
		}
		if (downPressed == true && !upPressed == true && !leftPressed == true && !rightPressed == true) {
			if (!(currentPosition.x > game.w - bounds.width)) {
				currentPosition.sub(0, 16);
				position.set(currentPosition);
				updateSprite(3);
			} else {
				currentPosition.sub(0, 0);
				position.set(currentPosition);
				updateSprite(3);
			}
		}
		
		
		currentSprite.setX(position.x);
		currentSprite.setY(position.y);
		bounds.setX(position.x);
		bounds.setY(position.y);
	}
	
	public void render(SpriteBatch b) {
		currentSprite.draw(b);
	}
	
	// When calling on an array of textures it goes x then y ya dunce
	public void updateSprite(int currentState) {
		switch (currentState) {
		case 0: currentSprite.set(new Sprite(Art.player[2][0])); currentSprite.flip(true, false); break;
		case 1: currentSprite.set(new Sprite(Art.player[2][0])); break;
		case 2: currentSprite.set(new Sprite(Art.player[1][0])); break;
		case 3: currentSprite.set(new Sprite(Art.player[0][0])); break;
		}
	}
	
	// Update sprite and bounds position with this method
	public void setPosition(float x, float y) {
		currentPosition.set(x, y);
		position.set(position);
		currentSprite.setX(x);currentSprite.setY(y);
		bounds.setX(x); bounds.setY(y);
	}
	
}
