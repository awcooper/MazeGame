package com.adamwcooper.games.builder;

public interface GameBuilder<Maze> {
    Maze buildMaze(MazeBuilderStrategy<Maze> mazeMazeBuilderStrategy);
}
