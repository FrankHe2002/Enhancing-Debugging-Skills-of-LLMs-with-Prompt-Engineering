The bug in the provided Java code is a syntax error and a logical error. There is a syntax error causing a compilation issue when trying to build the class. Within the switch block, there is a logical error where the sum is incorrectly calculated.

1. The syntax in the switch block for case "+" has an extra set of brackets and incorrect index references, resulting in a compilation error.
2. The summation for the "+" operation uses the wrong indices. The fix is to adjust the index calculations to access the correct elements for summation.
3. Additionally, the code is using an ArrayList without importing the class. The fix is to add the import statement for ArrayList at the beginning of the file.

The fixed code is provided below:

```java
import java.util.ArrayList;
import java.util.List;

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