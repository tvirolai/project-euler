
package projecteuler.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommonMethodsLibrary {
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n > 2 && (n & 1) == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) 
                return false;
        return true;
    }
    
    public boolean isPermutation(int a, int b) {
        return intToSet(a).equals(intToSet(b));
    }
    
    public int reverseInteger(int a) {
        return Integer.parseInt(new StringBuilder("" + a).reverse().toString());
    }
    
    public int[] digitsToArray(long a) {
        String numberString = "" + a;
        int[] digitArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            digitArray[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return digitArray;      
    }
    
    public ArrayList<Integer> digitsToArrayList(long n) {
        ArrayList<Integer> digitAL = new ArrayList<>();
        int[] digitArray = this.digitsToArray(n);
        for (int i = 0; i < digitArray.length; i++) {
            digitAL.add(digitArray[i]);
        }
        return digitAL;
    }

    public long reverseLong(long a) {
        return Long.parseLong(new StringBuilder("" + a).reverse().toString());
    }
    
    public BigInteger reverseBigInt(BigInteger a) {
        return new BigInteger(new StringBuilder(a.toString()).reverse().toString());
    }
    
    public boolean isPalindromic(int a) {
        return ("" + a).equals("" + this.reverseInteger(a));
    }

    public boolean isPalindromic(long a) {
        return ("" + a).equals("" + this.reverseLong(a));
    }
    
    public boolean isPalindromic(BigInteger a) {
        return a.toString().equals("" + this.reverseBigInt(a));
    }
    
    private Set<Integer> intToSet(int i) {
        Set<Integer> set = new HashSet<>();
        String iString = "" + i;
        for (int z = 0; z < iString.length(); z++) {
            set.add(Character.getNumericValue(iString.charAt(z)));
        }
        return set;
    }
    
    public long getSumOfProperDivisors(long x) {
        return (long) getDivisors(x).stream().mapToLong(i -> (i)).sum();
    }

    public int getSumOfProperDivisors(int x) {
        return (int) getSumOfProperDivisors((long) x);
    }
    
    public ArrayList<Long> getDivisors(long x) {
        ArrayList<Long> smallFactors = new ArrayList<>();
        ArrayList<Long> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                smallFactors.add((long) i);
                factors.add((long) i);
            }
        }
        smallFactors.stream().forEach((z) -> {
            if (z > 1) {
               factors.add(x / z); 
            }
        });
       
        Collections.sort(factors);
        return factors;
    }
    
    public boolean isNDigitPanDigital(int n) {
        String nString = "" + n;
        return isNDigitPanDigital(nString);
    }

    
    public boolean isNDigitPanDigital(String n) {
        String nString = "" + n;
        String numbers = "123456789".substring(0, nString.length());
        String seen = "";
        for (int i = 0; i < nString.length(); i++) {
            String current = "" + nString.charAt(i);
            if (seen.contains(current) || !numbers.contains(current)) {
                return false;
            }
            seen += current;
        }
        return true;
    }
    
    public ArrayList<Integer> allRotationsOfANumber(int n) {
        ArrayList<Integer> rotations = new ArrayList<>();
        rotations.add(n);
        String nString = "" + n;
        if (nString.length() > 1) {
            int i = 1;
            while (i < nString.length()) {
                String first = nString.substring(i);
                String last = nString.substring(0, i);
                String rotation = nString.substring(i) + nString.substring(0, i);
                rotations.add(Integer.parseInt(rotation));
                i++;
            }
            
        }
        return rotations;
    }
    
    public long factorial(int i) {
        long result = i;
        while (i > 1) {
            result = result * --i;
        }
        return (i == 0) ? 1 : result;
    }
}
