package com.omstead.gamebasics;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class L6bKeyboardControlLaunch extends ApplicationAdapter {
    SpriteBatch batch;
    Texture projectile;
    Texture img;
    Sprite sprite;
    int x = 0;
    int y = 0;
    int vx = 3;
    int vy = 3;
    int lolliVX =5;

    ArrayList<Sprite> lollis = new ArrayList<Sprite>();

    @Override
    public void create() {
        batch = new SpriteBatch();

        // load the image at the start before the game begins
        projectile = new Texture("lollipop_pink.png");

        img = new Texture("swirl_blue.png"); // create a Texture (image)
        sprite = new Sprite(img);

        // start sprite in center of screen
        x = Gdx.graphics.getWidth() / 2;
        y = Gdx.graphics.getHeight() / 2;
        sprite.setPosition(x, y);
        System.out.println("Screen size: " + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            // use translate(vx,vy), translateX(vx) or translateY(vy)
            sprite.translateY(vy);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            sprite.translateX(vx*-1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            sprite.translateY(vy*-1);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            sprite.translateX(vx);
        }

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            fire();
        }

        // move lollipops
        for(int i=lollis.size()-1; i >=0; i--) {
            lollis.get(i).translateX(lolliVX);
            // if off-screen, remove from ArrayList
            if(lollis.get(i).getX() > Gdx.graphics.getWidth()) {
                lollis.remove(i);
            }
        }


        batch.begin();
        sprite.draw(batch);
        // draw lollipops to the screen
        for(int i = 0; i < lollis.size(); i++) {
            lollis.get(i).draw(batch);
            if (lollis.get(i).getX()> Gdx.graphics.getWidth()){
                lollis.remove(i);
            }
        }
        batch.end();
    }

    private void fire() {
        // create the new projectile; set its posn; add to ArrayList
        Sprite lollipop = new Sprite(projectile);
        // projectile starts at sprite
        lollipop.setPosition(sprite.getX() + 45, sprite.getY() + 25);
        lollis.add(lollipop);

    }
}
