package com.cnia.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.cnia.gb.GBGame;
import com.cnia.gb.Input;
import com.cnia.gb.entity.Player;

public class TestScreen implements Screen {

	GBGame game;
	SpriteBatch batch;
	Input input;
	OrthographicCamera cam;
	
	Rectangle exitPoint;
	
	Player playa;
	
	// Tiled shit
	TiledMap map;
	OrthogonalTiledMapRenderer renderer;
	float unitScale = 1/16f;
	
	// Make multiple maps or make one large map and separate it?
	
	
	
	public TestScreen(GBGame game) {
		this.game = game;
		this.batch = game.batch;
		this.input = game.input;
		
		exitPoint = new Rectangle();
		exitPoint.set(144, 32, 16, 16);
		
		loadAssets();
		loadMap(0);
	}
	
	private void loadAssets() {
		// TODO Auto-generated method stub
		playa = new Player(game);
	}
	
	private void loadMap(int mapNumber) {
		
		switch (mapNumber) {
		case 0: map = new TmxMapLoader().load("data/levels/test.tmx"); break;
		case 1: map = new TmxMapLoader().load("data/levels/test2.tmx"); break;
		}
		
		TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get(2);
		MapObjects objects = layer.getObjects();
		
		
		cam = new OrthographicCamera();
		renderer = new OrthogonalTiledMapRenderer(map, unitScale);
		cam.setToOrtho(false, 10, 9);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		cam.update();
		renderer.setView(cam);
		renderer.render();
		
		batch.begin();
		playa.render(batch);
		batch.end();
		
		
		
		if (playa.bounds.overlaps(exitPoint)) {
			playa.setPosition(0, 32);
			loadMap(1);
		}
		
		playa.update(delta);
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
		
	}

}
