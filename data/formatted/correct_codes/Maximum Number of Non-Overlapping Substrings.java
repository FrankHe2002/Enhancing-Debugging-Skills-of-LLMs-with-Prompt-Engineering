class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] R = new int[26];
        int[] L = new int[26];
        Arrays.fill(R, - 1);
        Arrays.fill(L, - 1);
        BitSet[] bit = new BitSet[26];
        Arrays.setAll(bit, o -> new BitSet());
        for (int i = 0; i < n; i++) {
            R[s.charAt(i) - 'a'] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            L[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = L[i] + 1; j < R[i] && L[i] >= 0; j++) {
                bit[i].set(s.charAt(j) - 'a');
            }
        }
        boolean go = true;
        while (go) {
            go = false;
            for (int i = 0; i < 26; i++) {
                for (int j = bit[i].nextSetBit(0); j >= 0; j = bit[i].nextSetBit(j + 1)) {
                    bit[i].or(bit[j]);
                    int l = Math.min(L[i], L[j]);
                    int r = Math.max(R[i], R[j]);
                    go |= l != L[i] || r != R[i];
                    L[i] = l;
                    R[i] = r;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (int i = 0; i < 26; i++) {
            boolean ok = L[i] >= 0 && ! seen[L[i]];
            for (int j = 0; j < 26 && ok; j++) {
                if (i != j && L[j] >= 0) {
                    ok &= ! (L[i] < L[j] && R[i] > R[j]);
                }
            }
            if (ok) {
                ans.add(s.substring(L[i], R[i] + 1));
                seen[L[i]] = true;
            }
        }
        return ans;
    }
}