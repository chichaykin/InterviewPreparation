package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneDirectory {

    Set<Integer> numbers;

//    /** Initialize your data structure here
//     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
//    public PhoneDirectory(int maxNumbers) {
//        numbers = new HashSet<>(maxNumbers);
//        for(int i=0; i < maxNumbers; i++) {
//            numbers.add(i);
//        }
//    }

    public PhoneDirectory() {
        int maxNumbers = 3;
        numbers = new HashSet<>(maxNumbers);
        for(int i=0; i < maxNumbers; i++) {
            numbers.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Iterator<Integer> it = numbers.iterator();
        if (it.hasNext()) {
            Integer value = it.next();
            numbers.remove(value);
            return value;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return numbers.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        numbers.add(number);
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) % 10);
        }
        PhoneDirectory dir =this;
        Assert.assertEquals(0, dir.get());
        Assert.assertEquals(1, dir.get());
        Assert.assertEquals(true, dir.check(2));
        Assert.assertEquals(2, dir.get());
        Assert.assertEquals(false, dir.check(2));
        dir.release(2);
        Assert.assertEquals(true, dir.check(2));
    }
}
