package meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Sides{
    int a;
    int b;
    int c;
    Sides(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class CountingTriangles {

    int countDistinctTriangles(ArrayList<Sides> arr) {
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder(3);
        int[] sides = new int[3];
        for (Sides side : arr) {
            sides[0] = side.a; sides[1] = side.b; sides[2] = side.c;
            Arrays.sort(sides);
            builder.append(sides[0]).append(sides[1]).append(sides[2]);
            String triangle = builder.toString();
            set.add(triangle);
            builder.setLength(0);
        }
        return set.size();
    }
}
