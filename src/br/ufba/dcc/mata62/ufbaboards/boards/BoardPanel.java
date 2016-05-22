package br.ufba.dcc.mata62.ufbaboards.boards;

import br.ufba.dcc.mata62.ufbaboards.pieces.AbstractPiece;
import java.awt.CardLayout;

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
public class BoardPanel extends javax.swing.JPanel {
    protected BoardMatrixPanel boardMatrix;
    
    /**
     * Creates new form BoardPanel
     * @param newBoardMatrixSize
     * @param newLeftRightNames
     * @param newTopBottomNames
     */
    public BoardPanel(  int newBoardMatrixSize,
                        String[] newLeftRightNames,
                        String[] newTopBottomNames) {
        
        /* Store Board Matrix */
        boardMatrix = new BoardMatrixPanel(newBoardMatrixSize);
                        
        /* Init the components */
        initComponents();
        
        /* Get all panel's layout */
        CardLayout matrixBoardLayout = (CardLayout) boardMatrixPanel.getLayout();
        CardLayout topNamesPanelLayout = (CardLayout) topNamesPanel.getLayout();
        CardLayout bottomNamesPanelLayout = (CardLayout) bottomNamesPanel.getLayout();
        CardLayout leftNamesPanelLayout = (CardLayout) leftNamesPanel.getLayout();
        CardLayout rightNamesPanelLayout = (CardLayout) rightNamesPanel.getLayout();
        
        /* Add all new panel's */
        boardMatrixPanel.add(boardMatrix, "matrixBoard");
        topNamesPanel.add(new BoardLabelsHorizontal(newTopBottomNames), "topNamesPanel");
        bottomNamesPanel.add(new BoardLabelsHorizontal(newTopBottomNames), "bottomNamesPanel");
        leftNamesPanel.add(new BoardLabelsVertical(newLeftRightNames), "leftNamesPanel");
        rightNamesPanel.add(new BoardLabelsVertical(newLeftRightNames), "rightNamesPanel");
        
        /* Show all new panel's */
        matrixBoardLayout.show(boardMatrixPanel, "matrixBoard");
        topNamesPanelLayout.show(topNamesPanel, "topNamesPanel");
        bottomNamesPanelLayout.show(bottomNamesPanel, "bottomNamesPanel");
        leftNamesPanelLayout.show(leftNamesPanel, "leftNamesPanel");
        rightNamesPanelLayout.show(rightNamesPanel, "rightNamesPanel");
    }
    
    private void populateItens(int firstIndex, AbstractPiece[][] itens){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel corner1Label = new javax.swing.JLabel();
        javax.swing.JLabel corner2Label = new javax.swing.JLabel();
        javax.swing.JLabel corner3Label = new javax.swing.JLabel();
        javax.swing.JLabel corner4Label = new javax.swing.JLabel();
        topNamesPanel = new javax.swing.JPanel();
        leftNamesPanel = new javax.swing.JPanel();
        bottomNamesPanel = new javax.swing.JPanel();
        rightNamesPanel = new javax.swing.JPanel();
        boardMatrixPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(480, 480));
        setMinimumSize(new java.awt.Dimension(480, 480));
        setName("boardPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(480, 480));

        corner1Label.setMaximumSize(new java.awt.Dimension(20, 20));
        corner1Label.setMinimumSize(new java.awt.Dimension(20, 20));
        corner1Label.setPreferredSize(new java.awt.Dimension(20, 20));

        corner2Label.setMaximumSize(new java.awt.Dimension(20, 20));
        corner2Label.setMinimumSize(new java.awt.Dimension(20, 20));
        corner2Label.setPreferredSize(new java.awt.Dimension(20, 20));

        corner3Label.setMaximumSize(new java.awt.Dimension(20, 20));
        corner3Label.setMinimumSize(new java.awt.Dimension(20, 20));
        corner3Label.setPreferredSize(new java.awt.Dimension(20, 20));

        corner4Label.setMaximumSize(new java.awt.Dimension(20, 20));
        corner4Label.setMinimumSize(new java.awt.Dimension(20, 20));
        corner4Label.setPreferredSize(new java.awt.Dimension(20, 20));

        topNamesPanel.setMaximumSize(new java.awt.Dimension(432, 20));
        topNamesPanel.setMinimumSize(new java.awt.Dimension(432, 20));
        topNamesPanel.setPreferredSize(new java.awt.Dimension(432, 20));
        topNamesPanel.setLayout(new java.awt.CardLayout());

        leftNamesPanel.setMaximumSize(new java.awt.Dimension(20, 432));
        leftNamesPanel.setMinimumSize(new java.awt.Dimension(20, 432));
        leftNamesPanel.setPreferredSize(new java.awt.Dimension(20, 432));
        leftNamesPanel.setLayout(new java.awt.CardLayout());

        bottomNamesPanel.setMaximumSize(new java.awt.Dimension(432, 20));
        bottomNamesPanel.setMinimumSize(new java.awt.Dimension(432, 20));
        bottomNamesPanel.setPreferredSize(new java.awt.Dimension(432, 20));
        bottomNamesPanel.setLayout(new java.awt.CardLayout());

        rightNamesPanel.setMaximumSize(new java.awt.Dimension(20, 432));
        rightNamesPanel.setMinimumSize(new java.awt.Dimension(20, 432));
        rightNamesPanel.setPreferredSize(new java.awt.Dimension(20, 432));
        rightNamesPanel.setLayout(new java.awt.CardLayout());

        boardMatrixPanel.setMaximumSize(new java.awt.Dimension(432, 432));
        boardMatrixPanel.setMinimumSize(new java.awt.Dimension(432, 432));
        boardMatrixPanel.setPreferredSize(new java.awt.Dimension(432, 432));
        boardMatrixPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leftNamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corner4Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(corner1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomNamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topNamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardMatrixPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(corner2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightNamesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corner3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(corner2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topNamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corner1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftNamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightNamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boardMatrixPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(corner4Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bottomNamesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corner3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("BoardPanel");
        getAccessibleContext().setAccessibleDescription("Board Panel");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardMatrixPanel;
    private javax.swing.JPanel bottomNamesPanel;
    private javax.swing.JPanel leftNamesPanel;
    private javax.swing.JPanel rightNamesPanel;
    private javax.swing.JPanel topNamesPanel;
    // End of variables declaration//GEN-END:variables
}
