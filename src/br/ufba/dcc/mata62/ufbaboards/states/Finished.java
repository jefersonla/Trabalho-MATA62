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
package br.ufba.dcc.mata62.ufbaboards.states;

import br.ufba.dcc.mata62.ufbaboards.chessgame.ChessGame;

/**
 *
 * @author jeferson
 */
public class Finished implements GameState{

    public Finished(){
        ChessGame chessGame = ChessGame.getInstance();
        chessGame.disableSidebarItens();
        chessGame.stopTimer();
    }
    
    @Override
    public void startGame() {
        ChessGame chessGame = ChessGame.getInstance();
        chessGame.restartTimer();
        chessGame.setGameState(new InProgress());
    }

    @Override
    public void pauseGame() {
        throw new UnsupportedOperationException("You can't pause a game that is already finished!");
    }

    @Override
    public void continueGame() {
        throw new UnsupportedOperationException("You can't continue a game that is already finished!");
    }
    
    @Override
    public void stopGame() {
        throw new UnsupportedOperationException("You can't stop a game that is already finished!");
    }
    
}
