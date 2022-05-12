package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.input;

public class L5MouseFollowOnPress extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img1;
    Texture img2;
    Sprite[] sprites;
    int xPos, yPos;

    @Override
    public void create () {
        batch = new SpriteBatch();
        sprites = new Sprite[2];
        img1 = new Texture("mm_blue.png");
        img2 = new Texture("swirl_blue.png");

        sprites[0] = new Sprite(img1);
        sprites[1] = new Sprite(img2);
        sprites[0].setPosition(xPos-20, yPos-20);
        sprites[1].setPosition(xPos, yPos);


        xPos = Gdx.graphics.getWidth() / 2;
        yPos = Gdx.graphics.getHeight() / 2;


        System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (input.isButtonPressed(Input.Buttons.LEFT)) {
            int x = input.getX();
            int y = Gdx.graphics.getHeight() - input.getY();
            sprites[0].setPosition(x,y);
        }
        else if (input.isButtonPressed(Input.Buttons.RIGHT)){
            int x1 = input.getX();
            int y1 = Gdx.graphics.getHeight() - input.getY();
            sprites[1].setPosition(x1,y1);
        }

        batch.begin();
        for (int i = 0; i < sprites.length; i++ ){
            sprites[i].draw(batch);
        }
        batch.end();

    }
}

