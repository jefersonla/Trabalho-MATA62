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
package br.ufba.dcc.mata62.ufbaboards.utils;

import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.ChessGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author jeferson
 */
public class GameTimer implements ActionListener{
    private final Timer timer;
    private int sec;
    private int min;
    private int hour;
    
    public GameTimer(){
        /* Just for convenience */
        super();
        
        /* Create a new Timer */
        timer = new Timer(1000, this);
        
        /* Reset values */
        sec = 0;
        min = 0;
        hour = 0;
    }
    
    public void resetTimer(){
        /* Instantiate a new timer */
        timer.stop();
        
        /* Reset timer values */
        sec = 0;
        min = 0;
        hour = 0;
        ChessGame.getInstance().setTimer(sec, min, hour);
    }
    
    public void pauseTimer(){
        timer.stop();
    }
    
    public void startTimer(){
        timer.start();
    }
    
    public void increaseTimer(){
        /* Add one second */
        sec += 1;
        
        /* If have more than 60 seconds add a minute */
        if(sec >= 60){
            sec = 0;
            min += 1;
        }
        /* If have more than 60 minuts add a hour */
        if(min >= 60){
            min = 0;
            hour += 1;
        }
        
        ChessGame.getInstance().setTimer(sec, min, hour);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        increaseTimer();
    }
}
