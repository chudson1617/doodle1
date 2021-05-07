
package com.doodle1;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Doodle1Main extends JFrame {
    
    Doodle1Main() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);	// width, height in pixels (required)
        setTitle("Practice");
        setLocation(50, 100);	// x and y from upper-left corner
        setLayout(new FlowLayout());
        Container jfp = getContentPane(); 
        JPanel jpn = new Doodle1Panel();
        add(jpn);
        pack();
        setVisible(true);

    }
    
}
