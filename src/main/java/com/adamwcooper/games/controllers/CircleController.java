package com.adamwcooper.games.controllers;


import com.adamwcooper.games.views.shapes.Circle;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;

public class CircleController {
    private static final float MOVEMENT_DELTA = .2f;
    private static final int WINDOW_WIDTH = 1;

    public static void addCircleEventListener(Long win, Circle c){
        glfwSetKeyCallback(win, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            if( key == GLFW_KEY_RIGHT){
                if (isXInBounds(c,MOVEMENT_DELTA)) {
                    c.incrementX(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_LEFT){
                if (isXInBounds(c,-MOVEMENT_DELTA)) {
                    c.incrementX(-MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_UP){
                if (isYInBounds(c,MOVEMENT_DELTA)) {
                    c.incrementY(MOVEMENT_DELTA);
                }
            }
            if( key == GLFW_KEY_DOWN){
                if (isYInBounds(c,-MOVEMENT_DELTA)) {
                    c.incrementY(-MOVEMENT_DELTA);
                }
            }
        });
    }

    private static boolean isXInBounds(Circle c, float delta){
        return -WINDOW_WIDTH + c.getRadius() <= c.getX() + delta && c.getX() + delta <= WINDOW_WIDTH - c.getRadius();
    }

    private static boolean isYInBounds(Circle c, float delta){
        return -WINDOW_WIDTH + c.getRadius()<= c.getY() + delta && c.getY() + delta <= WINDOW_WIDTH - c.getRadius();
    }
}

