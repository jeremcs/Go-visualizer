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

/**
 * 
 * 
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 * Obviously, this class contains the Board object.
 */

public class Board {

    /**
     * Actual chars contained in the board
     */
	private char[][] board;
	
	/**
	 * Current visualization for the board. Influence by default.
	 */
	Visualization visu;
	
	public Board(int n) {
		board = new char[n][n];
		
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++) {
				board[i][j] = '+';
			}
		}
		visu = new InfluenceVisualization();
	}
	
	/**
	 * Returns the size of the board, i.e. its width.
	 * @return The size of the board, i.e. its width.
	 */
	public int getSize(){
		return board.length;
	}
	
	/**
	 * Returns the content of the place of the grid 
	 * @param i Column
	 * @param j Line
	 * @return char contained in this place
	 */
	public char get(int i, int j){
		return board[i][j];
	}
	
	/**
	 * 
	 * @param i Column
	 * @param j Line
	 * @param c char to be put in this place
	 */
	public void set(int i, int j, char c){
		board[i-1][j-1] = c;
	}
	
	/**
	 * Max power of a stone
	 * @return Max power of a stone
	 */
	public int getPowerScale()
	{
	    return 10;
	}
	
	/**
	 * Changes the current visualization
	 * @param v New visualization
	 */
	public void setVisualization(Visualization v)
	{
	    visu = v;
	}
	
	/**
	 * Executes the visualizer's function
	 * @return 2D int grid with actual power weights
	 */
	public int[][] visualize()
	{
	    return visu.execute(this);
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++) {
				res += board[i][j] + " ";
			}
			res += "\n";
		}
		return res;
	}
	
}
