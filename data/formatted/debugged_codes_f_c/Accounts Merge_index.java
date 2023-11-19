Bug Type: Array Index Out of Bounds

The bug in the provided code is in the `UnionFind` constructor where the `parent` array is initialized with size 1 instead of size `size`. This leads to an ArrayIndexOutOfBoundsException when accessing elements of `parent` array that are out of bounds.

To fix this bug, the `UnionFind` constructor should initialize the `parent` array with the correct size using the parameter `size`.

Fixed Code:
```java
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int l = accounts.size();
        UnionFind uf = new UnionFind(l);

        Map<String, Integer> emailToNameId = new HashMap<>();

        for (int i = 0; i < l; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                int currentNameId = i;
                if (emailToNameId.containsKey(email)) {
                    int oldNameId = emailToNameId.get(email);
                    // Join new and old name ids so that we can know which emails can be merged together. Emails in a single component can be merged together.
                    uf.union(currentNameId, oldNameId);
                } else {
                    emailToNameId.put(email, currentNameId);
                }
            }
        }
        // emailToNameId = {johnnybravo@mail.com=3, johnsmith@mail.com=0, john00@mail.com=1, john_newyork@mail.com=0, mary@mail.com=2}

        // Use TreeSet for alphabetical order. 
        Map<Integer, TreeSet<String>> nameIdToEmails = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int root = uf.find(i);
            nameIdToEmails.putIfAbsent(root, new TreeSet<>());
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            nameIdToEmails.get(root).addAll(emails);
        }
        // nameIdToEmails = {1=[john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], 2=[mary@mail.com], 3=[johnnybravo@mail.com]}

        List<List<String>> out = new ArrayList<>();
        for (int id : nameIdToEmails.keySet()) {
           