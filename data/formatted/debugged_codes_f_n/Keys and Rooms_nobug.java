```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        for (int a : rooms.get(0)) {
            if (!visited[a]) {
                bfs(a, visited, rooms.size() - 1, rooms);
            }
        }
        for (boolean a : visited) {
            if (!a) {
                return false;
            }
        }
        return true;
    }

    public void bfs(int key, boolean[] visited, int target, List<List<Integer>> rooms) {
        visited[key] = true;
        for (int a : rooms.get(key)) {
            if (!visited[a]) {
                bfs(a, visited, target, rooms);
            }
        }
    }
}
```