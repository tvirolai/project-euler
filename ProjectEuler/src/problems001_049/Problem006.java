/*
 * Project Euler (http://projecteuler.net) problem 6: Sum square difference
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one 
 * hundred natural numbers and the square of the sum.
 */

package problems001_049;

import java.math.BigInteger;

public class Problem006 {

    public void solve() {
        long sumOfSquares = 0;
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += Math.pow(i, 2);
            sum += i;
        }
        long squareOfTheSum = (long) Math.pow(sum, 2);
        BigInteger res1 = BigInteger.valueOf(squareOfTheSum - sumOfSquares);
        System.out.println("Problem 6: " + res1);
    }   
}
