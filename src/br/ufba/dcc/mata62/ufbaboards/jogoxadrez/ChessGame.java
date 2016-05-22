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
package br.ufba.dcc.mata62.ufbaboards.jogoxadrez;

import br.ufba.dcc.mata62.ufbaboards.AbstractGame;
import br.ufba.dcc.mata62.ufbaboards.gui.TwoPlayersStartPanel;
import br.ufba.dcc.mata62.ufbaboards.persistence.SQLitePersistence;
import java.awt.CardLayout;

/**
 *
 * @author jeferson
 */
public class ChessGame extends AbstractGame {
    /* Game Instance */
    private static ChessGame instance = null;
    
    /* Private attributes */
    private String player1Name;
    private String player2Name;
    
    private ChessGame(){
        super.persistence = new SQLitePersistence();
        
        /* Get App Panel*/
        CardLayout appPanelLayout = (CardLayout) appPanel.getLayout();
        
        /* Add a Entry Panel*/
        appPanel.add(new TwoPlayersStartPanel("ChessGame V 1.0", appPanel), "entryPanel");
        
        /* Show Entry Panel */
        appPanelLayout.show(appPanel, "entryPanel");
    }
    
    public void setPlayersName(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    
    public static ChessGame getInstance(){
        if(instance == null)
            instance = new ChessGame();
        
        return instance;
    }
    
    
}
