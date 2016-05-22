/*
 * Project Euler (http://projecteuler.net) problem 42: Coded triangle numbers
 * 
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); 
 * so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word 
 * value is a triangle number then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file 
 * containing nearly two-thousand common English words, how many are triangle 
 * words?
 */

package problems001_049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import projecteuler.domain.Problem;


public class Problem042 extends Problem {
    
    private final ArrayList<String> words;
    private final ArrayList<Double> triangleNums;
    private final String alphabet;
    
    public Problem042() {
        this.words = this.readData();
        this.alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        this.triangleNums = new ArrayList<>();
        this.triangleNums.add(1.0);
    }
    
    @Override
    public void solve() {   
        int result = (int) this.words.stream()
                .filter(z -> this.isTriangleWord(z)).count();
        System.out.println("Problem 42: " + result);
        
    }
    
    public boolean isTriangleWord(String word) {
        double value = numValue(word);
        double largestTriangleNo = this.triangleNums.get(this.triangleNums.size() - 1);
        if (largestTriangleNo < value) {
            this.generateTriangleNums(value);
        }
        return this.triangleNums.contains(value);
    }
    
    private void generateTriangleNums(double limit) {
        double largest = 1.0;
        int i = 1;
        while (largest <= limit) {
            double num = 0.5 * i * (i + 1);
            largest = num;
            if (!this.triangleNums.contains(num)) {
                this.triangleNums.add(num);
            }
            i++;
        }
    }
    
    private double numValue(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += this.alphabet.indexOf(word.charAt(i)) + 1;
        }
        return (double) sum;
    }
    
    private ArrayList<String> readData() {     
        File file = new File("./data/problem042.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(",");
                Arrays.stream(words)
                        .forEach(z -> data.add(z.replaceAll("\"", "")));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }         
        return data;
    }

}
