```java
class TimeMap {
    private Map<String, List<Entry>> map;
    private static final String NOT_FOUND = "";

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
        int lo = 0, hi = entries.size() - 1, mid, ansIndex = -1;

        // Base cases - if value is not set, return empty
        if (entries.get(lo).timestamp > timestamp) {
            return NOT_FOUND;
        // If timestamp is equal or greater, return the last value saved in map against this key, since that will have the largest timestamp
        } else if (entries.get(hi).timestamp <= timestamp) {
            return entries.get(hi).value;
        }

        // Else apply binary search to get correct value
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2; // Update binary search formula
            Entry entry = entries.get(mid);
            if (entry.timestamp > timestamp) {
                hi = mid - 1;
            } else {
                ansIndex = mid; // Update ansIndex if a valid value is found
                lo = mid + 1;
            }
        }
        return entries.get(ansIndex).value; // Return the value with ansIndex
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
```