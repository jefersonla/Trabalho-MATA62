package jogoxadrez;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        FramePrincipal fp = new FramePrincipal();
        fp.setVisible(true);
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("[BUG!] - Error on change UI MANAGER!");
        }
    }

}
