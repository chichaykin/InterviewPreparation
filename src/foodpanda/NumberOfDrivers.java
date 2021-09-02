package foodpanda;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumberOfDrivers {
    /*
Your previous Plain Text content is preserved below:

Given an array of expected time delivery intervals consisting of start and end times needed for any foodpanda rider to deliver the food to you [[start1, end1], [start2, end2],...]
where start(i)< end(i). Find the minimum number of riders required to make every customer happy :)
i/p - [[0,30], [5,10], [15,20]]
o/p - 2

10:00 - 10:30 1
10:04 - 10:16 2
10:05 - 10:10 3
10:15 - 10:20 3
10:17 - 10:19 3
*/

    int minRiders(int[][] intervals) {
        if (intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        int size = intervals.length;
        int start[] = new int[size];
        int end[] = new int[size];
        for (int i = 0; i < size; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        //start:      0,   4,  5, 15, 17
        //end:        10, 16, 19, 20, 30
        //res:        S0, S4, S5, E10
        int drivers = 0, maxDrivers = 0;
        int s = 0, e = 0;
        while (s < size) {
            if (start[s] <= end[e]) {
                drivers++;
                s++;
            } else {
                drivers--;
                e++;
            }
            maxDrivers = Math.max(maxDrivers, drivers);
        }

        return maxDrivers;
    }


    @Test
    public void test() {
        int[][] input = {
                {0, 30},
                {17, 19},
                {15, 20},
                {5, 10},
                {4, 16}
        };
        assertEquals(3, minRiders(input));
    }

    @Test
    public void test2() {
        int[][] input = {
                {0,30}, {5,10}, {15,20},
        };
        assertEquals(2, minRiders(input));
    }

}
