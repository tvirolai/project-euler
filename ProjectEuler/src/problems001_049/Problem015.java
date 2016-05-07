/*
 * Project Euler (http://projecteuler.net) problem 15: Lattice paths
 * 
 * Starting in the top left corner of a 2×2 grid, and only being able to move
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 */

package problems001_049;


public class Problem015 {
    
    // Underway
    
    public void solve() {
        long[][] matrix = calculateMatrix(20);
        for (int x = 0; x < 20; x++) {
            for (int y= 0; y < 20; y++) {
                System.out.print(matrix[x][y]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public long[][] calculateMatrix(int dimensions) {
        long[][] matrix = new long[dimensions][dimensions];
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                long value = 0;
                if (x == 0 || y == 0) {
                    value = 1;
                } else if (y == 1) {
                    value = x + 1;
                } else if (x == 1) {
                    value = y + 1;
                } else {
                    value = matrix[x-1][y] + matrix[x][y-1];
                }
                matrix[x][y] = value;
            }
        }
        return matrix;
    }

}
