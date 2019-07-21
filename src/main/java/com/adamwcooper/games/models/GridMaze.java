package com.adamwcooper.games.models;

import java.util.Random;
import static java.lang.Math.abs;


public class GridMaze implements Maze {
    private int height;
    private int width;
    private boolean[][] grid;

    public GridMaze(int width, int height){
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
        return isCoordInBounds(row,col) && this.grid[row][col];
    }

    boolean isCoordInBounds(int row, int col){
        return isRowInBounds(row) && isColInBounds(col);
    }

    boolean isRowInBounds(int row){
        return 0 <= row && row < this.height;
    }

    boolean isColInBounds(int col){
        return 0 <= col && col < this.width;
    }

    boolean areAdjacent(int rowA, int colA, int rowB, int colB){
        return abs(rowA - rowB) < 2 && abs(colA - colB) < 2;
    }

    public boolean canMove(int startRow, int startCol, int endRow, int endCol){
        return  isCoordInBounds(startRow,startCol) &&
                isCoordInBounds(endRow,endCol) &&
                areAdjacent(startRow,startCol,endRow,endCol);
    }

    public int getHeight(){ return this.height; }

    public int getWidth(){
        return this.width;
    }

}
