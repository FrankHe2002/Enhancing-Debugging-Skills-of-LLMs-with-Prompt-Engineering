The bug in the given code is that the condition for adding the fruit to the basket and the condition for updating the maximum number of fruits picked are not mutually exclusive. Additionally, the code does not update the maximum number of fruits picked after removing fruits from the basket.

To fix the bug:
- Add a check to ensure that fruit is not added to the basket if the basket already contains two types of fruits.
- Add an update to the maximum number of fruits picked after removing fruits from the basket.

Here's the updated code:

```java
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int start = 0, end = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //key = type of fruit on tree, value = last index / newest index of that fruit

        while (end < fruits.length) {
            if (map.size() < 2 || map.containsKey(fruits[end])) {
                map.put(fruits[end], end);
                end++;
            } else {
                int leftMost = fruits.length;
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(fruits[leftMost]);
                start = leftMost + 1;
            }

            res = Math.max(res, end - start); // update the maximum number of fruits picked
        }
        return res;
    }
}
```

The code now correctly checks for the condition of adding fruit to the basket and also updates the maximum number of fruits picked after removing fruits from the basket.