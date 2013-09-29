package com.cnia.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.cnia.gb.Art;
import com.cnia.gb.GBGame;
import com.cnia.gb.Input;
import com.cnia.gb.Sfx;
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
	public TiledMapTileLayer layer;
	OrthogonalTiledMapRenderer renderer;
	float unitScale = 1/16f;
	
	public Array<Rectangle> tiles = new Array<Rectangle>();
	public Array<Sprite> sprites = new Array<Sprite>();
	
	
	public TestScreen(GBGame game) {
		this.game = game;
		this.batch = game.batch;
		this.input = game.input;
		
		exitPoint = new Rectangle();
		exitPoint.set(144, 32, 16, 16);
		
		Sfx.end(0);
		Sfx.load(1);
		Sfx.play(1);
		
		loadMap(0);
		loadAssets();
		
		
	}
	
	private void loadAssets() {
		// TODO Auto-generated method stub
		playa = new Player(game, layer);
	}
	
	private void loadMap(int mapNumber) {
		
		map = new TmxMapLoader().load("data/levels/level"+mapNumber+".tmx");
		
		layer = (TiledMapTileLayer)map.getLayers().get(0);
		
		for(MapObject object : map.getLayers().get("objects").getObjects())
            if (object instanceof RectangleMapObject) {
            	if (object.getProperties().containsKey("spike")) {
            		Rectangle rect = ((RectangleMapObject) object).getRectangle();
                	Sprite spike = new Sprite(Art.object[1][0]);
                	spike.setBounds(rect.x, rect.y, rect.width, rect.height);
                	sprites.add(spike);
            	} else if (object.getProperties().containsKey("button")) {
            		Rectangle rect = ((RectangleMapObject) object).getRectangle();
                	Sprite button = new Sprite(Art.object[0][5]);
                	button.setBounds(rect.x, rect.y, rect.width, rect.height);
                	sprites.add(button);
            	}
            }
		 
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
		
		if (playa.bounds.overlaps(exitPoint)) {
			playa.setPosition(-16, 32);
			loadMap(1);
		}
		
		playa.update(delta);
		
		batch.begin();
		for (Sprite sprite : sprites)
			sprite.draw(batch);
		playa.render(batch);
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
