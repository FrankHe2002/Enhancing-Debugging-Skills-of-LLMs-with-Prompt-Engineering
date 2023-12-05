```java
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return results;
        set.remove(beginWord);

        Map<String, List<String>> adjacency = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> explored = new HashSet<>();
            for (int s = 0; s < size; s++) {
                String current = queue.poll();
                if (!adjacency.containsKey(current)) {
                    adjacency.put(current, getAdjacents(current, set));
                }

                List<String> adjacent = adjacency.get(current);
                for (String adj : adjacent) {
                    if (adj.equals(endWord)) {
                        found = true;
                    }
                    explored.add(adj);
                    queue.offer(adj);
                }
            }

            set.removeAll(explored);
        }

        if (found)
            return dfs(beginWord, endWord, adjacency, new HashMap<>());
        else
            return results;
    }

    private List<String> getAdjacents(String word, Set<String> dict) {
        List<String> adjs = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            char temp = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                wordChars[i] = c;
                String newAdj = new String(wordChars);
                if (dict.contains(newAdj))
                    adjs.add(newAdj);
            }
            wordChars[i] = temp;
        }
        return adjs;
    }


    private List<List<String>> dfs(String src, String dest, Map<String, List<String>> adjacency, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(src))
            return memo.get(src);

        List<List<String>> paths = new ArrayList<>();
        if (src.equals(dest)) {
            paths.add(new ArrayList<>(Collections.singletonList(dest)));
            return paths;
        }

        List<String> adjacents = adjacency.get(src);
        if (adjacents == null || adjacents.isEmpty())
            return paths;

        for (String adj : adjacents) {
            List<List<String>> adjPaths = dfs(adj, dest, adjacency, memo);
            for (List<String> path : adjPaths) {
                if (path.isEmpty()) continue;
                List<String> newPath = new ArrayList<>(Collections.singletonList(src));
                newPath.addAll(path);
                paths.add(newPath);
            }
        }
        memo.put(src, paths);
        return paths;
    }
}
```