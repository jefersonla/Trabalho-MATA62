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

import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author jeferson
 */
public class BoardPieceUI extends BasicButtonUI{
    
    @Override
    public void paint ( Graphics g, JComponent c )
    {
        BoardPiece myButton = (BoardPiece) c;
        ButtonModel buttonModel = myButton.getModel ();

        if (buttonModel.isPressed()) {
            g.setColor(myButton.getPressedBackgroundColor());
        } else if (buttonModel.isRollover()) {
            g.setColor(myButton.getHoverBackgroundColor());
        } else {
            g.setColor(c.getBackground());
        }
        
        g.fillRect ( 0, 0, c.getWidth (), c.getHeight () );

        super.paint ( g, c );
    }
}
