```java
class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        String ans = "";
        if (k == 1) {
            String temp = s;
            for (int i = 1; i < n; i++) {
                String current = s.substring(i) + s.substring(0, i);
                if (current.compareTo(temp) < 0) {
                    temp = current;
                }
            }
            ans = temp;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            ans = String.valueOf(arr);
        }
        return ans;
    }
}
```