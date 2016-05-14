/*
 * Project Euler (http://projecteuler.net) problem 22: Names scores
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a
 * name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which 
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */

package problems001_049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Problem022 {
    
    private final ArrayList<String> names;
    private final String alphabet;
    
    public Problem022() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.names = new ArrayList<>();
        File file = new File("./data/problem022.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                for (String data1 : data) {
                    this.names.add(data1.replaceAll("\"", ""));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        Collections.sort(this.names, String.CASE_INSENSITIVE_ORDER);
    }
    
    public void solve() {
        int solution = 0;
        for (int i = 0; i < this.names.size(); i++) {
            solution += (this.nameValue(this.names.get(i)) * (i + 1));
        }
        System.out.println("Problem 22: " + solution);
    }
    
    private int nameValue(String name) {
        int value = 0;
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            for (int z = 0; z < this.alphabet.length(); z++) {
                if (this.alphabet.charAt(z) == character) {
                    value += z + 1;
                }
            }
        }
        return value;
    }

}
