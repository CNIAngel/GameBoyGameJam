package com.cnia.gb.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cnia.gb.Art;

public class Spike implements Entity {

	public Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	Sprite cursprite;
	float width, height;
	int state;
	
	public Spike(float x, float y) {
		// TODO Auto-generated constructor stub
		this.position.x = x;
		this.position.y = y;
		width = 16;
		height = 16;
		cursprite = new Sprite(Art.object[1][0]);
		cursprite.setBounds(x, y, width, height);
		bounds = getBounds();
		state = 1;
	}
	
	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(SpriteBatch b) {
		cursprite.draw(b);
	}

	/**
	 * Getters and Setters
	 */
	@Override
	public float getX() {
		return position.x;
	}
	@Override
	public float getY() {
		return position.y;
	}
	@Override
	public float getWidth() {
		return width;
	}
	@Override
	public float getHeight() {
		return height;
	}
	@Override
	public Vector2 getPosition() {
		return new Vector2(position);
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	@Override
	public void setX(float newX) {
		position.x = newX;
	}
	@Override
	public void setY(float newY) {
		position.y = newY;
	}
	@Override
	public void setWidth(float newWidth) {
		width = newWidth;
	}
	@Override
	public void setHeight(float newHeight) {
		height = newHeight;
	}
	@Override
	public void setPosition(Vector2 newPosition) {
		position.set(newPosition);
	}
	@Override
	public void setBounds(Rectangle newBounds) {
		bounds.set(newBounds);
	}

}
