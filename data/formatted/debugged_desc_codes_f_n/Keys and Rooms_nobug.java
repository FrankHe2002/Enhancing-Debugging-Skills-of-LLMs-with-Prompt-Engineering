```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        exploreRooms(rooms.get(0), visited, rooms);
        
        for (boolean a : visited) {
            if (!a)
                return false;
        }
        return true;
    }
    
    public void exploreRooms(List<Integer> keys, boolean[] visited, List<List<Integer>> rooms) {
        for (int key : keys) {
            if (!visited[key]) {
                visited[key] = true;
                exploreRooms(rooms.get(key), visited, rooms);
            }
        }
    }
}
```