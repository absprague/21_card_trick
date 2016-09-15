/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardtrick;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComponent;
/**
 *
 * @author abspr
 */
public class Board extends JComponent{
    
    private Toolkit tools = Toolkit.getDefaultToolkit();
    //private Card[][] cards = new Card[3][7];
    
    public Board(){
        JFrame board = new JFrame("21 Card Trick");
        int width = tools.getScreenSize().width - 50;
        int height = tools.getScreenSize().height - 50;
        Dimension screenSize = new Dimension(width, height);
        board.setSize(screenSize);
        board.setVisible(true);
        
    }
    
    public void addToColumn(int columnId, Card card){
        
    }
}
