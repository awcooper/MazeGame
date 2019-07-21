package com.adamwcooper.games.views;

import com.adamwcooper.games.models.Circle;
import com.adamwcooper.games.models.Maze;

public interface GamePrinter<Maze> {
    void print(Circle c);
    void print(Maze m);
}
