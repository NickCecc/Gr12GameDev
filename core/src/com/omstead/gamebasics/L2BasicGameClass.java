package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class L2BasicGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;
	Texture user;
	Texture background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		user = new Texture("badlogic.jpg");
		sprite = new Sprite(user);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(sprite, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		user.dispose();
	}
}
