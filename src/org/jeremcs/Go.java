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

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Go game board visualizer
 * @author Jérémy Caldas
 * 
 *
 */
public class Go {
 
    /**
     * Visualized board
     */
	public static Board board;
	
	public static void main(String[] args) {
	    //com.sun.java.swing.plaf.gtk.
	    try {
	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		board = new Board(19);
		new UiFrame(board);
	}
    
	/**
	 * Displays a 2D int grid in the console
	 * @param grid 2D int grid to display
	 */
    public static void displayGrid(int[][] grid) {
        for(int m = 0; m<grid.length; m++){
            for(int n = 0; n<grid.length; n++) {
                System.out.print(grid[m][n] + " ");
            }
            System.out.println();
        }
        
    }
}
