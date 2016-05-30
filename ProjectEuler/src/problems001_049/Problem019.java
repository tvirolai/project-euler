/*
 * Project Euler (http://projecteuler.net) problem 19: Counting Sundays
 * 
 * You are given the following information, but you may prefer to do some 
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century 
 * unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century 
 * (1 Jan 1901 to 31 Dec 2000)?
 */

package problems001_049;

import java.util.Calendar;
import java.util.GregorianCalendar;
import projecteuler.domain.Problem;

public class Problem019 extends Problem {

    @Override
    public void solve() {
        int sundayCount = 0;
        Calendar calendar = new GregorianCalendar(1901,0,1);
        while (true) {
            if (calendar.get(Calendar.YEAR) == 2001) {
                System.out.println("Problem 19: " + sundayCount);
                break;
            }
            if (isSunday(calendar) && isFirstOfTheMonth(calendar)) {
                sundayCount++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
    
    private boolean isSunday(Calendar calendar) {
        return 1 == calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    private boolean isFirstOfTheMonth(Calendar calendar) {
        return 1 == calendar.get(Calendar.DAY_OF_MONTH);
    }

}
