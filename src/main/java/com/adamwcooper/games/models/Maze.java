package com.adamwcooper.games.models;

public interface Maze {
    boolean getCoord(int x, int y);
    boolean canMove(int startRow, int startCol, int endRow, int endCol);
}
