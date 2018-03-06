/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Lucas
 */
public class Fractal extends JComponent {
    final BufferedImage image;
    final Graphics2D offscreenGraphics;

    public Fractal(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        offscreenGraphics = image.createGraphics();
    }

    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        synchronized (image) { // synchronize with the render thread
            g2.drawImage(image, 0, 0, null);
        }
    }
}
