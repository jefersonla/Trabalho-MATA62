package br.ufba.dcc.mata62.ufbaboards.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

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

/**
 *
 * @author jeferson
 */
public class GamePanel extends javax.swing.JPanel {

    private JPanel actualMatrixBoardPanel;
    private JPanel actualSidebarPanel;
    
    /**
     * Creates new form UfbaBoardPanel
     */
    public GamePanel() {
        initComponents();
        
        /* Set actual matrix board panel and sidebar panel to null */
        actualMatrixBoardPanel = null;
        actualSidebarPanel = null;
    }

    /**
     * 
     * @param newMatrixBoard 
     */
    public void addNewMatrixBoardPanel(JPanel newMatrixBoard){
        /* Get board Panel Layout */
        CardLayout boardPanelLayout = (CardLayout) boardPanel.getLayout();
        
        /* Remove the last element if there's one */
        if(actualMatrixBoardPanel != null)
            boardPanel.remove(actualMatrixBoardPanel);
        
        /* Store the new matrix board */
        actualMatrixBoardPanel = newMatrixBoard;
        
        /* Add the actual Matrix Board Panel*/
        boardPanel.add(newMatrixBoard, "matrixBoard");
        
        /* Show This Matrix Board Panel */
        boardPanelLayout.show(boardPanel, "matrixBoard");
    }
    
    /**
     * 
     * @param newSidebar 
     */
    public void addNewSidebarPanel(JPanel newSidebar){
                /* Get board Panel Layout */
        CardLayout sidebarPanelLayout = (CardLayout) sidebarPanel.getLayout();
        
        /* Remove the last element if there's one */
        if(actualSidebarPanel != null)
            sidebarPanel.remove(actualSidebarPanel);
        
        /* Store the new matrix board */
        actualSidebarPanel = newSidebar;
        
        /* Add the actual Matrix Board Panel*/
        sidebarPanel.add(newSidebar, "sidebarPanel");
        
        /* Show This Matrix Board Panel */
        sidebarPanelLayout.show(sidebarPanel, "sidebarPanel");
    }
    
    public JPanel getSidebarPanel(){
        return actualSidebarPanel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boardPanel = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(660, 480));
        setMinimumSize(new java.awt.Dimension(660, 480));
        setName("appPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(660, 480));

        boardPanel.setToolTipText("");
        boardPanel.setMaximumSize(new java.awt.Dimension(480, 480));
        boardPanel.setMinimumSize(new java.awt.Dimension(480, 480));
        boardPanel.setName("boardPanel"); // NOI18N
        boardPanel.setPreferredSize(new java.awt.Dimension(480, 480));
        boardPanel.setLayout(new java.awt.CardLayout());

        sidebarPanel.setMaximumSize(new java.awt.Dimension(168, 480));
        sidebarPanel.setMinimumSize(new java.awt.Dimension(168, 480));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(168, 480));
        sidebarPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        boardPanel.getAccessibleContext().setAccessibleName("BoardPanel");
        boardPanel.getAccessibleContext().setAccessibleDescription("Board Panel");

        getAccessibleContext().setAccessibleName("UFBABoardPanel");
        getAccessibleContext().setAccessibleDescription("UFBABoard default panel");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
