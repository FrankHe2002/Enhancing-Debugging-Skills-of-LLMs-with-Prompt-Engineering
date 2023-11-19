class LockingTree {
    int[] p;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, List<Integer>> children = new HashMap<>();

    public LockingTree(int[] parent) {
        p = parent;
        for (int i = 0; i < p.length; i++) {
            children.put(i, new ArrayList<>());
        }
        for (int i = 1; i < p.length; i++) {
            children.get(p[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (! map.containsKey(num)) {
            map.put(num, user);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (map.containsKey(num) && map.get(num) == user) {
            map.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (map.containsKey(num)) return false;
        int ori = num;
        while (p[num] != - 1) {
            if (map.get(p[num]) != null) return false;
            num = p[num];
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> child = children.get(ori);
        if (child != null) {
            for (int c : child) q.offer(c);
        }
        boolean lock = false;
        while (! q.isEmpty()) {
            int cur = q.poll();
            if (map.get(cur) != null) {
                lock = true;
                map.remove(cur);
            }
            List<Integer> cc = children.get(cur);
            if (cc != null) {
                for (int c : cc) q.offer(c);
            }
        }
        if (! lock) return false;
        map.put(ori, user);
        return true;
    }
}