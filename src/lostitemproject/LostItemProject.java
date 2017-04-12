/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import javax.swing.*;

/**
 *
 * @author POOM
 */
public class LostItemProject {
    public static void main(String[] args) throws InterruptedException {
        JFrame jframe = new JFrame();        
        jframe.setSize(890, 590);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null); 
        while(true){
            LoginGUI loginGUI = new LoginGUI();
            jframe.add(loginGUI);
            jframe.setVisible(true);
            jframe.revalidate();
            jframe.repaint();
            while(loginGUI.isInProgress()){
                Thread.sleep(1000);
            }
            Account acc = loginGUI.getAccount();

            AddLostItemGUI addItemGUI = new AddLostItemGUI(acc);
            jframe.remove(loginGUI);
            jframe.add(addItemGUI);
            jframe.revalidate();
            jframe.repaint();       
            while(addItemGUI.isInProgress()){
                Thread.sleep(1000);
            }
            jframe.remove(addItemGUI);
            //jframe.add(new JPanel());
            //jframe.revalidate();
            //jframe.repaint();
        }
        //jframe.setLayout();
        
    }
    
}
