package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite bg;
    Texture background;
    Texture pipe;
    Texture player;
    Sprite flappy;
    float vy;
    boolean jumping;
    float time = 0;
    int rand1;
    int rand2;


    ArrayList<Sprite> pipes = new ArrayList<Sprite>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("background1.png");
        pipe = new Texture("pipe.png");
        player = new Texture("flappy.png");
        bg = new Sprite(background);
        flappy = new Sprite(player);
        flappy.setPosition(10, 220);


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            vy = 4;
            jumping = true;
        }

        if (jumping) {
            flappy.translateY(vy);
        }

        time += Gdx.graphics.getDeltaTime();
        if (time >= 1) {
            makePipe();
            time = 0;
        }


        for (int i = pipes.size() - 1; i >= 0; i--) {
            pipes.get(i).translateX(-3);
            // if off-screen, remove from ArrayList
            if (pipes.get(i).getX() > Gdx.graphics.getWidth()) {
                pipes.remove(i);
            }
        }

        if (flappy.getY() <= 0) {
            Gdx.app.exit();
        }


        vy -= 0.2;

        batch.begin();
        bg.draw(batch);
        flappy.draw(batch);
        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).draw(batch);

        }
        batch.end();
    }

    private void makePipe() {
        rand1 = 260 + new Random().nextInt(170);
        rand2 = -200 + new Random().nextInt(190);
        Sprite Pipe = new Sprite(pipe);
        Pipe.setX(600);
        Pipe.setY(rand1);
        pipes.add(Pipe);
        Sprite Pipe2 = new Sprite(pipe);
        Pipe2.setX(600);
        Pipe2.setY(rand2);
        pipes.add(Pipe2);
    }

}