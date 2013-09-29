/**
 * 
 */
package com.cnia.gb.entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Grant
 *	Entity Interface starts with a Vector2 and a Rectangle for the moment
 */
public interface Entity {
Rectangle bounds = null;
Vector2 position = null;

public void getX();
public void getY();
public void getWidth();
public void getHeight();


}
