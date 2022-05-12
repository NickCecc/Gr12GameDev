package com.omstead.gamebasics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class SideScrollingGame extends ApplicationAdapter {
    Sprite pinky;

    SpriteBatch batch;
    Texture user;
    Texture background;
    Texture projectile;
    int sourceX;
    int lolliVX = 10;

    float vy;
    boolean jumping;

    ArrayList<Sprite> lollis = new ArrayList<Sprite>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("sideScrollBackground.png");
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        projectile = new Texture("lollipop_pink.png");

        user = new Texture("Pinky.png");
        System.out.println(Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight());
        pinky = new Sprite(user);
        pinky.setCenter(300, 60);
        System.out.println(pinky.getY());


    }

    @Override
    public void render() {
        if (pinky.getX() > 100) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                pinky.translateX(-5);
            }

        }
        if (pinky.getX() < 400) {
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                pinky.translateX(5);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            shoot();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            vy = 3;

            jumping = true;

        }
        if (jumping) {
            pinky.translateY(vy);
            System.out.println(vy);


        }
        if (pinky.getY() <= -3.9) {
            jumping = false;
        }
        vy -= 0.1;


        for (int i = lollis.size() - 1; i >= 0; i--) {
            lollis.get(i).translateX(lolliVX);
            // if off-screen, remove from ArrayList
            if (lollis.get(i).getX() > Gdx.graphics.getWidth()) {
                lollis.remove(i);
            }
        }

        if ((pinky.getX() >= 400) && (Gdx.input.isKeyPressed(Input.Keys.RIGHT))) {
            sourceX += 5;
        }
        if ((pinky.getX() <= 100) && (Gdx.input.isKeyPressed(Input.Keys.LEFT))) {
            sourceX -= 5;
        }


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(background, 0, 0, sourceX, 0, 600, 480);
        pinky.draw(batch);
        for (int i = 0; i < lollis.size(); i++) {
            lollis.get(i).draw(batch);
            if (lollis.get(i).getX() > Gdx.graphics.getWidth()) {
                lollis.remove(i);
            }
        }
        batch.end();


    }

    private void shoot() {
        Sprite lolli = new Sprite(projectile);
        lolli.setX(pinky.getX() + 100);
        lolli.setY(pinky.getY() + 15);

        lollis.add(lolli);

    }
}
