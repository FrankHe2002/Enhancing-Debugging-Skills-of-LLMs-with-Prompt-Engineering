```java
// Runtime: 1 ms (Top 100%) | Memory: 39.1 MB (Top 100%)
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int ts = tomatoSlices;
        int cs = cheeseSlices;
        if (ts < cs * 2 || ts > cs * 4 || ts % 2 != 0 || (ts == 0 && cs > 0) || (cs == 0 && ts > 0) || (ts % 4 != 0)) {
            return list;
        }
        int cnt = 0;
        while (ts > 0 && cs > 0 && ts != cs * 2) {
            ts -= 4;
            cnt++;
            cs--;
        }
        if (ts == 0 && cs == 0) {
            list.add(cnt);
            list.add(cheeseSlices - (cnt * 2));
        }
        return list;
    }
}
```