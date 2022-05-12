package com.omstead.gamebasics;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class L2GameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture lollipop;
	Sprite sprite;	//character in game
	
	int x, y = 0;
	float vx = -5.0f;
	float vy = 5.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		lollipop = new Texture("lollipop_pink.png");
		sprite = new Sprite(lollipop);  // also could do: sprite = new Sprite(new Texture("l_p.png");
		Random rand = new Random();
		x = rand.nextInt(Gdx.graphics.getWidth() + 1) + Gdx.graphics.getWidth();
		//x = (int)(Math.random()*Gdx.graphics.getWidth())+Gdx.graphics.getWidth();
		y = 100;
		sprite.setPosition(x, y);
		//sprite.setX(200);
		//sprite.setY(y);
		
		System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		// move sprite
		sprite.translateX(vx);
		//sprite.translateY(5.0f);
		//sprite.translate(vx, vy);
		
		// wrap the sprite around when it hits the left side of screen
		if(sprite.getX() < 0) {
			sprite.setX(Gdx.graphics.getWidth());
		}
		
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
}

