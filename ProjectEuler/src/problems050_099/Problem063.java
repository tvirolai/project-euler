/*
 * Project Euler (http://projecteuler.net) problem 63: Powerful digit counts
 *
 * The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit 
 * number, 134217728=89, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */

package problems050_099;

import projecteuler.domain.Problem;
import java.math.BigInteger;

public class Problem063 extends Problem {

    @Override
    public void solve() {      
        long solution = 0L;
        int pow = 1;
        BigInteger result = new BigInteger("" + 0);
        while (true) {
            for (long i = 1L; result.toString().length() <= i; i++) {
                BigInteger value = new BigInteger(("" + i));
                result = value.pow((int) i);
                System.out.println(value);
            }
            pow++;
        }
    }

}
