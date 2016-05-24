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
package br.ufba.dcc.mata62.ufbaboards.chessgame;

import br.ufba.dcc.mata62.ufbaboards.AbstractGame;
import br.ufba.dcc.mata62.ufbaboards.gui.TwoPlayersStartPanel;
import br.ufba.dcc.mata62.ufbaboards.gui.UfbaBoardFrame;
import br.ufba.dcc.mata62.ufbaboards.persistence.SQLitePersistence;
import br.ufba.dcc.mata62.ufbaboards.states.Finished;
import br.ufba.dcc.mata62.ufbaboards.utils.GameTimer;
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
    
    /* Timer Action Listener */
    GameTimer timer;
    
    /* Attributes */
    private int numberOfGames;
    private int numberOfWins;
    private int numberOfLosts;
    private int playerTurn;
    
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
        gamePanel1.addNewMatrixBoardPanel(boardFactory.getBoard("empty"));
        
        /* Add a sidebar panel */
        gamePanel1.addNewSidebarPanel(new ChessSidebarPanel());
        
        /* Set Game Name */
        setGameName("ChessGame V 1.0");
        setSpecialGameName("New Strategic Game");
        removeGameMenu();
        
        /* Add a new timer */
        timer = new GameTimer();
        
        /* Statistics Default */
        numberOfGames = 0;
        numberOfWins = 0;
        numberOfLosts = 0;
        
        /* Player Turn */
        playerTurn = 0;
    }
    
    public void blockTurn(){
        playerTurn = 0;
    }
    
    public void changeTurn(){
        playerTurn = (playerTurn == 1) ? 2 : 1;
    }
    
    public void setTurn(int turn){
        playerTurn = turn;
    }
    
    public void stopTimer(){
        timer.pauseTimer();
    }
    
    public void startTimer(){
        timer.startTimer();
    }
    
    public void restartTimer(){
        timer.resetTimer();
    }
    
    public void increasePlayedGames(){
        numberOfGames += 1;
    }
    
    public void increaseWonGames(){
        numberOfWins += 1;
    }
    
    public void increaseLostGames(){
        numberOfLosts += 1;
    }
    
    public void setTimerButtonState(boolean state){
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.setTimerButtonState(state);
    }
    
    public void disableSidebarItens(){        
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.disableItens();
    }
    
    public void enableTimerIten(){
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.enableTimer();
        
    }
    
    public void setTimer(int sec, int min, int hour){
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.setActualTimer(sec, min, hour);
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
        
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
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
        
        state = new Finished();
    }
    
    public static ChessGame getInstance(){
        if(instance == null)
            instance = new ChessGame();
        
        return instance;
    }

    @Override
    protected void newSpecialGameAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void restartGameMenuAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    protected void undoItemAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void redoItemAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    protected void newGameMenuAction() {
        startGame();
        startTimer();
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        tmpSidebar.changePlayer1State(true);
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
        
        /* If one of the player names have less than 4 character*/
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
        
        /* If people really want change a player name, do that */
        if(res == JOptionPane.OK_OPTION){
            setPlayersName(player1TmpName.getText(), player2TmpName.getText());
        }
    }
    
    @Override
    protected void statisticsMenuAction() {
        JOptionPane.showMessageDialog(  this,
                                        "<html> "
                                            + "<h1> Game Statistics </h1>"
                                            + "<p></p>"
                                            + "<p><strong> Played Games :</strong> " + numberOfGames + " </p>"
                                            + "<p></p>"
                                            + "<p><strong> Games Won :</strong> " + numberOfWins + " </p>"
                                            + "<p></p>"
                                            + "<p><strong> Games Lost :</strong> " + numberOfLosts + " </p>"
                                            + "<p></p>"
                                            + "<p><strong> Porcentage Records :</strong> "
                                                + ((numberOfGames != 0) ? ((numberOfWins * 100) / numberOfGames) : "0") + "% </p>"
                                            + "<p></p>"
                                        + "</html>",
                                        "Statistics UFBA Boards",
                                        JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void startGame() {
        state.startGame();
        ChessSidebarPanel tmpSidebar = (ChessSidebarPanel) gamePanel1.getSidebarPanel();
        gamePanel1.addNewMatrixBoardPanel(boardFactory.getBoard("chess"));
        tmpSidebar.releaseTimerButton();
    }

    @Override
    public void pauseGame() {
        state.pauseGame();
    }

    @Override
    public void continueGame() {
        state.continueGame();
    }

    @Override
    public void stopGame() {
        state.stopGame();
    }
    
    /* Not used on this game */
    @Override
    protected void gameHelpMenuAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}