```java
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int ele : answers) {

            if (! map.containsKey(ele + 1) || map.get(ele + 1) == 0) {
                map.put(ele + 1, ele);
                count += ele + 1;
            } else {
                int remain = map.get(ele + 1) - 1;
                map.put(ele + 1, remain);
            }
        }

        return count;
    }
}
```