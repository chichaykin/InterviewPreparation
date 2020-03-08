package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

class Item {
    char ch;
    int amount;
    int clock;

    public Item(char ch, int clock) {
        this.ch = ch;
        this.clock = clock;
        this.amount = 1;
    }
}

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Item[] ar = new Item[26];
        for (char ch : tasks) {
            if (ar[ch - 'A'] == null) ar[ch - 'A'] = new Item(ch, -n-1);
            else ar[ch - 'A'].amount++;
        }
        List<Item> list = new ArrayList<>(tasks.length);
        for(Item it : ar) {
            if (it != null) list.add(it);
        }

        int clock = 0;
        while (!list.isEmpty()) {
            Collections.sort(list, (it1, it2) -> it2.amount - it1.amount);
            Item it = null;
            int i = 0;
            for (; i < list.size(); i++) {
                it = list.get(i);
                if (it.clock + n + 1 <= clock) {
                    break;
                }
            }

            if (i < list.size()) {
                it.amount--;
                if (it.amount == 0) {
                    list.remove(i);
                } else {
                    it.clock = clock;
                }
                System.out.print(it.ch + " ");
            } else {
                System.out.print("idle ");
            }
            time++;
            clock++;
        }
        return time;
    }

    @Test
    public void test() {
        char[] input = {'A', 'A', 'A', 'B', 'B', 'B'};
        assertEquals(8, leastInterval(input, 2));
    }
}
