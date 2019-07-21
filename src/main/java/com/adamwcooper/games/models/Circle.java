package com.adamwcooper.games.models;

public class Circle {

    private final float radius;
    private int y;
    private int x;

    public Circle(float radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
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
