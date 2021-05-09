/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Administrator
 */
public class Demo extends javax.swing.JDialog
{
   /**
     * Creates new form NewJDialog
     */
    public Demo(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });

        cTButton1 = new ColorToggleButton();
        cTButton1.setText("ctButton");
        cTButton1.setHandlers (() -> System.out.println("button on"),
                () -> System.out.println("button off"));
        setLayout(null);
        add(cTButton1);
        cTButton1.setLocation(30,30);
        cTButton1.setSize(70,30);
        setSize(300,300);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Demo dialog = new Demo(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ColorToggleButton cTButton1;
    // End of variables declaration//GEN-END:variables
}
