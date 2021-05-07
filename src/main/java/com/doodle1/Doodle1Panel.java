
package com.doodle1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class Doodle1Panel extends JPanel{
    private Point lineStart = new Point(0, 0);

    Doodle1Panel() {

        super();
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(500, 500));
        addMouseListener(new Pressed());
        addMouseMotionListener(new Dragged());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clear background 
        g.setColor(Color.blue);
        g.drawString("Left Button draws", 10, 20);
        g.drawString("Shift Drag erases", 10, 35);
        g.drawString("Double Click clears", 10, 50);
    }

    class Pressed extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            int x = e.getX(), y = e.getY();
            lineStart = new Point(x, y);
            Graphics g = getGraphics();
            if (e.isShiftDown()) {
                g.setColor(getBackground());
            } else {
                g.setColor(Color.red);
                System.out.println(g.getColor());
            }
            if (e.getClickCount() == 2) // double click 
            {
                repaint();
            } else {
                lineStart.move(x, y);
            }
        }
    }

    class Dragged extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {
            int x = e.getX(), y = e.getY();
            int size = 16;
            Graphics g = getGraphics();
            if (e.isShiftDown()) {
                g.setColor(getBackground());
                g.fillOval(x - size / 2, y - size / 2, size, size);
            } else {
                g.setColor(Color.red);
                g.drawLine(lineStart.x, lineStart.y, x, y);
            }
            lineStart.move(x, y);
        }
    }

}


