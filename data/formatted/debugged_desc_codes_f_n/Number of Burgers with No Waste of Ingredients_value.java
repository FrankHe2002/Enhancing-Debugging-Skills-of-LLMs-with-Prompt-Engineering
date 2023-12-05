```java
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int ts = tomatoSlices;
        int cs = cheeseSlices;
        if (ts < cs * 2 || ts > cs * 4 || ts % 2 != 0 || (ts == 0 && cs > 0) || (cs == 0 && ts > 0) || ts % 4 != 0) {
            return list;
        }
        int cnt = ts / 4 - cs;
        if (2 * cnt + cs == tomatoSlices / 2) {
            list.add(cnt);
            list.add(cs - cnt);
            return list;
        }
        return list;
    }
}
```