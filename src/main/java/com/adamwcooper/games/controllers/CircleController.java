package com.adamwcooper.games.controllers;


import com.adamwcooper.games.views.shapes.Circle;
import com.adamwcooper.games.views.shapes.Maze;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;

public class CircleController {
    private static final int MOVEMENT_DELTA = 1;
    private static Long acting  = System.currentTimeMillis();

    public static void addCircleEventListener(Long win, Circle c, Maze m){
        glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            if (System.currentTimeMillis() - acting < 150){
                return;
            }
            acting = System.currentTimeMillis();
            if( key == GLFW_KEY_RIGHT){
                if (isXInBounds(m,c,MOVEMENT_DELTA)) {
                    c.incrementX(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_LEFT){
                if (isXInBounds(m,c,-MOVEMENT_DELTA)) {
                    c.incrementX(-MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_UP){
                if (isYInBounds(m,c,MOVEMENT_DELTA)) {
                    c.incrementY(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_DOWN){
                if (isYInBounds(m,c,-MOVEMENT_DELTA)) {
                    c.incrementY(-MOVEMENT_DELTA);
                }
            }
        });
    }

    private static boolean isXInBounds(Maze m, Circle c, int delta){
        return m.getCoord(c.getY(), c.getX() + delta);
    }

    private static boolean isYInBounds(Maze m, Circle c, int delta){
        return m.getCoord(c.getY() + delta, c.getX());
    }
}

