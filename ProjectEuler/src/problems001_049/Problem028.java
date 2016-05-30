/*
 * Project Euler (http://projecteuler.net) problem 28: Number spiral diagonals
 * number
 * 
 *  Starting with the number 1 and moving to the right in a clockwise direction 
 * a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral 
 * formed in the same way?
 */

package problems001_049;

import projecteuler.domain.Problem;

public class Problem028 extends Problem {

    @Override
    public void solve() {
        int[][] grid = initializeGrid(5);
    }
    
    private int[][] initializeGrid(int dimension) {
        int[][] grid = new int[dimension][dimension];
        int finalX = dimension / 2;
        int finalY = dimension / 2;
        int x = dimension - 1;
        int y = 0;
        int value = dimension * dimension;
        return grid;
    }

}
