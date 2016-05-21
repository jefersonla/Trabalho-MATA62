/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Pedro
 */
public class PecaCavaloBranco extends JButton {

    public PecaCavaloBranco() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/resources/cavalo-B.gif")));
        this.setBackground(new Color(255,255,255));
        this.setSize(50, 50);
    }

    
}
