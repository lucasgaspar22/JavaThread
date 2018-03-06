/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Lucas
 */
public class FractalSquare  extends Fractal {
    public FractalSquare(int width, int height) {
        super(width, height);
    }

    public void render() throws InterruptedException {
        drawSquares(getWidth() / 2, getHeight() / 2, 100, 7);
    }

    public void drawSquares(int x, int y, int side, int size) throws InterruptedException {

        Thread.sleep(3);

        if (size > 2) {
            size--;

            synchronized (image) { // synchronize with the draw thread
                offscreenGraphics.setColor(Color.BLUE);
                offscreenGraphics.fillRect(x - side / 2, y - side / 2, side, side);
            }
            repaint();

            side = side / 2;
            x = x - side;
            y = y - side;
            drawSquares(x, y, side, size);
            drawSquares(x + side * 2, y, side, size);
            drawSquares(x, y + side * 2, side, size);
            drawSquares(x + side * 2, y + side * 2, side, size);
        }
    }
}
