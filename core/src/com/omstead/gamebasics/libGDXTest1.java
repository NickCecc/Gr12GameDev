package com.omstead.gamebasics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class libGDXTest1 extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture img2;
    Texture img3;
    Sprite flappy;
    Sprite invader;
    ArrayList<Sprite> projectiles;
    int mouseX;
    int invaderY = 175;
    int invaderX = 10;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("pink_flappy.png");
        flappy = new Sprite(img);
        flappy.setScale(.2f,.2f);
        flappy.setPosition(Gdx.graphics.getWidth()/2, -175);

        img2 = new Texture("space_invader.png");
        invader = new Sprite(img2);
        invader.setScale(.1f,.1f);
        invader.setPosition(-300,175 );
        img3 = new Texture("headshot.png");

        projectiles = new ArrayList<Sprite>();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mouseX  = Gdx.input.getX();

        if (mouseX < 725  && mouseX > 75){
            flappy.setCenterX(mouseX);
        }

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            fire();
        }

        if (invader.getX() > 420 || invader.getX() < -325) {
            invaderY -= 50;
            invaderX *= -1;

        }
        invader.setY(invaderY);
        invader.translateX(invaderX);

        if (invader.getY() < -125) {
            invader.setX(1000);
        }

        batch.begin();
        flappy.draw(batch);

        invader.draw(batch);
        for (int i = 0; i < projectiles.size();i++){
            projectiles.get(i).draw(batch);
            projectiles.get(i).translateY(5);

            if (projectiles.get(i).getY() > 420) {
                projectiles.remove(i);
            }
        }
        batch.end();
    }
    public void fire(){
        Sprite head = new Sprite(img3);
        head.setScale(.4f,.4f);
        head.setPosition(flappy.getX()+ flappy.getWidth()/2 - head.getWidth()/2, 10 );
        projectiles.add(head);
    }

}
