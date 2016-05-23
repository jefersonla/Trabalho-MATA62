/*
 * The MIT License
 *
 * Copyright 2016 jeferson.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.ufba.dcc.mata62.ufbaboards.jogoxadrez;

import br.ufba.dcc.mata62.ufbaboards.AbstractGame;
import br.ufba.dcc.mata62.ufbaboards.gui.SidebarPanel;
import br.ufba.dcc.mata62.ufbaboards.gui.TwoPlayersStartPanel;
import br.ufba.dcc.mata62.ufbaboards.gui.UfbaBoardFrame;
import br.ufba.dcc.mata62.ufbaboards.persistence.SQLitePersistence;
import java.awt.CardLayout;
import java.awt.Label;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeferson
 */
public class ChessGame extends AbstractGame {
    /* Game Instance */
    private static ChessGame instance = null;
    
    /* Private attributes */
    private String player1Name;
    private String player2Name;
    
    private ChessGame(){
        /* Call super constructor */
        super();
        
        /* Create an optional persistence */
        super.persistence = new SQLitePersistence();
        
        /* Get App Panel*/
        CardLayout appPanelLayout = (CardLayout) appPanel.getLayout();
        
        /* Add a Entry Panel*/
        appPanel.add(new TwoPlayersStartPanel("ChessGame V 1.0", appPanel), "entryPanel");
        
        /* Show Entry Panel */
        appPanelLayout.show(appPanel, "entryPanel");
        
        /* Add an empty Chess Board Matrix */
        gamePanel1.addNewMatrixBoardPanel(boardFactory.getBoard("chess"));
        
        gamePanel1.addNewSidebarPanel(new SidebarPanel());
        
        setGameName("ChessGame V 1.0");
    }
    
    public String getPlayer1Name(){
        return player1Name;
    }
    
    public String getPlayer2Name(){
        return player2Name;
    }
    
    public void setPlayersName(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        
        SidebarPanel tmpSidebar = (SidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.setPlayer1Name("<html><center>" + player1Name + "</center></html>");
        tmpSidebar.setPlayer2Name("<html><center>" + player2Name + "</center></html>");
    }
    
    public void unblockInterface(String player1Name, String player2Name){
        setPlayersName(player1Name, player2Name);
        
        enableMultipleItens(new String[]{   UfbaBoardFrame.CHANGEPLAYERMENU, 
                                            UfbaBoardFrame.NEWGAMEMENU,
                                            UfbaBoardFrame.NEWSPECIALMENU,
                                            UfbaBoardFrame.RESTARTMENU,
                                            UfbaBoardFrame.STATISTICSMENU});
    }
    
    public static ChessGame getInstance(){
        if(instance == null)
            instance = new ChessGame();
        
        return instance;
    }

    @Override
    protected void gameHelpMenuAction() {
    }

    @Override
    protected void undoItemAction() {
    }

    @Override
    protected void redoItemAction() {
    }

    @Override
    protected void newGameMenuAction() {
    }

    @Override
    protected void newSpecialGameAction() {
    }

    @Override
    protected void changePlayersMenuAction() {
        JTextField player1TmpName = new JTextField(player1Name,10);
        JTextField player2TmpName = new JTextField(player2Name,10);
        JPanel changePlayersPanel = new JPanel();
        
        changePlayersPanel.add(new Label("Player 1: "));
        changePlayersPanel.add(player1TmpName);
        changePlayersPanel.add(Box.createHorizontalStrut(20));
        changePlayersPanel.add(new Label("Player 2: "));
        changePlayersPanel.add(player2TmpName);
        
        int res;
        do{
            res = JOptionPane.showConfirmDialog(this, changePlayersPanel, "Change Players Name", JOptionPane.OK_CANCEL_OPTION);
            if(res == JOptionPane.OK_OPTION &&
                (player1TmpName.getText().length() < 4 || player2TmpName.getText().length() < 4))
                JOptionPane.showMessageDialog(  this,
                                                "Player name should have, more than 4 characters",
                                                "Player Name Warning!",
                                                JOptionPane.WARNING_MESSAGE);
        } while(res == JOptionPane.OK_OPTION &&
                (player1TmpName.getText().length() < 4 || player2TmpName.getText().length() < 4));
        if(res == JOptionPane.OK_OPTION){
            setPlayersName(player1TmpName.getText(), player2TmpName.getText());
        }
    }

    @Override
    protected void statisticsMenuAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void restartGameMenuAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
