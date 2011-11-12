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
 * This class contains the method for the tension visualization<br/>
 * 
 * Go game board visualizer<br/>
 * @author Jérémy Caldas<br/>
 * 
 */

public class TensionVisualization implements Visualization{

    @Override
    public int[][] execute(Board board) {
        // TODO Auto-generated method stub
        return new int[board.getSize()][board.getSize()];
    }

}
