package com.adamwcooper.games.models;
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
        grid[0][0] = true;
    }

    public boolean getCoord(int col, int row){
        return 0 <= row && row < this.height && 0 <= col && col < this.width && this.grid[row][col];
    }

    public int getHeight(){ return this.height; }

    public int getWidth(){
        return this.width;
    }


}
