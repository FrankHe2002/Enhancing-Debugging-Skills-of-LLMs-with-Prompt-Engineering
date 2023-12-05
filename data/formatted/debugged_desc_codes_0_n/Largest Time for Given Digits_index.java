```java
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[] count = new int[10];
        for (int num : arr) {
            count[num]++;
        }
        StringBuilder sb = new StringBuilder();
        backTrack(count, sb);
        if (sb.length() == 4) sb.insert(2, ':');
        return sb.toString();

    }

    private boolean backTrack(int[] count, StringBuilder sb) {
        int size = sb.length();
        int start = 0;
        if (size == 0) {
            start = 2;
        }
        if (size == 1) {
            start = sb.charAt(0) == '2' ? 3 : 9;
        }
        if (size == 2) {
            start = 5;
        }
        if (size == 3) {
            start = 9;
        }
        for (int i = start; i >= 0; i--) {
            if (count[i] == 0) continue;
            count[i]--;
            sb.append(i);
            if (backTrack(count, sb)) {
                return true;
            } else {
                count[i]++;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.length() == 4;
    }
}
```