```java
class Solution {
    public int maxDiff(int num) {
        int[] arr = new int[String.valueOf(num).length()];
        int originalNum = num;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        int max = getMax(arr);
        int min = getMin(arr);

        return max - min;
    }

    private int getMax(int[] arr) {
        int maxDigit = -1;
        int replacedDigit = -1;

        for (int i = 0; i < arr.length; i++) {
            if (replacedDigit == -1 && (arr[i] != 9 && arr[i] != 1)) {
                replacedDigit = arr[i];
            }
            if (replacedDigit == arr[i]) {
                arr[i] = 9;
            }
            maxDigit = maxDigit == -1 ? arr[i] : maxDigit * 10 + arr[i];
        }
        return maxDigit;
    }

    private int getMin(int[] arr) {
        int minDigit = -1;
        int replacedDigit = -1;

        for (int i = 0; i < arr.length; i++) {
            if (replacedDigit == -1 && arr[i] != 0 && (arr[i] != arr[0])) {
                replacedDigit = arr[i];
            }
            if (replacedDigit == arr[i]) {
                arr[i] = (i == 0) ? 1 : 0;
            }
            minDigit = minDigit == -1 ? arr[i] : minDigit * 10 + arr[i];
        }
        return minDigit;
    }
}
```