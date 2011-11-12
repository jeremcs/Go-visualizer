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
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 * This class contains the method for the influence visualization
 */

public class InfluenceVisualization implements Visualization{

    @Override
    public int[][] execute(Board board) {
        
        int[][] result = new int[board.getSize()][board.getSize()]; 
        
        for(int i = 0; i<board.getSize(); i++){
            for(int j = 0; j<board.getSize(); j++) {
                switch(board.get(i, j)) {
                case 'o' :
                    add_influence(board.getPowerScale(), result, i, j);
                    break;
                case 'x' :
                    sub_influence(board.getPowerScale(), result, i, j);
                default :
                    break;                  
                }
            }
        }
        return result;
        
    }
    
    /**
     * Adds power for white stones.
     * @param power Max power
     * @param grid Returned grid with weight values
     * @param i Column where White plays
     * @param j Line where White plays
     */
    public void add_influence(int power, int[][] grid, int i, int j){
        for(int m = -power; m<=power; m++){
            for(int n = -power; n<=power; n++) {
                if(Math.abs(m)+Math.abs(n) <= power
                        && i+m >= 0 && i+m < grid.length
                        && j+n >= 0 && j+n < grid.length){
                    grid[i+m][j+n] += power + 1 - (Math.abs(m)+Math.abs(n));
                    if(grid[i+m][j+n] > power)
                        grid[i+m][j+n] = power;
                }
            }
        }
    }
    
    /**
     * Adds power for black stones.
     * @param power Max power
     * @param grid Returned grid with weight values
     * @param i Column where Black plays
     * @param j Line where Black plays
     */
    public void sub_influence(int power, int[][] grid, int i, int j){
        for(int m = -power; m<=power; m++){
            for(int n = -power; n<=power; n++) {
                if(Math.abs(m)+Math.abs(n) <= power
                        && i+m >= 0 && i+m < grid.length
                        && j+n >= 0 && j+n < grid.length){
                    grid[i+m][j+n] -= power + 1 - (Math.abs(m)+Math.abs(n));
                    if(grid[i+m][j+n] < -power)
                        grid[i+m][j+n] = -power;
                }
            }
        }
    }

}
