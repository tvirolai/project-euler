/*
 * Project Euler (http://projecteuler.net) problem 40: Champernowne's constant
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value of the
 * following expression.
 * 
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 * 
 */

package problems001_049;

import projecteuler.domain.Problem;


public class Problem040 extends Problem {
    
    private final StringBuilder sb;
    private final int MAX;
    
    public Problem040() {
        this.sb = new StringBuilder();
        int i = 1;
        this.MAX = 1000000;
        while (this.sb.length() < this.MAX) {
            this.sb.append(i);
            i++;
        } 
    }
    
    @Override
    public void solve() {
        int result = 1;       
        for (int i = 1; i < MAX; i *= 10) {
            result *= getNumberByIndex(i);
        }      
        System.out.println("Problem 40: " + result);
    }
    
    private int getNumberByIndex(int i) {
        return Character.getNumericValue(this.sb.charAt(i - 1));
    }
    
}
