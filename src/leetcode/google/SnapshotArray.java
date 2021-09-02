package leetcode.google;

import java.util.*;

public class SnapshotArray {
    Map<Integer, Integer> map;
    List<Map<Integer, Integer>> snaps = new ArrayList<>();

    public SnapshotArray(int length) {
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        snaps.add(new HashMap(map));
        return snaps.size() - 1;
    }

    public int get(int index, int snap_id) {
        return snaps.get(snap_id).getOrDefault(index, 0);
    }
}
