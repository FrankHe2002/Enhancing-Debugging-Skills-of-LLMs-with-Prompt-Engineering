Bug Type: Array Index Out of Bounds

Reasoning: The code attempts to access `rowi]` instead of `row[i]`, causing an `ArrayIndexOutOfBoundsException`. The correct syntax is `row[i]` to access the element at index `i` in the `row` array.

Fixed Code:
```java
// Runtime: 1 ms (Top 81.21%) | Memory: 44.9 MB (Top 51.92%)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; ++ i) {
            flip(image[i]);
        }
        for (int i = 0; i < image.length; ++ i) {
            for (int j = 0; j < image[i].length; ++ j) {
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return image;
    }

    public static void flip(int[] row) {
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            ++ i;
            -- j;
        }
    }
}
```