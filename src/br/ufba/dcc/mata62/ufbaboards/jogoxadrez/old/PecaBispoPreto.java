package br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jeferson Lima
 */
public class PecaBispoPreto extends JButton {

    public PecaBispoPreto() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/resources/bispo-P.gif")));
        this.setBackground(new Color(255,255,255));
        this.setSize(50, 50);
    }

    
}
