package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class test extends ApplicationAdapter {
    Sprite sprite;
    Texture img;
    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("mm_blue.png");
        sprite = new Sprite(img);
        sprite.setPosition(100,100);

        System.out.println(sprite.getX());
        System.out.println(sprite.getY());


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        sprite.draw(batch);
        batch.end();
    }
}
