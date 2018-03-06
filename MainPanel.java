/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class MainPanel extends JPanel {
    final FractalSquare square = new FractalSquare(450, 350);
    final FractalTree tree = new FractalTree(450,350);
    final FractalCircle circle = new FractalCircle(450, 350);
    final FractalCircle2 circle2 = new FractalCircle2(450, 350);
    

    public MainPanel() {
        add(tree);
        add(square);
        add(circle);
        add (circle2);
    }
    
    public static void main(String[] args) {
        MainPanel fractalPanel = new MainPanel();
        JFrame frame = new JFrame();
        frame.setSize(950,770);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fractalPanel);
        frame.setVisible(true);

        Thread squareThread = new Thread(() -> {
            try {
                fractalPanel.square.render();
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        });
        Thread treeThread = new Thread(() -> {
            try {
                fractalPanel.tree.render();
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        });
        Thread circleThread = new Thread(() -> {
            try {
                fractalPanel.circle.render();
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        });
        Thread circle2Thread = new Thread(() -> {
            try {
                fractalPanel.circle2.render();
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        });
        circleThread.start();
        circle2Thread.start();
        squareThread.start();
        treeThread.start();
    }
}
