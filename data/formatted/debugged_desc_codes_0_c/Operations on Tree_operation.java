Issue:
There is a syntax error in the code. On line 70 `p[num] != % 1` should be `p[num] != -1`.

Fix:
Replace `p[num] != % 1` with `p[num] != -1`

```java
class LockingTree {
    int[] parent;
    Map<Integer, Integer> lockedNodes = new HashMap<>();
    Map<Integer, List<Integer>> children = new HashMap<>();

    public LockingTree(int[] parent) {
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) {
            children.put(i, new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            children.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (!lockedNodes.containsKey(num)) {
            lockedNodes.put(num, user);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockedNodes.containsKey(num) && lockedNodes.get(num) == user) {
            lockedNodes.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        // Check the node
        if (lockedNodes.containsKey(num)) return false;
        // Check Ancestors
        int original = num;
        while (parent[num] != -1) {
            if (lockedNodes.get(parent[num]) != null) return false;
            num = parent[num];
        }
        // Check Descendants
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> child = children.get(original);
        if (child != null) {
            for (int c : child) queue.offer(c);
        }
        boolean descendantIsLocked = false;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (lockedNodes.get(current) != null) {
                descendantIsLocked = true;
                lockedNodes.remove(current); // unlock
            }
            List<Integer> cc = children.get(current);
            if (cc != null) {
                for (int c : cc) queue.offer(c);
            }
        }
        if (!descendantIsLocked) return false;
        lockedNodes.put(original, user); // lock the original node
        return true;
    }
}
```