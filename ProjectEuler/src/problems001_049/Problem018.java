/*
 * Project Euler (http://projecteuler.net) problem 18: Maximum path sum I
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers on 
 * the row below, the maximum total from top to bottom is 23.
 * 
 *     3
 *    7 4
 *   2 4 6
 *  8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                     75
 *                   95 64
 *                  17 47 82
 *                 18 35 87 10
 *                20 04 82 47 65
 *              19 01 23 75 03 34
 *             88 02 77 73 07 63 67
 *            99 65 04 28 06 16 70 92
 *           41 41 26 56 83 40 80 70 33
 *         41 48 72 33 47 32 37 16 94 29
 *        53 71 44 65 25 43 91 52 97 51 14
 *       70 11 33 28 77 73 17 78 39 68 17 57
 *     91 71 52 38 17 14 91 43 58 50 27 29 48
 *    63 66 04 68 89 53 67 30 73 16 69 87 40 31
 *   04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a 
 * triangle containing one-hundred rows; it cannot be solved by brute force, and
 * requires a clever method! ;o)
 */

package problems001_049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem018 {
    
    public void solve() {       
        int[][] data = readData();
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                System.out.print(data[y][x] + " ");
            }
            System.out.println("");
        }
    }
    
    private static int nextX(int y, int x, int[][] data) {
        // This method takes a point and a grid and returns an optimal x 
        // coordinate on next row by evaluating the optimal route 5 rows down.
        int optimalX = 0;
        int highestSum = 0;
        for (int Y = y; Y < y + 5; Y++) {
            for (int X = x - 1; X < x + 1; x++) {
                
            }
        }
        return optimalX;
    }
    
    private static int[][] readData() {     
        File file = new File("./data/problem018.txt");
        int[][] data = new int[15][15];
        try {
            Scanner reader = new Scanner(file);
            int lineIndex = 0;
            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(" ");
                for (int i = 0; i < line.length; i++) {
                    data[lineIndex][i] = Integer.parseInt(line[i]);
                }
                lineIndex++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }         
        return data;
    }

}
