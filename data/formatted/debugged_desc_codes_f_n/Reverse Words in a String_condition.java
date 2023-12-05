Fix:
```java
class Solution {
    public String reverseWords(String s) {
       String[] arr = s.trim().split("\\s+");
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return String.join(" ", arr);
    }
}
```