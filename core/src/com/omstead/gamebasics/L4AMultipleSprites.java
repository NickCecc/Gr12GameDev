package com.omstead.gamebasics;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class L4AMultipleSprites extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite[] sprites; 
	
	@Override
	public void create() {
		// create SpriteBatch
		batch = new SpriteBatch();
		
		sprites = new Sprite[10]; 	// 10 sprites
		Texture img = new Texture("lollipop_pink.png");	// create new Texture (image)
		for(int i = 0; i < 10; i++) {
			sprites[i] = new Sprite(img);
			
			// start sprites off-screen to the right
			Random rand = new Random();
			int x = rand.nextInt(Gdx.graphics.getWidth() + 1) + Gdx.graphics.getWidth();
			// keep this within the height of the screen
			int y = rand.nextInt(Gdx.graphics.getHeight() + 1);
			sprites[i].setPosition(x, y);
			
			System.out.format("%d, %d", x, y);
		}
	}

	@Override
	public void render() {
		// set background colour
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// move sprites on-screen
		for(int i = 0; i < sprites.length; i++) {
			sprites[i].translateX(-5);	
			// or use a variable for speed: sprites[i].translateX(vx);
		}
		
		// start drawing sprites to screen
		batch.begin();
		for(int i = 0; i < sprites.length; i++) {
			sprites[i].draw(batch);
		}
		batch.end();
	}
}
