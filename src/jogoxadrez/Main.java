package jogoxadrez;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jogoxadrez.telas.FramePrincipal;

/**
 *
 * @author Jeferson Lima
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final FramePrincipal fp = new FramePrincipal();

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    /* Try to get the look and feel of the platform */
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    
                    /* Display the created interface */
                    fp.setVisible(true);
                    
                } catch (   ClassNotFoundException |
                            InstantiationException |
                            IllegalAccessException |
                            UnsupportedLookAndFeelException ex) {
                    System.out.println("[BUG!] - Error on change UI MANAGER!");
                }
            }
        });
    }

}
