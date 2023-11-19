```java
class AllOne {

private class Bucket {
    int count;
    Set<String> keySet = new HashSet<>();
    Bucket prev;
    Bucket next;
    Bucket(int count) {
        this.count = count;
    }
}

private Bucket head;
private Bucket tail;
private Map<Integer, Bucket> countMap;
private Map<String, Integer> keyMap;

public AllOne() {
    head = new Bucket(Integer.MIN_VALUE);
    tail = new Bucket(Integer.MAX_VALUE);
    head.next = tail;
    tail.prev = head;
    countMap = new HashMap<>();
    keyMap = new HashMap<>();
}

public void inc(String key) {
    if (keyMap.containsKey(key)) {
        changeKey(key, 1);
    } else {
        if (head.next.count != 1) {
            addBucketAfter(new Bucket(1), head);
        }
        head.next.keySet.add(key);
        keyMap.put(key, 1);
        countMap.put(1, head.next);
    }
}

public void dec(String key) {
    if (keyMap.containsKey(key)) {
        int count = keyMap.get(key);
        if (count == 1) {
            keyMap.remove(key);
            removeKeyFromBucket(countMap.get(count), key);
        } else {
            changeKey(key, -1);
        }
    }
}

public String getMaxKey() {
    return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
}

public String getMinKey() {
    return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
}

private void changeKey(String key, int offset) {
    int count = keyMap.get(key);
    keyMap.put(key, count + offset);
    Bucket curBucket = countMap.get(count);
    Bucket newBucket;
    if (countMap.containsKey(count + offset)) {
        newBucket = countMap.get(count + offset);
    } else {
        newBucket = addBucketAfter(new Bucket(count + offset), offset == 1 ? curBucket : curBucket.prev);
    }
    newBucket.keySet.add(key);
    removeKeyFromBucket(curBucket, key);
}

private void removeKeyFromBucket(Bucket bucket, String key) {
    bucket.keySet.remove(key);
    if (bucket.keySet.size() == 0) {
        removeBucketFromList(bucket);
        countMap.remove(bucket.count);
    }
}

private Bucket addBucketAfter(Bucket newBucket, Bucket preBucket) {
    newBucket.prev =