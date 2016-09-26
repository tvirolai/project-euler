/**
 * Project Euler (http://projecteuler.net) problem 35: Circular primes
 * 
 * The number, 197, is called a circular prime because all rotations of the 
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 
 * 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */

package problems001_049;

import java.util.ArrayList;
import projecteuler.domain.Problem;

public class Problem035 extends Problem {

    @Override
    public void solve() {
        int count = 13;
        int i = 100;
        while (i < 1000000) {
            ArrayList<Integer> rotations = super.methods.allRotationsOfANumber(i);
            if (allArePrime(rotations)) {
                count++;
            }
            i++;
        }
        System.out.println("Problem 35: " + count);
    }
    
    private boolean allArePrime(ArrayList<Integer> rotations) {
        return rotations.stream().noneMatch((x) -> (!super.methods.isPrime(x)));
    }

}
