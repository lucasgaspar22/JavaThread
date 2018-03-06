/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Lucas
 */
public class FractalCircle extends Fractal{

    public FractalCircle(int width, int height) {
        super(width, height);
    }
    
    public void render() throws InterruptedException {
        drawCircle(getWidth()/2,  getHeight()/2, 300);
    }
    
    public void drawCircle( float x, float y, float radius) throws InterruptedException {
       Thread.sleep(200);
        synchronized (image) { // synchronize with the draw thread
            offscreenGraphics.setColor(Color.RED);
            offscreenGraphics.draw(new Ellipse2D.Float(x-radius/2, y-radius/2, radius,radius));
        }
        repaint();
        if(radius > 2) {
            radius *= 0.75f;
            drawCircle(x, y, radius);
        } else return ;
    }
}
