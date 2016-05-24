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
package br.ufba.dcc.mata62.ufbaboards.pieces;

import br.ufba.dcc.mata62.ufbaboards.boards.Observer;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.movements.ChessPieceMovementStrategy;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author jeferson
 */
public abstract class AbstractPiece extends BoardPiece implements PieceObserved{
    
    private final ArrayList<Observer> observers;
    
    public AbstractPiece(Color defaultColor) {
        super(new Color(153, 255, 153), new Color(102, 204, 255), defaultColor);
        observers = new ArrayList<>();
        addActionListener((ActionEvent evt) -> {
            notifica((AbstractPiece)evt.getSource());
        });
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifica(AbstractPiece piece) {
        for(Observer obs : observers)
            obs.notifyObserver(piece);
    }
    
    public void setSelected() {
        setBackground(Color.GREEN);
    }
    
    public void deSelect() {
        setBackground(defaultColor);
    }
    
    public void highlightPiece(){
        setBackground(Color.GREEN);
    }
    
    public boolean isOcuped(){
        return true;
    }
    
    public abstract ChessPieceMovementStrategy getMovementStrategy();
}
