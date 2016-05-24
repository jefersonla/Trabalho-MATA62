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
package br.ufba.dcc.mata62.ufbaboards.chessgame.pieces;

import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.movements.ChessPieceMovementStrategy;
import br.ufba.dcc.mata62.ufbaboards.pieces.AbstractPiece;
import br.ufba.dcc.mata62.ufbaboards.pieces.PieceState;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author jeferson
 */
public class ChessPiece extends AbstractPiece {
    public static final String RESOURCE_URL = "/br/ufba/dcc/mata62/ufbaboards/chessgame/pieces/resources/";
    
    /* Indexes */
    private int x;
    private int y;
    
    /* Selected */
    boolean selected;
    
    /* State */
    private PieceState state;
    
    /* Strategy */
    private ChessPieceMovementStrategy strategy;
    
    /* Possible resources */
    protected ImageIcon pieceResource;
    
    /* Attributes */
    protected String color;
    protected String name;
    
    public ChessPiece(int x, int y, Color defaultColor){
        super(defaultColor);
        this.state = new ChessPieceDead();
        this.name = "BLANK";
        this.x = x;
        this.y = y;
    }
    
    public ChessPiece(String name, String color,
            ChessPieceMovementStrategy strategy, int x, int y, Color defaultColor){
        super(defaultColor);
        this.x = x;
        this.y = y;
        this.color = color;
        this.strategy = strategy;
        this.state = new ChessPieceAlive();
        this.pieceResource = new ImageIcon(getClass().getResource(getUrlResource(name, color)));
        setIcon(pieceResource);
    }
    
    private String getUrlResource(String name, String color){
        return RESOURCE_URL + color + "_" + name + ".png";
    }
    
    public void setState(PieceState state){
        this.state = state;
    }

    public int getXCoordinate() {
        return x;
    }

    public void setXCoordinate(int x) {
        this.x = x;
    }

    public int getYCoordinate() {
        return y;
    }

    public void setYCoordinate(int y) {
        this.y = y;
    }

    @Override
    public ChessPieceMovementStrategy getMovementStrategy() {
        return strategy;
    }
    
}
