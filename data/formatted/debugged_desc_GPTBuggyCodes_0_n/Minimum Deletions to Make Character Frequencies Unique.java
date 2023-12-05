```java
class Solution {
    private int N = 26;

    public int minDeletions(String s) {
        int[] array = new int[N];
        for (char ch : s.toCharArray()) {
            array[ch - 97]++;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            if (i == 0) continue;
            while (set.contains(i)) {
                i--;
                if(i == 0){
                    ans += 1;
                } else {
                    ans += 1;
                } 
            }
            if (i != 0) {
                set.add(i);
            }
        }
        return ans;
    }
}
```