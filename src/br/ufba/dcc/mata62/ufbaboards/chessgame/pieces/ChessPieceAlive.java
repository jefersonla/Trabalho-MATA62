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

import br.ufba.dcc.mata62.ufbaboards.pieces.AbstractPiece;
import br.ufba.dcc.mata62.ufbaboards.pieces.PieceState;

/**
 *
 * @author jeferson
 */
public class ChessPieceAlive implements PieceState {

    @Override
    public void killPiece(AbstractPiece piece) {
        throw new UnsupportedOperationException("You cannot kill a non opponent piece.");
    }

    @Override
    public void turnOpponent(AbstractPiece piece) {
        piece.setState(new ChessPieceOpponent());
    }

    @Override
    public boolean canMove() {
        return true;
    }
    
    @Override
    public boolean canMoveTo(){
        return false;
    }
    
}
