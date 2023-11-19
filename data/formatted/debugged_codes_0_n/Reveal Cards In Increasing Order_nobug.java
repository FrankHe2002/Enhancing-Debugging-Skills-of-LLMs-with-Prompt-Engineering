```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> ql = new LinkedList<Integer>();
        for (int i = 0; i < deck.length; i++)
            ql.add(i);

        int[] ans = new int[deck.length];
        int k = 0;

        Arrays.sort(deck);

        while (!ql.isEmpty()) {
            ans[ql.peek()] = deck[k];
            ql.poll();
            k++;
            if (!ql.isEmpty()) {
                ql.add(ql.peek());
                ql.poll();
            }
        }

        return ans;
    }
}
```