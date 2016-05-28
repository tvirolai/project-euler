/*
 * Project Euler (http://projecteuler.net) problem 24: Lexicograpic permutations
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

package problems001_049;

import java.util.ArrayList;
import java.util.Arrays;
import projecteuler.domain.Problem;

public class Problem024 extends Problem {

    @Override
    public void solve() {
        // A wack hack...
        ArrayList<String> seen = new ArrayList<>();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = 1;
        while (true) {
            if (i == 1000000) {
                System.out.println("Problem 24: " + digitsToString(digits));
                break;
            }
            seen.add(digitsToString(digits));
            digits = nextPermutation(digits);
            if (seen.contains(digitsToString(digits))) {
                break;
            }
            if (seen.size() > 10) {
                seen.remove(0);
            }
            i++;
        }
    }
    
    public void printArray(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("");
    }
    
    public String digitsToString(int[] digits) {
        String returnValue = "";
        for (int i = 0; i < digits.length - 1; i++) {
            returnValue += "" + digits[i];
        }
        return returnValue;
    }
    
    public int[] nextPermutation(int[] digits) {
        // Find "first character"
        int firstIndex = 0;
        
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                firstIndex = i;
            }
        }
        
        // Find "second character"
        int secondIndex = firstIndex;
        int diff = 9999;
        for (int i = firstIndex + 1; i < digits.length; i++) {
            int diffToFirst = digits[i] - digits[firstIndex];
            if (diffToFirst > 0 && diffToFirst < diff) {
                diff = diffToFirst;
                secondIndex = i;
            }
        }
        
        // Swap
        int temp = digits[firstIndex];
        digits[firstIndex] = digits[secondIndex];
        digits[secondIndex] = temp;
        
        // Sort after first index
        Arrays.sort(digits, firstIndex + 1, digits.length);

        return digits;
    }

}
