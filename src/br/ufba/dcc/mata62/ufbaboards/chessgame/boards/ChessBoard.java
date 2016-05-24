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
package br.ufba.dcc.mata62.ufbaboards.chessgame.boards;

import br.ufba.dcc.mata62.ufbaboards.boards.AbstractBoard;
import br.ufba.dcc.mata62.ufbaboards.boards.BoardMatrixPanel;
import br.ufba.dcc.mata62.ufbaboards.chessgame.pieces.PieceFactory;
import br.ufba.dcc.mata62.ufbaboards.pieces.AbstractPiece;

/**
 *
 * @author jeferson
 */
public class ChessBoard extends AbstractBoard{
      
    public ChessBoard() {
        super(  new BoardMatrixPanel(new String[][]{
                    {PieceFactory.ROOK  , PieceFactory.KNIGHT, PieceFactory.BISHOP, PieceFactory.QUEEN, PieceFactory.KING , PieceFactory.BISHOP, PieceFactory.KNIGHT, PieceFactory.ROOK  },
                    {PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN , PieceFactory.PAWN , PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN  },
                    {PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK , PieceFactory.BLANK },
                    {PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK , PieceFactory.BLANK },
                    {PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK , PieceFactory.BLANK },
                    {PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK , PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK, PieceFactory.BLANK , PieceFactory.BLANK },
                    {PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN , PieceFactory.PAWN , PieceFactory.PAWN  , PieceFactory.PAWN  , PieceFactory.PAWN  },
                    {PieceFactory.ROOK  , PieceFactory.KNIGHT, PieceFactory.BISHOP, PieceFactory.QUEEN, PieceFactory.KING , PieceFactory.BISHOP, PieceFactory.KNIGHT, PieceFactory.ROOK  }
                },
                new String[][]{
                    {"white", "white", "white", "white", "white", "white", "white", "white"},
                    {"white", "white", "white", "white", "white", "white", "white", "white"},
                    {"null" , "null" , "null" , "null" , "null" , "null" , "null" , "null"},
                    {"null" , "null" , "null" , "null" , "null" , "null" , "null" , "null"},
                    {"null" , "null" , "null" , "null" , "null" , "null" , "null" , "null"},
                    {"null" , "null" , "null" , "null" , "null" , "null" , "null" , "null"},
                    {"black", "black", "black", "black", "black", "black", "black", "black"},
                    {"black", "black", "black", "black", "black", "black", "black", "black"}
                }),
                new String[]{"8", "7", "6", "5", "4", "3", "2", "1"},
                new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        
        boardMatrix.addObservers(this);
    }

    @Override
    public void notifyObserver(AbstractPiece piece) {
        boardMatrix.removeHighlight();
        boardMatrix.highlightMovements(piece);
    }
    
}
