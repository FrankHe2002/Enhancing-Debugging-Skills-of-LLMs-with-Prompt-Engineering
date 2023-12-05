```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        for (int a : rooms.get(0)) {
            if (! visited[a]) {
                dfs(a, visited, rooms);
            }
        }
        for (boolean a : visited) {
            if (! a)
                return false;
        }
        return true;
    }

    public void dfs(int key, boolean[] visited, List<List<Integer>> rooms) {
        visited[key] = true;
        for (int a : rooms.get(key)) {
            if (!visited[a]) {
                dfs(a, visited, rooms);
            }
        }
    }
}
```