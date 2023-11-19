class Solution {
    public String pushDominoes(String dominoes) {
        final int N = dominoes.length();
        if (N <= 1) return dominoes;
        char[] res = dominoes.toCharArray();
        int i = 0;
        while (i < N) {
            if (res[i] == '.') {
                i++;
            } else if (res[i] == 'L') {
                int j = i-1;
                while (j >= 0 && res[j] == '.') {
                    res[j--] = 'L';
                }
                i++;
            } else {
                int j = i+1;
                while (j < N && res[j] == '.') {
                    j++;
                }
                if (j < N && res[j] == 'L') {
                    for (int l = i+1, r = j-1; l < r; l++, r--) {
                        res[l] = 'R';
                        res[r] = 'L';
                    }
                    i = j + 1;
                } else {
                    while (i < j) {
                        res[i++] = 'R';
                    }
                }
            }
        }
        return String.valueOf(res);
    }
}