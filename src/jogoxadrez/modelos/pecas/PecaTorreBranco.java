/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogoxadrez.modelos.pecas;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Pedro
 */
public class PecaTorreBranco extends JButton{

    public PecaTorreBranco() {
        this.setIcon(new ImageIcon("imagens\\torre-B.gif"));
        this.setBackground(new Color(255,255,255));
        this.setSize(50, 50);
    }

    
}
