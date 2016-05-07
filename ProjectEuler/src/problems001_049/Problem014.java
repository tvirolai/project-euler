/*
 * Project Euler (http://projecteuler.net) problem 14: Longest Collatz sequence
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following 
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) 
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

package problems001_049;


public class Problem014 {
    
    public void solve() {
        
        int greatestLength = 0;
        long greatestLengthStartingNumber = 0;
        long number = 13;
        while (number < 1000000) {
            int length = calculateChainLength(number);
            if (length > greatestLength) {
                greatestLength = length;
                greatestLengthStartingNumber = number;
            }
            number++;
        }
        System.out.println("Problem 14: " + greatestLengthStartingNumber);
    }
    
    public int calculateChainLength(long number) {
        int length = 1;
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            length++;
        }
        return length;
    }

}
