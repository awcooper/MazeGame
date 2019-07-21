package com.adamwcooper.games.models;

import java.util.Random;
import static java.lang.Math.abs;


public class GridMaze implements Maze {
    private int height;
    private int width;
    private boolean[][] grid;

    public GridMaze(int height, int width, boolean[][] grid){
        this.width = width;
        this.height = height;
        this.grid = grid;
    }

    private boolean isRowInBounds(int row){
        return 0 <= row && row < this.height;
    }

    private boolean isColInBounds(int col){
        return 0 <= col && col < this.width;
    }

    private boolean isCoordInBounds(int row, int col){
        return isRowInBounds(row) && isColInBounds(col);
    }

    public boolean getCoord(int row, int col){
        return isCoordInBounds(row,col) && this.grid[row][col];
    }

    private boolean areAdjacent(int rowA, int colA, int rowB, int colB){
        return abs(rowA - rowB) < 2 && abs(colA - colB) < 2;
    }

    public boolean canMove(int startRow, int startCol, int endRow, int endCol){
        return  isCoordInBounds(startRow,startCol) &&
                getCoord(endRow,endCol) &&
                areAdjacent(startRow,startCol,endRow,endCol);
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

}
