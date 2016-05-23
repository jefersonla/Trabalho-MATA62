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
package br.ufba.dcc.mata62.ufbaboards.gui;

import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.ChessGame;

/**
 *
 * @author jeferson
 */
public class SidebarPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form ChessSidebarPanel
     */
    public SidebarPanel() {
        initComponents();
    }
    
    public void setActualTimer(int sec, int min, int hour){
        timerCounter.setText(String.format("%02d:%02d:%02d", hour, min, sec));
    }
    
    public void setPlayer1Name(String name){
        player1Name.setText(name);
    }
    
    public void setPlayer2Name(String name){
        player2Name.setText(name);
    }
    
    public String getPlayer1Name(){
        return player1Name.getText();
    }
    
    public String getPlayer2Name(){
        return player2Name.getText();
    }
    
    public void enablePlayersLabel(){
        player1Name.setEnabled(true);
        player2Name.setEnabled(true);
    }
    
    public void changePlayer1Turn(boolean state){
        p1PlayerTurn.setEnabled(state);
        player1Name.setEnabled(state);
    }
    
    public void changePlayer2Turn(boolean state){
        p2PlayerTurn.setEnabled(state);
        player2Name.setEnabled(state);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1PlayerTurn = new javax.swing.JLabel();
        p2PlayerTurn = new javax.swing.JLabel();
        javax.swing.JLabel player1Label = new javax.swing.JLabel();
        player1Name = new javax.swing.JLabel();
        javax.swing.JLabel player2Label = new javax.swing.JLabel();
        player2Name = new javax.swing.JLabel();
        javax.swing.JLabel timerLabel = new javax.swing.JLabel();
        changeTimerState = new javax.swing.JToggleButton();
        timerCounter = new javax.swing.JLabel();
        javax.swing.JLabel movementsLabel = new javax.swing.JLabel();
        undoMovementButton = new javax.swing.JButton();
        redoMovementButton = new javax.swing.JButton();
        movementsScrollPanel = new javax.swing.JScrollPane();
        movementsScrollList = new javax.swing.JList<String>();

        setMaximumSize(new java.awt.Dimension(168, 480));
        setMinimumSize(new java.awt.Dimension(168, 480));
        setName("sidebarPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(168, 480));
        setVerifyInputWhenFocusTarget(false);

        p1PlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1PlayerTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/p1_icon.png"))); // NOI18N
        p1PlayerTurn.setToolTipText("Player 1 Turn");
        p1PlayerTurn.setEnabled(false);

        p2PlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2PlayerTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/p2_icon.png"))); // NOI18N
        p2PlayerTurn.setToolTipText("Player 2 Turn");
        p2PlayerTurn.setEnabled(false);

        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText("Player 1");
        player1Label.setToolTipText("");
        player1Label.setEnabled(false);

        player1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Name.setText("<html><center> ... </center></html>");
        player1Name.setEnabled(false);

        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("Player 2");
        player2Label.setEnabled(false);

        player2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Name.setText("<html><center> ... </center></html>");
        player2Name.setEnabled(false);

        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("Timer");

        changeTimerState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/play_icon.png"))); // NOI18N
        changeTimerState.setEnabled(false);
        changeTimerState.setMaximumSize(new java.awt.Dimension(33, 33));
        changeTimerState.setMinimumSize(new java.awt.Dimension(33, 33));
        changeTimerState.setPreferredSize(new java.awt.Dimension(33, 33));
        changeTimerState.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/pause_icon.png"))); // NOI18N
        changeTimerState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTimerStateActionPerformed(evt);
            }
        });

        timerCounter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        timerCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerCounter.setText("00:00:00");

        movementsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movementsLabel.setText("Movements");

        undoMovementButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/undo_icon.png"))); // NOI18N
        undoMovementButton.setText("Undo");
        undoMovementButton.setEnabled(false);
        undoMovementButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        undoMovementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoMovementButtonActionPerformed(evt);
            }
        });

        redoMovementButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufba/dcc/mata62/ufbaboards/resources/redo_icon.png"))); // NOI18N
        redoMovementButton.setText("Redo");
        redoMovementButton.setEnabled(false);
        redoMovementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoMovementButtonActionPerformed(evt);
            }
        });

        movementsScrollList.setFont(new java.awt.Font("Dialog", 1, 9)); // NOI18N
        movementsScrollList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "001 00:00:00 wKing [A 3]", "002 00:01:00 bBishop [A 5]" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        movementsScrollPanel.setViewportView(movementsScrollList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(player1Name)
            .addComponent(player2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(changeTimerState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timerCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(movementsScrollPanel)
            .addComponent(movementsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(undoMovementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redoMovementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(p1PlayerTurn)
                .addGap(2, 2, 2)
                .addComponent(p2PlayerTurn))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2PlayerTurn)
                    .addComponent(p1PlayerTurn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(player1Label)
                .addGap(1, 1, 1)
                .addComponent(player1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player2Label)
                .addGap(1, 1, 1)
                .addComponent(player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timerLabel)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeTimerState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timerCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movementsLabel)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undoMovementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redoMovementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movementsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );

        p1PlayerTurn.getAccessibleContext().setAccessibleName("Player1Turn");
        p2PlayerTurn.getAccessibleContext().setAccessibleName("Player2Turn");
        player1Label.getAccessibleContext().setAccessibleName("Player1Label");
        player1Label.getAccessibleContext().setAccessibleDescription("Player 1 Label");
        player2Label.getAccessibleContext().setAccessibleName("Player2Label");
        player2Label.getAccessibleContext().setAccessibleDescription("Player 2 Label");
        timerLabel.getAccessibleContext().setAccessibleName("TimerLabel");
        timerLabel.getAccessibleContext().setAccessibleDescription("Timer Label");
        movementsLabel.getAccessibleContext().setAccessibleName("MovementsLabel");
        movementsLabel.getAccessibleContext().setAccessibleDescription("MovementsLabel");

        getAccessibleContext().setAccessibleName("SidebarPanel");
        getAccessibleContext().setAccessibleDescription("Sidebar Panel");
    }// </editor-fold>//GEN-END:initComponents

    private void undoMovementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoMovementButtonActionPerformed
        ChessGame chessGame = ChessGame.getInstance();
        
        
    }//GEN-LAST:event_undoMovementButtonActionPerformed

    private void changeTimerStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTimerStateActionPerformed
        ChessGame chessGame = ChessGame.getInstance();
        
        
    }//GEN-LAST:event_changeTimerStateActionPerformed

    private void redoMovementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoMovementButtonActionPerformed
        ChessGame chessGame = ChessGame.getInstance();
        
        
    }//GEN-LAST:event_redoMovementButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton changeTimerState;
    private javax.swing.JList<String> movementsScrollList;
    private javax.swing.JScrollPane movementsScrollPanel;
    private javax.swing.JLabel p1PlayerTurn;
    private javax.swing.JLabel p2PlayerTurn;
    private javax.swing.JLabel player1Name;
    private javax.swing.JLabel player2Name;
    private javax.swing.JButton redoMovementButton;
    private javax.swing.JLabel timerCounter;
    private javax.swing.JButton undoMovementButton;
    // End of variables declaration//GEN-END:variables
}
