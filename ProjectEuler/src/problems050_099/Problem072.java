/*
 * Project Euler (http://projecteuler.net) problem 72: Counting fractions
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and 
 * HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order 
 * of size, we get:
 * 
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 
 * 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * 
 * It can be seen that there are 21 elements in this set.
 * 
 * How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 */

package problems050_099;

import projecteuler.domain.Problem;
import java.util.HashSet;


public class Problem072 extends Problem {
    
    private final HashSet<Double> values;
    
    public Problem072() {
        this.values = new HashSet<>();
    }

    @Override
    public void solve() {
        for (double d = 1000000.0; d > 1.0; d--) {
            System.out.println(d);
            for (double n = (d - 1); n > 0.0; n--) {
                double fraction = n / d;
                if (!values.contains(fraction)) {
                    values.add(fraction);
                }
            }
        }
        System.out.println("Problem 072: " + values.size());
    }

}
