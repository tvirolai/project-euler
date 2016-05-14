/*
 * Project Euler (http://projecteuler.net) problem 17: Number letter counts
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 */

package problems001_049;

import java.util.HashMap;

public class Problem017 {
    
    private final HashMap<String, String> letters;
    
    public Problem017() {
        this.letters = new HashMap<>();
        String[] numbers = {"one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", 
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};
        for (int i = 0; i < numbers.length; i++) {
            letters.put(Integer.toString(i + 1), numbers[i]);
        }
        this.letters.put("20", "twenty");
        this.letters.put("30", "thirty");
        this.letters.put("40", "forty");
        this.letters.put("50", "fifty");
        this.letters.put("60", "sixty");
        this.letters.put("70", "seventy");
        this.letters.put("80", "eighty");
        this.letters.put("90", "ninety");
    }
    
    public void solve() {
        int letterCount = 0;
        int number = 1;
        while (number <= 1000) {
            letterCount += spellOut(number).length();
            number++;
        }
        System.out.println("Problem 17: " + letterCount);
        
    }
  
    
    public String spellOut(int number) {
        String numberAsString = Integer.toString(number);
        String spelledOut = "";
        if (number < 21) {
            spelledOut = this.letters.get(numberAsString);
        } else if (number >= 21 && number <= 99) {
            String first = numberAsString.substring(0,1);
            String second = numberAsString.substring(1,2);
            spelledOut += this.letters.get("" + first + "0");
            if (Integer.parseInt(second) > 0) {
                spelledOut += this.letters.get(second);  
            }
        } else if (number > 99 && number <= 999) {
            String first = numberAsString.substring(0,1);
            String rest = numberAsString.substring(1);
            spelledOut += this.letters.get(first);
            spelledOut += "hundred";
            int restInt = Integer.parseInt(rest);
            if (restInt > 0) {
               spelledOut += "and" + spellOut(Integer.parseInt(rest)); 
            } 
        } else if (number == 1000) {
            spelledOut = "onethousand";
        }
        return spelledOut; 
    }

}
