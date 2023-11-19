class Solution {
    public int maxSumMinProduct(int[] a)

    int n = a.length, M = 1_000_000_007;
    long res = 0L;

    long[] psum = new long[n + 1];
        for(
    int i = 0;
    i<n;i++)psum[i+1]=psum[i]+a[i];

    int[] s = new int[n];
    int top = - 1;
        for(
    int i = 0;
    i <=n;s[++top]=i++)
            while(top >=0&&(i ==n ||a[i] <a[s[top]]))

    {
        int min = a[s[top--]];
        int l = top == - 1 ? 0 : s[top] + 1;
        int r = i - 1;
        res = Math.max(res, min * (psum[r + 1] - psum[l]));
    }

        return(int)(res %M);
}
}