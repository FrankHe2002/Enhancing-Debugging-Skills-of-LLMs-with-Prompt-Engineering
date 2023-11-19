class Solution {
    class Node {
        Map<List<String>, Integer> mem = new HashMap<>();

        void update(List<String> cur, int cnt) {
            Collections.sort(cur);
            mem.put(cur, mem.getOrDefault(cur, 0) + cnt);
        }

        Node add(Node cur) {
            Node ans = new Node();
            for (List<String> key1 : mem.keySet()) {
                ans.update(key1, mem.get(key1));
            }
            for (List<String> key2 : cur.mem.keySet()) {
                ans.update(key2, cur.mem.get(key2));
            }
            return ans;
        }

        Node sub(Node cur) {
            Node ans = new Node();
            for (List<String> key1 : mem.keySet()) {
                ans.update(key1, mem.get(key1));
            }
            for (List<String> key2 : cur.mem.keySet()) {
                ans.update(key2, - cur.mem.get(key2));
            }
            return ans;
        }

        Node mul(Node cur) {
            Node ans = new Node();
            for (List<String> key1 : mem.keySet()) {
                for (List<String> key2 : cur.mem.keySet()) {
                    List<String> next = new ArrayList<>();
                    next.addAll(key1);
                    next.addAll(key2);
                    ans.update(next, mem.get(key1) * cur.mem.get(key2));
                }
            }
            return ans;
        }

        Node evaluate(Map<String, Integer> vars) {
            Node ans = new Node();
            for (List<String> cur : mem.keySet()) {
                int cnt = mem.get(cur);
                List<String> free = new ArrayList<>();
                for (String tmp : cur) {
                    if (vars.containsKey(tmp)) {
                        cnt = cnt * vars.get(tmp);
                    } else {
                        free.add(tmp);
                    }
                }
                ans.update(free, cnt);
            }

            return ans;
        }

        List<String> toList() {
            List<String> ans = new ArrayList<>();
            List<List<String>> keys = new ArrayList<>(mem.keySet());
            Collections.sort(keys, (a, b) -> {
                if (a.size() != b.size()) {
                    return b.size() - a.size();
                }
                for (int i = 0; i < a.size(); i++) {
                    if (! a.get(i).equals(b.get(i))) {
                        return a.get(i).compareTo(b.get(i));
                    }
                }
                return 0;