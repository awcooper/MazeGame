package com.adamwcooper.games.views;

import com.adamwcooper.games.models.Circle;
import com.adamwcooper.games.models.Maze;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glFlush;

public class NeonThemePrinter {

    public static void print(Circle c){
        float SQUARE_SIZE = .2f;
        glColor3f(1.0f,1.0f,1.0f);
        glBegin(GL_TRIANGLE_FAN);
        float xcord;
        float ycord;
        float xstart = c.getX() * SQUARE_SIZE - 1 + (SQUARE_SIZE / 2);
        float ystart = c.getY() * SQUARE_SIZE - 1 + (SQUARE_SIZE / 2);
        for (float i = 0; i < 360; i++){
            xcord = (float) Math.cos(Math.toRadians(i)) * c.getRadius() + xstart;
            ycord = (float) Math.sin(Math.toRadians(i)) * c.getRadius() + ystart;
            glVertex2f(xcord,ycord);
        }
        glEnd();
        glFlush();
    }

    public static void print(Maze m){
        for (int i = 0; i < m.getHeight(); i += 1){
            for (int j = 0; j < m.getWidth(); j += 1){
                if (m.getCoord(i,j)){
                    drawGridCell(i,j);
                }
            }
        }
    }

    private static void drawGridCell(int row, int col){
        float SQUARE_SIZE = .2f;
        glColor3f(0.5f,0.5f,1.0f);
        glBegin(GL_QUADS);
        float startingX = row * SQUARE_SIZE - 1;
        float startingY = col * SQUARE_SIZE - 1;
        glVertex2f(startingX,startingY);
        glVertex2f(startingX,startingY + SQUARE_SIZE);
        glVertex2f(startingX + SQUARE_SIZE,startingY + SQUARE_SIZE);
        glVertex2f(startingX + SQUARE_SIZE,startingY);
        glEnd();
        glFlush();
    }
}
