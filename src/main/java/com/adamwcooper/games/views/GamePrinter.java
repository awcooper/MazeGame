package com.adamwcooper.games.views;

import com.adamwcooper.games.models.Circle;
import com.adamwcooper.games.models.GridMaze;

public interface GamePrinter {
    void print(Circle c);
    void print(GridMaze gridMaze);
}
