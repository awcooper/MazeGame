package com.adamwcooper.games.strategy;

import com.adamwcooper.games.builder.MazeBuilderStrategy;
import com.adamwcooper.games.models.GridMaze;
import com.adamwcooper.games.models.GridMazeBuilder;

public class StaircaseGridMazeStrategy implements MazeBuilderStrategy<GridMaze> {
    public GridMaze build() {
        GridMazeBuilder mb = new GridMazeBuilder();
        int height = 10;
        int width = 10;
        mb.setHeight(height);
        mb.setWidth(width);
        mb.setGridCoord(0, 0, true);
        for (int i = 1; i < height; i++) {
            mb.setGridCoord(i, i, true);
            mb.setGridCoord(i, i - 1, true);
        }
        return mb.build();
    }
}
