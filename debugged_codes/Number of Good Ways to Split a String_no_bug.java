class Solution {
    public int numSplits(String s) {
        int a[] = new int[26];
        int b[] = new int[26];
        int ds1=0,ds2=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-97]++;
            if(a[s.charAt(i)-97] == 1)
                ds1++;
        }
        for(int i=0;i<s.length();i++)
        {
            b[s.charAt(i)-97]++;
            a[s.charAt(i)-97]--;
            if(a[s.charAt(i)-97] == 0)
                ds1--;
            if(b[s.charAt(i)-97] == 1)
                ds2++;
            if(ds1 == ds2)
                count++;
        }
        return count;
    }
}