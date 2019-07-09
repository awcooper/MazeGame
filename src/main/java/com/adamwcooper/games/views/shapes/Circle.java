package com.adamwcooper.games.views.shapes;

import static org.lwjgl.opengl.GL11.*;
import java.lang.*;

public class Circle {

    private final float radius;
    private int y;
    private int x;

    public Circle(float radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public void draw(){
        float SQUARE_SIZE = .2f;
        glColor3f(1.0f,1.0f,1.0f);
        glBegin(GL_TRIANGLE_FAN);
        float xcord;
        float ycord;
        float xstart = this.x * SQUARE_SIZE - 1 + (SQUARE_SIZE / 2);
        float ystart = this.y * SQUARE_SIZE - 1 + (SQUARE_SIZE / 2);
        for (float i = 0; i < 360; i++){
            xcord = (float) Math.cos(Math.toRadians(i)) * this.radius + xstart;
            ycord = (float) Math.sin(Math.toRadians(i)) * this.radius + ystart;
            glVertex2f(xcord,ycord);
        }
        glEnd();
        glFlush();
    }

    public void incrementX(float dx){
        this.x += dx;
    }

    public void incrementY(float dy){
        this.y += dy;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public float getRadius() { return this.radius; }
}
