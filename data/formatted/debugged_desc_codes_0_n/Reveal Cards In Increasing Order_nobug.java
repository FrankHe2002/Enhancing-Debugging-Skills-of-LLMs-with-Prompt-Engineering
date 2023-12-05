```java
// Runtime: 5 ms (Top 59.29%) | Memory: 44.5 MB (Top 28.33%)
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> ql = new LinkedList<Integer>();
        for (int i = 0; i < deck.length; i+=2)
            ql.add(i);
        int[] ans = new int[deck.length];
        int k = 0;
        Arrays.sort(deck);
        while (! ql.isEmpty()) {
            ans[ql.poll()] = deck[k];
            k++;
            if (! ql.isEmpty()) {
                ql.add(ql.poll());
            }
        }
        return ans;
    }
}
```