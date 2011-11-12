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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
/**
 * This class is the main panel where the board is drawn.<br/>
 * 
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 * 
 */


public class UiPanel extends JPanel{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    int placeWidth;
    Board b;
	
	
	public UiPanel(final Board b) {
	    this.b = b;
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton() + "(" + e.getX() + "," + e.getY() + ")");
				
				if(e.getButton() == 1)
				{
					b.set((e.getX()/placeWidth + 1), (e.getY()/placeWidth + 1), 'x');
				}
				else if(e.getButton() == 2)
				{
					b.set((e.getX()/placeWidth + 1), (e.getY()/placeWidth + 1), '+');
				}
				else if(e.getButton() == 3)
				{
					b.set((e.getX()/placeWidth + 1), (e.getY()/placeWidth + 1), 'o');
				}
				repaint();
				
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		placeWidth = Math.min(getHeight()/b.getSize(), getWidth()/b.getSize());
		System.out.println("PlaceWidth = " + placeWidth);

        //int offsetX = (getWidth()/placeWidth*b.getSize())/2;
        //int offsetY = (getHeight()/placeWidth*b.getSize())/2;
		
        Color backgroundColor = new Color(40,40,40);
        //Color backgroundColor = new Color(233,194,166);
        Color woodColor = new Color(233,194,166);
        Color linesColor = Color.GRAY;
        
		setBackground(backgroundColor);
		g.setColor(Color.BLACK);
		int[][] influence = b.visualize();
		
		for(int m = 0; m<b.getSize(); m++){
			for(int n = 0; n<b.getSize(); n++) {
				
				
				if(influence[m][n] == 0){
					g.setColor(woodColor);
					
				}
				else if(influence[m][n] > 0){
					g.setColor(Color.BLUE);

					g.setColor(new Color(0, 0, Math.abs((float)influence[m][n])/(b.getPowerScale())));
					
				}
				else{
					g.setColor(Color.RED);

					//System.out.println("Coucou(" + m + "," + n + ")" + ((float)influence[m][n])/(b.getPowerScale()));
					//g.setColor(new Color(Math.abs(((float)influence[m][n])/(b.getPowerScale())), (float) (.5*Math.abs(((float)influence[m][n])/(b.getPowerScale()))),0));
					g.setColor(new Color(0, Math.abs(((float)influence[m][n])/(b.getPowerScale())),0));
					
				}
				g.fillRect(placeWidth*m, placeWidth*n, placeWidth, placeWidth);
				
				// Dessin des lignes du Goban
				
				g.setColor(linesColor);
				g.drawLine(placeWidth*m, placeWidth*n + placeWidth/2, placeWidth*(m+1), placeWidth*n + placeWidth/2);
				g.drawLine(placeWidth*m + placeWidth/2, placeWidth*n, placeWidth*m + placeWidth/2, placeWidth*(n+1));
				
				//Dessin des pions
				
				if(Go.board.get(m, n) == 'o')
				{
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(placeWidth*m, placeWidth*n, placeWidth - 1, placeWidth - 1);
					g.setColor(new Color(0,0,255));
					g.fillOval(placeWidth*m+2*placeWidth/5, placeWidth*n+2*placeWidth/5, placeWidth/5 - 1, placeWidth/5 - 1);
					g.setColor(Color.DARK_GRAY);
					g.drawOval(placeWidth*m, placeWidth*n, placeWidth - 1, placeWidth - 1);
				}
				else if(Go.board.get(m, n) == 'x')
				{
					g.setColor(Color.DARK_GRAY);
					g.fillOval(placeWidth*m, placeWidth*n, placeWidth - 1, placeWidth - 1);
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(placeWidth*m, placeWidth*n, placeWidth - 1, placeWidth - 1);
				}
			}
		}
	}
}
