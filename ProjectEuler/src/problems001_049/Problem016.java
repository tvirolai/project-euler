/*
 * Project Euler (http://projecteuler.net) problem 16: Power digit sum
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */

package problems001_049;

import java.math.BigInteger;


public class Problem016 {
    
    public void solve() {
        BigInteger result = new BigInteger("2");
        result = result.pow(1000);
        String resultString = result.toString();
        int sum = 0;
        for (int i = 0; i < resultString.length(); i++) {
            sum += Integer.parseInt("" + resultString.charAt(i));
        }
        System.out.println("Problem 16: " + sum);
    }

}
