/*
 * Project Euler (http://projecteuler.net) problem 13: Large sum
 * 
 * Work out the first ten digits of the sum of the following one-hundred 
 * 50-digit numbers.
 */

package problems001_049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Problem013 {
    
    public void solve() {       
        ArrayList<Long> data = readData();
        Long sum = 0L;
        String answer = "";
        sum = data.stream()
                .map((x) -> x)
                .reduce(sum, (accumulator, _item) -> accumulator + _item);
        answer = String.valueOf(sum).substring(0,10);
        System.out.println("Problem 13: " + answer);
    }
    
    public ArrayList<Long> readData() {     
        File file = new File("./data/problem013.txt");
        ArrayList<Long> data = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Long luku = Long.parseLong(line.substring(0,15));
                data.add(luku);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }         
        return data;
    }

}
