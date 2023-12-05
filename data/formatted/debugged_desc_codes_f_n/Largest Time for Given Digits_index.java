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
        if (sb.length() == 2) {
            sb.append(':');
        }
        int size = sb.length();
        int start = size == 0 ? 2 : (size == 1 && sb.charAt(0) == '2') ? 3 : (size == 2) ? 5 : 9;
        for (int i = start; i >= 0; i--) {
            if (count[i] == 0) continue;
            count[i]--;
            sb.append(i);
            backTrack(count, sb);
            if (sb.length() == 4) {
                return sb;
            } else {
                count[i]++;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb;
    }
}
```