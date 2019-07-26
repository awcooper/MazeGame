package com.adamwcooper.games.models;

public class Circle {

    private int y;
    private int x;

    public Circle( int x, int y) {
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
}
