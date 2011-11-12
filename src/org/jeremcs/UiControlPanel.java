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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class contains the controls of the GUI.<br/>
 * 
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 * 
 */

public class UiControlPanel extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UiControlPanel(final Board b) {
        JButton b_influence = new JButton("Influence");
        b_influence.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                b.setVisualization(new InfluenceVisualization());
                getParent().repaint();
            }
        });
        add(b_influence);
        
        JButton b_tension = new JButton("Tension");
        b_tension.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                b.setVisualization(new TensionVisualization());
                getParent().repaint();
            }
        });
        add(b_tension);
    }

}
