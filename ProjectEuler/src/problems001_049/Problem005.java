/*
 * Project Euler (http://projecteuler.net) problem 5: Smallest multiple
 * 
 * 2520 is the smallest number that can be divided by each of the numbers 
 * from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of 
 * the numbers from 1 to 20?
 */

package problems001_049;

public class Problem005 {

    public void solve() {
        int number = 2520;
        while (true) {
            if (isEvenlyDivisible(number)) {
                break;
            } else {
                number++;
            }
        }
        System.out.println("Problem 5: " + number);
        
    }
    
    public boolean isEvenlyDivisible(int number) {
        boolean returnValue = true;
        for (int i = 1; i <= 20; i++) {
            if (number % i != 0) {
                returnValue = false;
                break;
            }
        }
        return returnValue;
    }   
}
