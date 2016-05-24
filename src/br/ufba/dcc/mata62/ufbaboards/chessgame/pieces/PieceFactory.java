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

/**
 *
 * @author jeferson
 */
public class PieceFactory {
    /* Available constant pieces */
    public static final String BISHOP = "BISHOP";
    public static final String BLANK  = "BLANK";
    public static final String KING   = "KING";
    public static final String KNIGHT = "KNIGHT";
    public static final String QUEEN  = "QUEEN";
    public static final String ROOK   = "ROOK";
    public static final String PAWN   = "PAWN";
    
    private PieceFactory(){}
    
    /**
     * Return a piece of the desired type
     * @param tipo The type of the piece
     * @param color
     * @return the new piece or null if not found
     */
    public static ChessPiece getNewPiece(String tipo, String color, int x, int y){
        switch(tipo){
            case BLANK:
                return new BlankPiece(x, y);
            case BISHOP:
                return new BishopPiece(color, x, y);
            case KING:
                return new KingPiece(color, x, y);
            case KNIGHT:
                return new KnightPiece(color, x, y);
            case QUEEN:
                return new QueenPiece(color, x, y);
            case ROOK:
                return new RookPiece(color, x, y);
            case PAWN:
                return new PawnPiece(color, x, y);
        }
        
        return null;
    }
}
