package facebook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AccountsMerge {
    class Node {
        int id;
        int rank;

        public Node(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> parentMap = new HashMap<>();
        Map<Integer, Node> union = new HashMap<>();

        int records = accounts.size();
        for (int accInd = 0; accInd < records; accInd++) {
            union.put(accInd, new Node(accInd, 0));
            List<String> list = accounts.get(accInd);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                if (parentMap.containsKey(email)) {
                    union(accInd, parentMap.get(email), union);
                } else {
                    parentMap.putIfAbsent(email, accInd);
                }
            }
        }
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int accInd = 0; accInd < records; accInd++) {
            int parent = find(accInd, union).id;
            //System.out.println(String.format("%d->%d", accInd, parent));
            Set<String> emails = map.computeIfAbsent(parent, k -> new HashSet<>());
            List<String> list = accounts.get(accInd);
            emails.addAll(list.subList(1, list.size()));
        }


        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.addAll(entry.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(entry.getKey()).get(0));
            result.add(list);
        }

        return result;
    }

    private void union(int accInd1, int accInd2, Map<Integer, Node> union) {
        Node ac1 = find(accInd1, union);
        Node ac2 = find(accInd2, union);

        if (ac1.rank > ac2.rank) {
            union.put(ac1.id, ac2);
        } else if (ac1.rank < ac2.rank) {
            union.put(ac2.id, ac1);
        } else {
            ac1.rank++;
            union.put(ac2.id, ac1);
        }
    }

    private Node find(int accInd, Map<Integer, Node> union) {
        Node parent = union.get(accInd);
        if (accInd == parent.id) return parent;
        parent = find(parent.id, union);
        union.put(accInd, parent);
        return parent;
    }

    @Test
    public void test() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input.add(Arrays.asList("Mary", "mary@mail.com"));
        input.add(Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> expected = new ArrayList<>();

        expected.add(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"));
        expected.add(Arrays.asList("Mary", "mary@mail.com"));
        expected.add(Arrays.asList("John", "johnnybravo@mail.com"));

        assertEquals(expected, accountsMerge(input));
    }

    @Test
    public void test2() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        input.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        input.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        input.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        input.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        List<List<String>> expected = new ArrayList<>();

        expected.add(Arrays.asList("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co"));
        assertEquals(expected, accountsMerge(input));
    }

    @Test
    public void test3() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        input.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        input.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        input.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        input.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        List<List<String>> expected = new ArrayList<>();

        expected.add(Arrays.asList("David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co"));
        List<List<String>> result = accountsMerge(input);
        System.out.println(result);
        assertEquals(expected, result);
    }
}
