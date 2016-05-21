package br.ufba.dcc.mata62.ufbaboards;

import br.ufba.dcc.mata62.ufbaboards.gui.FramePrincipal;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Jeferson Lima
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final AbstractGame chess_game = ChessGame.getInstance();

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    /* Try to get the look and feel of the platform */
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    
                    /* Display the created interface */
                    chess_game.display();
                    
                } catch (   ClassNotFoundException |
                            InstantiationException |
                            IllegalAccessException |
                            UnsupportedLookAndFeelException ex) {
                    System.out.println("[BUG!] - Error on change UI MANAGER!");
                    System.out.println(ex.toString());
                }
            }
        });
    }

}
