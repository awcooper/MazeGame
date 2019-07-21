package com.adamwcooper.games.controllers;


import com.adamwcooper.games.models.Circle;
import com.adamwcooper.games.models.Maze;

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
                if (isValidMove(m,c,MOVEMENT_DELTA,0)) {
                    c.incrementX(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_LEFT){
                if (isValidMove(m,c,-MOVEMENT_DELTA, 0)) {
                    c.incrementX(-MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_UP){
                if (isValidMove(m,c,0, MOVEMENT_DELTA)) {
                    c.incrementY(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_DOWN){
                if (isValidMove(m,c,0, -MOVEMENT_DELTA)) {
                    c.incrementY(-MOVEMENT_DELTA);
                }
            }
        });
    }

    private static boolean isValidMove(Maze m, Circle c, int deltaX, int deltaY){
        int x = c.getX();
        int y = c.getY();
        return m.canMove(x,y,x + deltaX, y + deltaY);
    }

}

