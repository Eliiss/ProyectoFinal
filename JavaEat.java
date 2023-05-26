package com.mycompany.javaeat;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JavaEat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JavaEat");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
            frame.pack();
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
    }
}
