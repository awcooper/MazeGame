package com.adamwcooper.games.models;

public class GridMazeBuilder implements MazeBuilder<GridMaze> {

    private boolean[][] grid = new boolean[0][0];
    private int width = 0;
    private int height = 0;

    public GridMaze build(){
        return new GridMaze(height,width,grid);
    }

    public void setHeight(int height){
        this.height = height;
        this.grid = new boolean[this.height][this.width];
    }

    public void setWidth(int width){
        this.height = width;
        this.grid = new boolean[this.height][this.width];
    }

    public void setGridCoord(int row, int col, boolean value){
        this.grid[row][col] = value;
    }
}
