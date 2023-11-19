```java
class Solution {

    public int minMovesToMakePalindrome(String s) {
        int len = s.length();
        char[] strArr = s.toCharArray();
        int steps = 0;
        int l = 0, r = len - 1;

        while (l < r) {
            if (strArr[l] == strArr[r]) {
                l++;
                r--;
            } else {
                int k = r;
                k = findKthIndexMatchingwithLthIndex(strArr, l, k);

                if (k == l) {
                    swap(strArr, l, r); // Swap elements at l and r indices
                    steps++;
                } else {
                    while (k < r) {
                        swap(strArr, k, k + 1); // Swap elements at k and k+1 indices
                        steps++;
                        k++;
                    }
                    l++;
                    r--;
                }
            }
        }
        System.out.println("palindrome: " + String.valueOf(strArr));
        return steps;
    }

    public int findKthIndexMatchingwithLthIndex(char[] strArr, int l, int k) {
        while (k > l) {
            if (strArr[k] == strArr[l]) {
                return k;
            }
            k--;
        }
        return k;
    }

    public void swap(char[] strArr, int l, int r) { // Add r as a parameter
        if (r < strArr.length) { // Remove -1 in the condition
            char tempCh = strArr[l];
            strArr[l] = strArr[r];
            strArr[r] = tempCh;
        }
    }
}
```