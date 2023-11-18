class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            if(citations[res]>=n-i)
            {
                return n-i;
            }
        }
        return res;
    }
}
