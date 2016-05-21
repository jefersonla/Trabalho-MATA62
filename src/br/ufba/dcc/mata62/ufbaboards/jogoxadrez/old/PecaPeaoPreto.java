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
public class PecaPeaoPreto extends JButton{

    private boolean mexeu;
    
    public PecaPeaoPreto() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/resources/peao-P.gif")));
        this.setBackground(new Color(255,255,255));
        this.setSize(50, 50);
    }

    public boolean isMexeu() {
        return mexeu;
    }

    public void setMexeu(boolean mexeu) {
        this.mexeu = mexeu;
    }

}
