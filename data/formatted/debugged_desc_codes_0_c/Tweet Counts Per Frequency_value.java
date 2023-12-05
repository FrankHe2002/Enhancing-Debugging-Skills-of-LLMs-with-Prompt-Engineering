The bug in the provided Java code is in the `Freq` enum. The `map` should be a static member of the enum to hold the frequency values, and the `getVal` method should use the static `map` to retrieve the frequency value.

Below is the fixed code:

```java
class TweetCounts {
    Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, v -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        if (map.containsKey(tweetName)) {
            Collections.sort(map.get(tweetName));
            while (startTime <= endTime) {
                int interval = Freq.valueOf(freq).getVal();
                int end = Math.min(startTime + interval - 1, endTime); // need this to handle the last interval
                res.add(getFreq(map.get(tweetName), startTime, end));
                startTime = end + 1; // ex: for minute, the interval is 60 so our end is 59. The next startTime is end+1
            }
        }
        return res;
    }

    public int getFreq(List<Integer> list, int start, int end) {
        int st = Collections.binarySearch(list, start);
        if (st < 0) {
            st = (st + 1) * - 1; // our exact start time might not be in the list, to get the 1st timestamp greater than start
        }
        int en = Collections.binarySearch(list, end);
        if (en < 0) {
            en = (en + 2) * - 1; // our exact end time might not be in the list, to get the last timestamp just smaller than end
        }

        return en - st + 1; // the freq count
    }
}

enum Freq {
    minute(60), hour(3600), day(86400);

    private static Map<Freq, Integer> map = new HashMap<>();

    static {
        for (Freq freq : Freq.values()) {
            map.put(freq, freq.val);
        }
    }

    private int val;

    Freq(int val) {
        this.val = val;
    }

    public int getVal() {
        return map.get(this);
    }
}
```