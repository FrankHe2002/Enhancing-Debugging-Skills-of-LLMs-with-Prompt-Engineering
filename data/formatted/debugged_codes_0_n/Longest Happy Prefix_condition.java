```java
// Runtime: 13 ms (Top 89.72%) | Memory: 43.2 MB (Top 90.81%)
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int lps[] = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && arr[j] != arr[i]) {
                j = lps[j - 1];
            }
            if (arr[j] == arr[i]) {
                j++;
            }
            lps[i] = j;
        }
        int j = lps[n - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < j; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}
/*
 ALTERNATE

  for(int i=1;i<n;i++){
            if(arr[i]==arr[j]){
                lps[i]=++j;
            }else if(j>0){
                j=lps[j-1];
                i--;
            }
        }
        return s.substring(0,j);

 */
```
Note: The only change made was on line 6, where the condition in the for loop was modified to `i < n` instead of `i <= n`.