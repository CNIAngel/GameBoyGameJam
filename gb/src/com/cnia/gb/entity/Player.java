package com.cnia.gb.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cnia.gb.Art;
import com.cnia.gb.GBGame;
import com.cnia.gb.Input;
import com.cnia.gb.screen.TestScreen;

public class Player {
	
	// I need to sleep at some point
	// Oh my goddess I'm so stupid
	public int LEFT=0, RIGHT=1, UP=2, DOWN=3;

	public GBGame game;
	TiledMapTileLayer collisionLayer;
	public Sprite currentSprite;
	public Rectangle bounds;
	public Vector2 position= new Vector2(0, 0), currentPosition= new Vector2(0, 0);
	
	
	public Player(float x, float y,GBGame game, TiledMapTileLayer layer) {
		this.game = game;
		this.collisionLayer = layer;
		
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
		position.set(x, y);
		currentPosition.set(x, y);
		currentSprite.setBounds(position.x, position.y, 16, 16);
		bounds.set(position.x, position.y, 16, 16);
		
		if (collisionLayer == null) {
			try {
				collisionLayer = layer;
				System.out.println("Layer was null. Loaded the passed layer.");
			} catch (Exception e) {
				System.out.println("Layer was null. Tried to fix it. It didn't work.");
			}
		}
		
	}
	
	public void update(float delta) {
		
		
		if (collisionLayer == null) {
			System.out.println("It's fucking null.");
		}
		
		float oldX = getX(), oldY = getY(), tileWidth = getLayer().getTileWidth(), tileHeight = getLayer().getTileHeight(); 
		
		try {
			tileWidth = collisionLayer.getTileWidth();
			tileHeight = collisionLayer.getTileHeight();
		} catch (Exception e) {
			System.out.println("Tile variables not loaded. Check layer loading.");
		}
		
		updateMovement();
		
		boolean collision = false;
		
		collision = collisionLayer.getCell((int) (currentPosition.x / tileWidth), (int) (currentPosition.y / tileHeight)).getTile().getProperties().containsKey("isBlocked");
		
		
		
		if (collision != true) {
			position.set(currentPosition);
			currentSprite.setX(position.x);
			currentSprite.setY(position.y);
			bounds.setX(position.x);
			bounds.setY(position.y);
		} else {
			currentPosition.set(oldX, oldY);
			currentSprite.setX(oldX);
			currentSprite.setY(oldY);
			bounds.setX(oldX);
			bounds.setY(oldY);
		}
		
		
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
		currentSprite.setX(x);currentSprite.setY(y);
		position.set(position);
		bounds.setX(x); bounds.setY(y);
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public float getHeight() {
		return bounds.getHeight();
	}
	
	public float getWidth() {
		return bounds.getWidth();
	}
	
	public TiledMapTileLayer getLayer() {
		return collisionLayer;
	}
	
	public void setX(float newX) {
		position.set(newX, position.y);
	}
	
	public void setY(float newY) {	
		position.set(position.y, newY);
	}
	
	public void updateMovement() {
		boolean leftPressed = game.input.buttons[Input.LEFT];
		boolean rightPressed = game.input.buttons[Input.RIGHT];
		boolean upPressed = game.input.buttons[Input.UP];
		boolean downPressed = game.input.buttons[Input.DOWN];
		
		if (leftPressed == true && !rightPressed == true && !downPressed == true && !upPressed == true) {
			currentPosition.sub(16, 0);
			updateSprite(0);
		}
		if (rightPressed == true && !leftPressed == true && !downPressed == true && !upPressed == true) {
				currentPosition.add(16, 0);
				updateSprite(1);
		}
		if (upPressed == true && !downPressed == true && !leftPressed == true && !rightPressed == true) {
				currentPosition.add(0, 16);
				updateSprite(2);
		}
		if (downPressed == true && !upPressed == true && !leftPressed == true && !rightPressed == true) {
				currentPosition.sub(0, 16);
				updateSprite(3);
		}
	}
	
}
