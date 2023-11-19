```java
class Solution {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] arr = binaryString.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1')
                ans.add(i);
        }
        int res = 0;
        for (int i = 0; i < ans.size() - 1; i++) {
            res = Math.max(res, ans.get(i + 1) - ans.get(i));
        }
        return res;
    }
}
```