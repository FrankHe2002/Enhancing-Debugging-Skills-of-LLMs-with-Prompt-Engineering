```java
class Solution {
    int[][] books;
    int shelfWidth;

    Map<String, Integer> memo = new HashMap();

    public int findMinHeight(int curr, int maxHeight, int wRem) {
        String key = curr + ":" + wRem;

        if (memo.containsKey(key)) return memo.get(key);


        if (curr == books.length) return maxHeight;
        int[] currBook = books[curr];

        memo.put(key, currBook[0] <= wRem ? Math.min(maxHeight + findMinHeight(curr + 1, currBook[1], shelfWidth - currBook[0]), 
                findMinHeight(curr + 1, Math.max(maxHeight, currBook[1]), wRem - currBook[0])) 
                : maxHeight + findMinHeight(curr + 1, currBook[1], shelfWidth - currBook[0])
        ); 

        return memo.get(key);
    }


    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        return findMinHeight(0, 0, shelfWidth);
    }
}
```