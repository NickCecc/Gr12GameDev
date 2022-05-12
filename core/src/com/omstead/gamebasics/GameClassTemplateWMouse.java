package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClassTemplateWMouse extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Sprite sprite;
    int xPos, yPos;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("mm_blue.png");
        sprite = new Sprite(img);
        xPos = Gdx.graphics.getWidth() / 2;
        yPos = Gdx.graphics.getHeight() / 2;
        sprite.setPosition(xPos, yPos);


        System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
    }

    @Override
    public void render () {


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int xPos = Gdx.input.getX();
        // (0,0) of screen is lower left of screen
        // mouse co-ords come from upper left
        int yPos = Gdx.graphics.getHeight()-Gdx.input.getY();
        int x = Gdx.input.getX();
        // (0,0) of screen is lower left of screen
        // mouse co-ords come from upper left
        int y = Gdx.graphics.getHeight()-Gdx.input.getY();
        sprite.setPosition((float)(x - 0.5*sprite.getWidth()),
                (float)(y - 0.5*sprite.getHeight()));

        batch.begin();
        sprite.draw(batch);
        batch.end();




    }
}

