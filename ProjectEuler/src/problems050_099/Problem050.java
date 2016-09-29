/**
 * Project Euler (http://projecteuler.net) problem 50: Consecutive prime sum
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below 
 * one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a prime, 
 * contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most 
 * consecutive primes?
 * 
 */

package problems050_099;

import java.util.List;
import projecteuler.domain.Problem;

public class Problem050 extends Problem {

    @Override
    public void solve() {
        int limit = 1000000;
        List<Integer> primes = methods.getAllPrimes(limit);

        int result = 0;
        int totalConsecutive = 0;

        for (int i = 0; i < primes.size(); i++) {
            int sum = 0;
            int consecutiveNos = 0;
            for (int y = i; y < primes.size(); y++) {
                sum += primes.get(y);
                consecutiveNos++;
                if (sum >= limit) {
                    break;
                } else if (methods.isPrime(sum) && 
                        sum > result && 
                        consecutiveNos > totalConsecutive) {
                    result = sum;
                    totalConsecutive = consecutiveNos;
                }
            }
        }
        System.out.println("Problem 50: " + result);
    }

}
