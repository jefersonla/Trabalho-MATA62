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
package br.ufba.dcc.mata62.ufbaboards;

import br.ufba.dcc.mata62.ufbaboards.persistence.IPersistence;
import br.ufba.dcc.mata62.ufbaboards.boards.BoardFactory;
import br.ufba.dcc.mata62.ufbaboards.gui.UfbaBoardFrame;
import br.ufba.dcc.mata62.ufbaboards.chessgame.ChessGame;
import br.ufba.dcc.mata62.ufbaboards.old.jogoxadrez.FramePrincipal;
import br.ufba.dcc.mata62.ufbaboards.states.GameState;

/**
 *
 * @author jeferson
 */
public abstract class AbstractGame extends UfbaBoardFrame implements IGame {
    private IGame game;
    protected GameState state;
    protected BoardFactory boardFactory;
    protected IPersistence persistence;
    
    public AbstractGame(){
        state = null;
        boardFactory = new BoardFactory();
    }
        
    @Override
    public AbstractGame getGameInstance(String game){
        if(game.equals("chess"))
            return ChessGame.getInstance();
        /*else if(game.equals("chess-old"))
            return new FramePrincipal();*/
        
        return null;
    }
    
    public GameState getGameState(){
        return state;
    }
        
    public void setGameState(GameState state){
        this.state = state;
    }
    
    public void display(){
        this.setVisible(true);
    }
    
    @Override
    public void playGame(AbstractGame newGame) {
        // Falta Implementar
    }
}
