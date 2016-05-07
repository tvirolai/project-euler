/*
 * Project Euler (http://projecteuler.net) problem 9: Special Pythagorean 
 * triplet
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, 
 * for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

package problems001_049;


public class Problem009 {
    
    public void solve() {
        outerloop:
        for (int a = 0; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                for (int c = 2; c < 1000; c++) {
                    if (isPythagoreanTriplet(a, b, c) && sumIsThousand(a, b, c)) {
                        System.out.println("Problem 9: " + (a * b * c));
                        //System.out.println("a: " + a + ", b: " + b + ", c: " + c);
                        break outerloop;
                    }
                }
            }
        }
        
    }
    
    public boolean isPythagoreanTriplet(int a, int b, int c) {
        if (a >= b || a >= c || b >= c) {
            return false;
        }
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }
    
    public boolean sumIsThousand(int a, int b, int c) {
        return a + b + c == 1000;
    }
}
