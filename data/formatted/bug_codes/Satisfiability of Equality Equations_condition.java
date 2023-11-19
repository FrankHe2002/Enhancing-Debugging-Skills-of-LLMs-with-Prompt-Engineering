class Solution {
    static int par[];

    public static int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }
        for (String s : equations) {
            int c1 = s.charAt(0) - 'a';
            int c2 = s.charAt(3) - 'a';
            char sign = s.charAt(1);

            int p1 = findPar(c1);
            int p2 = findPar(c2);

            if (sign == '=') {
                if (p1 != p2) {
                    if (p1 < p2) {
                        par[p2] = p1;
                    } else {
                        par[p1] = p2;
                    }
                }
            }
        }
        for (String s : equations) {
            int c1 = s.charAt(0) - 'a';
            int c2 = s.charAt(3) - 'a';
            char sign = s.charAt(1);

            int p1 = findPar(c1);
            int p2 = findPar(c2);

            if (sign == '!') {
                if (p1 == p2) {
                    return false;
                }
            }
        }
        return true;
    }
}