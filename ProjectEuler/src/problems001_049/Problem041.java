/*
 * Project Euler (http://projecteuler.net) problem 41: Pandigital prime
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */

package problems001_049;

import projecteuler.domain.Problem;

public class Problem041 extends Problem {

    @Override
    public void solve() {
        int number = 2143;
        int largest = 0;
        while (true) {
            if (super.methods.isNDigitPanDigital(number) && 
                    super.methods.isPrime(number)) {
                largest = number;
            }
            if (number > 8000000) {
                break;
            }
            number++;
        }
        System.out.println("Problem 41: " + largest);
    }

}
