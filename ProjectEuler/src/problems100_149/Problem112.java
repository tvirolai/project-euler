/*
 * Project Euler (http://projecteuler.net) problem 112: Bouncy numbers
 *
 * Working from left-to-right if no digit is exceeded by the digit to its left
 * it is called an increasing number; for example, 134468.
 *
 * Similarly if no digit is exceeded by the digit to its right it is called a 
 * decreasing number; for example, 66420.
 * 
 * We shall call a positive integer that is neither increasing nor decreasing a 
 * "bouncy" number; for example, 155349.
 *
 * Clearly there cannot be any bouncy numbers below one-hundred, but just over 
 * half of the numbers below one-thousand (525) are bouncy. In fact, the least 
 * number for which the proportion of bouncy numbers first reaches 50% is 538.
 *
 * Surprisingly, bouncy numbers become more and more common and by the time we 
 * reach 21780 the proportion of bouncy numbers is equal to 90%.
 * 
 * Find the least number for which the proportion of bouncy numbers is exactly 
 * 99%.
 */

package problems100_149;

import java.util.ArrayList;
import projecteuler.domain.Problem;

public class Problem112 extends Problem {

    @Override
    public void solve() {
        double bouncyCount = 0.0;
        double i = 1.0;
        while (true) {
            if (isBouncy((long) i)) {
                bouncyCount++;
            }
            if (bouncyCount > 0) {
                if (bouncyCount / i * 100 >= 99.0) {
                    System.out.println("Problem 112: " + (int) i);
                    break;
                }
            }
            i++;
        }
    }
    
    private boolean isBouncy(long a) {
        if (a < 100) {
            return false;
        }
        ArrayList<Integer> digits = super.methods.digitsToArrayList(a);
        return !isRising(digits) && !isDecreasing(digits);
    }
    
    private boolean isRising(ArrayList<Integer> digits) {
        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecreasing(ArrayList<Integer> digits) {
        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) < digits.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
