package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClassTemplateWKeyboard extends ApplicationAdapter {
    Sprite sprite;
    SpriteBatch batch;
    Texture img;

    @Override
    public void create () {
        batch = new SpriteBatch();
        Texture img = new Texture("mm_blue.png");
        sprite = new Sprite(img);
        int x = Gdx.graphics.getWidth() / 2;
        int y = Gdx.graphics.getHeight() /2;
        sprite.setPosition(x,y);

        System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            sprite.translateY(5);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            sprite.translateY(-5);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            sprite.translateX(5);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            sprite.translateX(-5);
        }

        batch.begin();
        sprite.draw(batch);
        batch.end();


    }
}

