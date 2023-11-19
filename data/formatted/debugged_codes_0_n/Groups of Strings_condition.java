import java.util.*;

class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        Arrays.fill(ranks, 1);

        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val += (1 << (words[i].charAt(j) - 'a'));
            }
            masks[i] = val;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (seen.contains(masks[i])) continue;
            for (int j = i + 1; j < n; j++) {
                if (words[i].length() + 1 < words[j].length()) break;
                int p1 = find(parents, i), p2 = find(parents, j);
                if (p1 == p2) continue;
                int a = masks[i], b = masks[j];
                if (a == b) merge(parents, ranks, p1, p2);
                int xor = a ^ b;
                int and = a & b;
                int xor1 = a ^ and, xor2 = b ^ and;
                if ((xor & (xor - 1)) == 0 || ((xor1 & (xor1 - 1)) == 0 && (xor2 & (xor2 - 1)) == 0)) {
                    merge(parents, ranks, p1, p2);
                }
            }
            seen.add(masks[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = find(parents, i);
            map.put(f, map.getOrDefault(f, 0) + 1);
        }

        int max = 1;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        return new int[] {map.size(), max};
    }
