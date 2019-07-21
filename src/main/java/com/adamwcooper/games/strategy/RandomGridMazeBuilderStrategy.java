package com.adamwcooper.games.strategy;

import com.adamwcooper.games.builder.MazeBuilderStrategy;
import com.adamwcooper.games.models.GridMaze;
import com.adamwcooper.games.models.GridMazeBuilder;

import java.util.Random;

public class RandomGridMazeBuilderStrategy implements MazeBuilderStrategy<GridMaze> {
    public GridMaze build(){
        GridMazeBuilder mb = new GridMazeBuilder();
        int height = 10;
        int width = 10;

        mb.setHeight(height);
        mb.setWidth(width);
        Random rand = new Random();
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                mb.setGridCoord(i, j, rand.nextBoolean());
            }
        }
        //So the user isn't standing on edge
        mb.setGridCoord(0, 0, true);
        return mb.build();
    }
}
