package com.adamwcooper.games.views.shapes;

import static org.lwjgl.opengl.GL11.*;
import java.lang.*;

public class Circle {

    private final float radius;
    private float y;
    private float x;

    public Circle(float radius, float x, float y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public void draw(){
        glColor3f(1.0f,1.0f,1.0f);
        glBegin(GL_TRIANGLE_FAN);
        float xcord;
        float ycord;
        for (float i = 0; i < 360; i++){
            xcord = (float) Math.cos(Math.toRadians(i)) * this.radius + this.x;
            ycord = (float) Math.sin(Math.toRadians(i)) * this.radius + this.y;
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

    public float getX() { return this.x; }

    public float getY() { return this.y; }

    public float getRadius() { return this.radius; }
}
