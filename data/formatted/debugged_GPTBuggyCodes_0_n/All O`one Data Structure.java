```java
public void inc(String key) {
    if (!stringToBucket.containsKey(key)) {
        Bucket bucket = null;
    
        if (!countToBucket.containsKey(1)) {
            bucket = bucketList.createNewBucket(key);
            countToBucket.put(1, bucket);
        } else {
            bucket = countToBucket.get(1);
            bucket.keys.add(key);
        }
    
        stringToBucket.put(key, bucket);
    } else {
        Bucket oldBucket = stringToBucket.get(key);
        Bucket newBucket = null;
    
        int count = oldBucket.count;
        count++;
        oldBucket.keys.remove(key);
    
        if (countToBucket.containsKey(count)) {
            newBucket = countToBucket.get(count);
            newBucket.keys.add(key);
        } else {
            newBucket = bucketList.createBucketToTheRight(oldBucket, key, count);
            countToBucket.put(count, newBucket);
        }
    
        if (bucketList.clean(oldBucket)) {
            countToBucket.remove(oldBucket.count);
        }
    
        stringToBucket.put(key, newBucket);
    }
}
```