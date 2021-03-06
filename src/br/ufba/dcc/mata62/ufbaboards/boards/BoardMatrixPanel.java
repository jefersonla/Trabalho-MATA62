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
package br.ufba.dcc.mata62.ufbaboards.boards;

import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.BlankPiece;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.ChessPiece;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.ChessPieceAlive;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.PieceFactory;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.movements.ChessPieceMovementStrategy;
import br.ufba.dcc.mata62.ufbaboards.pieces.AbstractPiece;
import br.ufba.dcc.mata62.ufbaboards.utils.CoordinatesMovement;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;

/**
 *
 * @author jeferson
 */
public class BoardMatrixPanel extends javax.swing.JPanel {
    protected AbstractPiece[][] piecesMatrix;
    protected boolean whiteLocations[][];
    protected boolean blackLocations[][];
            
    protected int tam;
    
    public void removePiece(AbstractPiece newPiece, AbstractPiece piece, int x, int y){
        int pieceIndex = (8 * y) + x; 
        
        piecesMatrix[y][x] = newPiece;
        piecesMatrix[y][x].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        piecesMatrix[y][x].setPreferredSize(new Dimension(54, 54));
        this.add(piecesMatrix[y][x], pieceIndex);
        this.remove(piece);
    }
    public void addPiece(AbstractPiece lastPiece, AbstractPiece newPiece, int x, int y){
        int pieceIndex = (8 * y) + x;
        
        piecesMatrix[y][x] = newPiece;
        
        ChessPiece aff = (ChessPiece) newPiece;
        
        if((x % 2) == (y % 2))
            aff.setBackColor(new Color(51, 102, 255));
        else
            aff.setBackColor(new Color(204, 204, 255));
                
        this.add(piecesMatrix[y][x], pieceIndex);
        this.remove(lastPiece);
    }
    
    /**
     * Creates new form BoardPanel
     * @param size
     */
    public BoardMatrixPanel(int size) { 
        initComponents();
        
        this.tam = size;
        
        /* Create matrix of pieces */
        piecesMatrix = new AbstractPiece[size][size];
        
        int pieceSide = 432 / size; 
        Dimension pieceDimension = new Dimension(pieceSide, pieceSide);
        
        /* Populate Panel */
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++){                
                /* Select Heavy Blue Pieces */
                if((i % 2) == (j % 2)){   
                    piecesMatrix[i][j] = new BlankPiece(j, i, new Color(51, 102, 255));
                    piecesMatrix[i][j].setBackground(new Color(51, 102, 255));
                }
                /* Select Light Blue Pieces */
                else{
                    piecesMatrix[i][j] = new BlankPiece(j, i, new Color(204, 204, 255));
                    piecesMatrix[i][j].setBackground(new Color(204, 204, 255));
                }
                    
                /* Define black thin border */
                piecesMatrix[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                piecesMatrix[i][j].setPreferredSize(pieceDimension);
                
                /* Add the piece to the panel */
                add(piecesMatrix[i][j]);
            }
    }

    public BoardMatrixPanel(String[][] matrix, String[][] colorPieces){
        initComponents();
        
        this.tam = 8;
        
        /* Create matrix of pieces */
        int size = 8;
        piecesMatrix = new AbstractPiece[size][size];
        whiteLocations = new boolean[size][size];
        blackLocations = new boolean[size][size];
        
        int pieceSide = 54; 
        Dimension pieceDimension = new Dimension(pieceSide, pieceSide);
        
        /* Populate Panel */
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++){
                
                /* Initialize locations */
                whiteLocations[i][j] = false;
                blackLocations[i][j] = false;
                
                /* Start Piece */
                if(colorPieces[i][j].equals("black"))
                    blackLocations[i][j] = true;
                else if(colorPieces[i][j].equals("white"))
                    whiteLocations[i][j] = true;
                    
                /* Select Heavy Blue Pieces */
                if((i % 2) == (j % 2)){
                    piecesMatrix[i][j] = PieceFactory.getNewPiece(  matrix[i][j],
                                                colorPieces[i][j], j, i,
                                                new Color(51, 102, 255));
                    piecesMatrix[i][j].setBackground(new Color(51, 102, 255));
                }
                /* Select Light Blue Pieces */
                else{
                    piecesMatrix[i][j] = PieceFactory.getNewPiece(  matrix[i][j],
                                                                    colorPieces[i][j], j, i,
                                                                    new Color(204, 204, 255));
                    piecesMatrix[i][j].setBackground(new Color(204, 204, 255));
                }
                /* Define black thin border */
                piecesMatrix[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                piecesMatrix[i][j].setPreferredSize(pieceDimension);
                
                /* Add the piece to the panel */
                add(piecesMatrix[i][j]);
            }
    }

