Bug type: Syntax Error

The bug is a syntax error because in the last for loop, there is a missing closing parenthesis in the line "arr[i] = arrInt[i;".


To fix this bug, I will add the missing closing parenthesis in the last for loop.

Here's the modified code:

```java
class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] arrInt = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = arr[i];
        }

        Arrays.sort(arrInt, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int aBits = numOfBits(a);
                int bBits = numOfBits(b);
                if (aBits == bBits) {
                    return a - b;
                }
                return aBits - bBits;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrInt[i];
        }
        return arr;
    }

    public int numOfBits(int a) {
        int bits = 0;
        while (a != 0) {
            bits += a & 1;
            a = a >>> 1;
        }

        return bits;
    }
}
```