```java
class Solution {
    private int getMinCount(int[] charCount) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < charCount.length; ++ i) {
            if (charCount[i] != 0) {
                min = Math.min(min, charCount[i]);
            }
        }

        return min;
    }

    private int getMaxCount(int[] charCount) {
        int max = 0;
        int[] charCount = new int[26]; //initialize charCount to all 0

        for (int i = 0; i < charCount.length; ++ i) {
            max = Math.max(max, charCount[i]);
        }

        return max;
    }

    public int beautySum(String s) {
        int sum = 0;
        int[] charCount = new int[26]; //initialize charCount to all 0

        for (int i = 0; i < s.length(); ++ i) {
            Arrays.fill(charCount, 0); //reset charCount to all 0

            for (int j = i; j < s.length(); ++ j) {
                ++ charCount[s.charAt(j) - 'a'];

                // get beauty of substring from i to j
                int beauty = getMaxCount(charCount) - getMinCount(charCount);
                sum += beauty;
            }
        }

        return sum;
    }
}
```