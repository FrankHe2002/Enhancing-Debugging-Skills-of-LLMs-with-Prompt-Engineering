Code Explanation:
The original code causes a compilation error due to multiple syntax and logic errors. The method findMinHeight is incorrectly defined as having three parameters but is called with only one parameter, and there is also a missing semicolon in the return statement of the method. Additionally, there are missing parentheses in the Math.min calculation, and the logic for whether the current book fits on the shelf is incorrect. The fix involves addressing these issues.

Fix:
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    int[][] books;
    int shelfWidth;

    Map<String, Integer> memo = new HashMap<>();

    public int findMinHeight(int curr, int maxHeight, int wRem) {
        String key = curr + ":" + wRem;

        if (memo.containsKey(key)) return memo.get(key);

        if (curr == books.length) return maxHeight;

        int[] currBook = books[curr];

        if (currBook[0] > wRem) {
            memo.put(key, maxHeight + findMinHeight(curr + 1, currBook[1], shelfWidth - currBook[0]));
        } else {
            memo.put(key, Math.min(
                    maxHeight + findMinHeight(curr + 1, currBook[1], shelfWidth - currBook[0]),  // new shelf
                    findMinHeight(curr + 1, Math.max(maxHeight, currBook[1]), wRem - currBook[0))  // same shelf
            );
        }

        return memo.get(key);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        return findMinHeight(0, 0, shelfWidth);
    }
}
```

The fixed code now correctly handles the recursive calls and calculates the minimum possible height of the total bookshelf after placing shelves in the given manner.