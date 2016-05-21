package br.ufba.dcc.mata62.ufbaboards.jogoxadrez.modelos.pecas;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jeferson Lima
 * @version 1.0
 */
public class PecaBispoBranco extends JButton {

    public PecaBispoBranco() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/resources/bispo-B.gif")));
        this.setBackground(new Color(255, 255, 255));
        this.setSize(50, 50);
    }
}
