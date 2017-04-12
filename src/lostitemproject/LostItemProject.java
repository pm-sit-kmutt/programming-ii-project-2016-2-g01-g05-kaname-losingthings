/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import javax.swing.JFrame;

/**
 *
 * @author POOM
 */
public class LostItemProject {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(890, 590);
        jframe.add(new AddLostItemGUI());
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        //jframe.setLayout();
        
    }
    
}
