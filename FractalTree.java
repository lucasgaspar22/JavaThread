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
public class FractalTree extends Fractal {
    
    public FractalTree(int width, int height) {
        super(width, height);
    }
    public void render() throws InterruptedException {
        drawTree(getWidth()/2, getHeight() -20,-90,9);
    }
    
    public void drawTree(int x1, int y1, double angle, int depth) throws InterruptedException {
        Thread.sleep(4);
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5.0);
        synchronized (image) { // synchronize with the draw thread
            offscreenGraphics.setColor(Color.GREEN);
            offscreenGraphics.drawLine(x1, y1, x2, y2);
        }
        repaint();
        drawTree(x2, y2, angle - 20, depth - 1);
        drawTree(x2, y2, angle + 20, depth - 1);

    }
}
