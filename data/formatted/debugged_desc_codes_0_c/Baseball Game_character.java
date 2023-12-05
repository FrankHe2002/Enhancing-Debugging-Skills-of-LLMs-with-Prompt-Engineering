The bug in the code is that the "+" operation is not correctly implementing the rule that it records a new score that is the sum of the previous two scores. The code in the "+" case of the switch statement is also using incorrect indexing when adding elements together.

To fix this bug, a proper implementation of the "+" operation is required. Additionally, there is a typo in the indexing used inside the switch statement.

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    break;
                default:
                    list.add(Integer.valueOf(ops[i]));
                    break;
            }
        }

        int finalScore = 0;
        for (Integer score : list)
            finalScore += score;

        return finalScore;
    }
}
```