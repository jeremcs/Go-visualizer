/*
 * 
 *  Copyright © 2011 Jérémy Caldas
 * 
 *  This file is part of go-visualizer.
 *
 *  go-visualizer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  go-visualizer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with go-visualizer.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jeremcs;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * 
 * This class is the main window.<br/>
 * 
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 */

public class UiFrame extends JFrame{

    
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UiFrame(Board b) {

	    setLayout(new BorderLayout());
        UiPanel p = new UiPanel(b);
	    add(p, BorderLayout.CENTER);
	    
	    UiControlPanel ucp = new UiControlPanel(b);
	    add(ucp, BorderLayout.NORTH);
	    setTitle("Go visualizer");
        setVisible(true);
        setSize(580, 605);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
		
	}
}
