package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BouncingBall extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite sprite;
    Texture img;
    int x,y;
    int vx = 4;
    int vy = 4;


    @Override
    public void create () {
batch = new SpriteBatch();
img = new Texture("mm_blue.png");
sprite = new Sprite(img);
x = Gdx.graphics.getWidth()/2;
y = Gdx.graphics.getHeight()/2;

sprite.setPosition(x,y);
        System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


            sprite.translateX(vx);
            sprite.translateY(vy);



        if ((sprite.getX() > Gdx.graphics.getWidth() - sprite.getWidth()) || sprite.getX() < 0){
            vx*=-1;
        }
        else if (sprite.getY() < 0 || sprite.getY() > Gdx.graphics.getHeight() - sprite.getWidth()){
            vy*=-1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){
            if (vx > 0) {
                vx--;
            }
            else if (vx < 0){
                vx++;
            }

        }


batch.begin();
        sprite.draw(batch);
        batch.end();
    }

}

