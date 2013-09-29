/**
 * 
 */
package com.cnia.gb.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Grant
 *	Entity Interface starts with a Vector2 and a Rectangle for the moment
 */
public interface Entity {
Rectangle bounds = null;
Vector2 position = null;

public void update(float delta);
public void render(SpriteBatch b);

public float getX();
public float getY();
public float getWidth();
public float getHeight();
public Vector2 getPosition();
public Rectangle getBounds();
public void setX(float newX);
public void setY(float newY);
public void setWidth(float newWidth);
public void setHeight(float newHeight);
public void setPosition(Vector2 newPosition);
public void setBounds(Rectangle newBounds);
}