    public BoardMatrixPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addObservers(AbstractBoard board){
        for(int i = 0; i < tam; i++)
            for(int j = 0; j < tam; j++){
                piecesMatrix[i][j].addObserver(board);
            }
    }
    
    public void highlightMovements(AbstractPiece piece){
        ChessPieceMovementStrategy movementStrategy = piece.getMovementStrategy();
        ArrayList<CoordinatesMovement> possibleMovements = movementStrategy.getPossibleMovements();
        ChessPiece myPiece = (ChessPiece) piece;
        int actualX = myPiece.getXCoordinate();
        int actualY = myPiece.getYCoordinate();
        
        for(CoordinatesMovement possibleMovement : possibleMovements){
            int wantedX = possibleMovement.getX();
            int wantedY = possibleMovement.getY();
            
            if(possibleMovement.isX_inf() && possibleMovement.isY_inf()){
                while(((actualX + wantedX >= 0) && (actualX + wantedX < tam)) &&
                    ((actualY + wantedY >= 0) && (actualY + wantedY < tam)) &&
                    piecesMatrix[actualY + wantedY][actualX + wantedX].canMoveTo()){
                    piecesMatrix[actualY + wantedY][actualX + wantedX].highlightPiece();
                    wantedX += 1;
                    wantedY += 1;
                }
            }
            if(possibleMovement.isX_inf()){
                while(((actualX + wantedX >= 0) && (actualX + wantedX < tam)) &&
                    ((actualY + wantedY >= 0) && (actualY + wantedY < tam)) &&
                    piecesMatrix[actualY + wantedY][actualX + wantedX].canMoveTo()){
                    piecesMatrix[actualY + wantedY][actualX + wantedX].highlightPiece();
                    wantedX += 1;
                }
            }
            if(possibleMovement.isY_inf()){
                while(((actualX + wantedX >= 0) && (actualX + wantedX < tam)) &&
                    ((actualY + wantedY >= 0) && (actualY + wantedY < tam)) &&
                    piecesMatrix[actualY + wantedY][actualX + wantedX].canMoveTo()){
                    piecesMatrix[actualY + wantedY][actualX + wantedX].highlightPiece();
                    wantedY += 1;
                }
            }
            else{    
                if( ((actualX + wantedX >= 0) && (actualX + wantedX < tam)) &&
                    ((actualY + wantedY >= 0) && (actualY + wantedY < tam)) &&
                    piecesMatrix[actualY + wantedY][actualX + wantedX].canMoveTo()) 
                    piecesMatrix[actualY + wantedY][actualX + wantedX].highlightPiece();   
            }
        } 
    }
    
    public void removeHighlight(){
        for(int i = 0; i < tam; i++)
            for(int j = 0; j < tam; j++){
                piecesMatrix[i][j].deSelect();
            }            
    }
    
    public void moveWhitePiece(int lastX, int lastY, int newX, int newY){
        whiteLocations[lastX][lastY]    = false;
        whiteLocations[newX][newY]      = true;
    }
    
    public void moveBlackPiece(int lastX, int lastY, int newX, int newY){
        blackLocations[lastX][lastY]    = false;
        blackLocations[newX][newY]      = true;
    }
    
    public void changeTurn(String turn){
        if(turn.equals("white")){
            for(int i = 0; i < tam; i++)
                for(int j = 0; j < tam; j++){
                    if(blackLocations[i][j])
                        piecesMatrix[i][j].turnAlly();
                    if(whiteLocations[i][j])
                        piecesMatrix[i][j].turnOpponent();
                }
        }
        else{
            for(int i = 0; i < tam; i++)
                for(int j = 0; j < tam; j++){
                    if(whiteLocations[i][j])
                        piecesMatrix[i][j].turnAlly();
                    if(blackLocations[i][j])
                        piecesMatrix[i][j].turnOpponent();
                }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(432, 432));
        setMinimumSize(new java.awt.Dimension(432, 432));
        setName("boardGamePanel"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        getAccessibleContext().setAccessibleName("Board Game Panel");
        getAccessibleContext().setAccessibleDescription("Board Game Panel");
    }// </editor-fold>//GEN-END:initComponents

    public void turnAlive(int actualX, int actualY) {
        piecesMatrix[actualX][actualY].setState(new ChessPieceAlive());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
