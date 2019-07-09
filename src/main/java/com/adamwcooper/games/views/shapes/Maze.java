package com.adamwcooper.games.views.shapes;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class Maze {
    private int height;
    private int width;
    private boolean[][] grid;

    public Maze(int width, int height){
        this.width = width;
        this.height = height;
        Random rand = new Random();
        grid = new boolean[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                grid[i][j] = rand.nextBoolean();
            }
        }
    }

    public boolean getCoord(int row, int col){
        return this.grid[row][col];
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

    public void draw(){
        for (int i = 0; i < this.getHeight(); i += 1){
            for (int j = 0; j < this.getWidth(); j += 1){
                if (this.grid[i][j]){
                    this.drawGridCell(i,j);
                }
            }
        }
    }

    private void drawGridCell(int row, int col){
        float SQUARE_SIZE = .2f;
        glColor3f(0.5f,0.5f,1.0f);
        glBegin(GL_QUADS);
        float startingX = row * SQUARE_SIZE - 1;
        float startingY = col * SQUARE_SIZE - 1;
        glVertex2f(startingX,startingY);
        glVertex2f(startingX,startingY + SQUARE_SIZE);
        glVertex2f(startingX + SQUARE_SIZE,startingY + SQUARE_SIZE);
        glVertex2f(startingX + SQUARE_SIZE,startingY);
        glEnd();
        glFlush();
    }
}
