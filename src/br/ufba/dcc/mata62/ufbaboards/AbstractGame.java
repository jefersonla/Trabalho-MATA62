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
import br.ufba.dcc.mata62.ufbaboards.states.GameState;
import br.ufba.dcc.mata62.ufbaboards.gui.FramePrincipal;

/**
 *
 * @author jeferson
 */
public abstract class AbstractGame extends FramePrincipal implements IGame {
    private IGame game;
    private GameState state;
    private BoardFactory boardFactory;
    protected IPersistence persistence;
    
    public AbstractGame(){
    }
    
    public void display(){
        this.setVisible(true);
    }
}