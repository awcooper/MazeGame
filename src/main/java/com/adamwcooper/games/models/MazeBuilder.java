package com.adamwcooper.games.models;

public interface MazeBuilder<Maze> {
    Maze build();
    void setHeight(int height);
    void setWidth(int width);
}
