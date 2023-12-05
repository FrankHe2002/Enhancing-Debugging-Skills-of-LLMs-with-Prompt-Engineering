```java
class MyHashMap {

    LinkedList<Entry>[] map;
    public static int SIZE = 769;

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % SIZE;
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        } else {
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    entry.val = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }
    }

    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        if (entries == null) return -1;
        for (Entry entry : entries) {
            if (entry.key == key) return entry.val;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        if (map[bucket] == null) return;
        for (Entry entry : map[bucket]) {
            if (entry.key == key) {
                map[bucket].remove(entry);
                return;
            }
        }
    }
}

class Entry {
    public int key;
    public int val;

    public Entry(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
```