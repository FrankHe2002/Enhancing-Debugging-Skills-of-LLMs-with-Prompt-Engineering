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
                int end = Math.min(startTime + interval - 1, endTime);
                res.add(getFreq(map.get(tweetName), startTime, end));
                startTime = end + 1;
            }
        }
        return res;
    }

    public int getFreq(List<Integer> list, int start, int end) {
        int st = Collections.binarySearch(list, start);
        if (st < 0) {
            st = (st + 1) * - 1;
        }
        int en = Collections.binarySearch(list, end);
        if (en < 0) {
            en = (en + 2) * - 1;
        }

        return en - st + 1;
    }
}

enum Freq {
    minute(60), hour(3600), day(86400);
    Map<Freq, Integer> map = new HashMap<>();

    Freq(int val) {
        map.put(this, val);
    }

    public int getVal() {
        return map.get(this);
    }

}

