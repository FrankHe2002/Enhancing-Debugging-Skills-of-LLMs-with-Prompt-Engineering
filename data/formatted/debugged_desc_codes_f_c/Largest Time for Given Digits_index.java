Fix:
```java
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[] count = new int[10];
        for (int num : arr) {
            count[num]++;
        }
        StringBuilder sb = backTrack(count, new StringBuilder());
        if (sb.length() == 4) sb.insert(2, ':');
        return sb.toString();
    }

    private StringBuilder backTrack(int[] count, StringBuilder sb) {
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
            int num = i + 2;
            if (count[num] == 0) continue;
            count[num]--;
            sb.append(num);
            StringBuilder updatedSB = backTrack(count, sb);
            if (updatedSB.length() == 4) {
                return updatedSB;
            } else {
                count[num]++;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb;
    }
}
```