```java
// Runtime: 4 ms (Top 49.02%) | Memory: 38.9 MB (Top 99.95%)
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int ts = tomatoSlices;
        int cs = cheeseSlices;
        if (ts < cs * 2 || ts > cs * 4 || ts % 2 != 0 || (ts == 0 && cs > 0) || (cs == 0 && ts > 0)) {
            return list;
        }
        int cnt = 0;
        while (ts > 0 && cs > 0 && ts != cs * 4) {
            ts -= 4;
            cnt++;
            cs--;
        }
        if (ts == 0 && cs == 0) {
            list.add(cnt);
            list.add(0);
        }
        else if (ts == cs * 4) {
            list.add(cnt);
            list.add(cs);
        }
        return list;
    }
}
```