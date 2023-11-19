class TimeMap {
    private Map<String, List<Entry>> map;
    private final String NOT_FOUND = "";

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Entry> entries = map.getOrDefault(key, new ArrayList<>());
        entries.add(new Entry(value, timestamp));
        map.put(key, entries);
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = map.get(key);
        if (entries == null) {
            return NOT_FOUND;
        }
        return binarySearch(entries, timestamp);
    }

    private String binarySearch(List<Entry> entries, int timestamp) {
        int lo = 0, hi = entries.size() - 1, mid = - 1;
        String ans = "";
        if (entries.get(lo).timestamp > timestamp) {
            return NOT_FOUND;
        } else if (entries.get(hi).timestamp <= timestamp) {
            return entries.get(hi).value;
        }
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            Entry entry = entries.get(mid);
            if (entry.timestamp == timestamp) {
                return entry.value;
            } else if (entry.timestamp < timestamp) {
                ans = entry.value;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}

class Entry {
    String value;
    int timestamp;

    public Entry(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}