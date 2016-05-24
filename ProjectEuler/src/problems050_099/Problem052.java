/*
 * Project Euler (http://projecteuler.net) problem 52: Permuted multiples
 *
 * It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
 * contain the same digits.
 */

package problems050_099;

import projecteuler.domain.CommonMethodsLibrary;
import projecteuler.domain.Problem;

public class Problem052 extends Problem {
    
    private final CommonMethodsLibrary methods;
    
    public Problem052() {
        this.methods = new CommonMethodsLibrary();
    }

    @Override
    public void solve() {
        int i = 1;
        while (true) {
            if (methods.isPermutation(i, (2 * i)) &&
                    methods.isPermutation(i, (3 * i)) && 
                    methods.isPermutation(i, (4 * i)) &&
                    methods.isPermutation(i, (5 * i)) &&
                    methods.isPermutation(i, (6 * i))) {
                System.out.println("Problem 52: " + i);
                break;
            }
            i++;
        }
    }

}
