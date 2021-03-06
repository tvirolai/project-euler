/*
 * Project Euler (http://projecteuler.net) problem 45: Triangular, pentagonal, 
 * and hexagonal
 *
 * Triangle, pentagonal, and hexagonal numbers are generated by the following
 * formulae:
 * 
 * Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 * Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
 * Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 */

package problems001_049;

import java.util.ArrayList;
import projecteuler.domain.Problem;

public class Problem045 extends Problem {
    
    private final ArrayList<Long> triangle;
    private final ArrayList<Long> pentagonal;
    private final ArrayList<Long> hexagonal;
    private long index;
    
    public Problem045() {
        this.triangle = new ArrayList<>();
        this.pentagonal = new ArrayList<>();
        this.hexagonal = new ArrayList<>();
        long i;
        for (i = 1; i <= 286; i++) {
            triangle.add(generateTriangles(i));
            pentagonal.add(generatePentagonals(i));
            hexagonal.add(generateHexagonals(i));
        }
        this.index = i;
    }

    @Override
    public void solve() {
        
        while (true) {
            long triangleNumber = this.generateTriangles(this.index);
            if (this.pentagonal.contains(triangleNumber) && this.hexagonal.contains(triangleNumber)) {
                System.out.println("Problem 45: " + triangleNumber);
                break;
            } else {
                this.triangle.add(triangleNumber);
                this.pentagonal.add(generatePentagonals(this.index));
                this.hexagonal.add(generateHexagonals(this.index));
                this.index++;
            }
        }
    }
    
    private long generateTriangles(long i) {
        return i * (i + 1) / 2;
    }
    
    private long generatePentagonals(long i) {
        return i * (3 * i - 1) / 2;
    }
    
    private long generateHexagonals(long i) {      
        return i * (2 * i - 1);
    }
}
