```java
public void inc(String key) {
        if (!stringToBucket.containsKey(key)) {
            Bucket bucket = null;

            if (!countToBucket.containsKey(1)) {
                bucket = bucketList.createNewBucket(key);
            } else {
                bucket = countToBucket.get(1);
                bucket.keys.add(key);
            }

            stringToBucket.put(key, bucket);
            countToBucket.put(1, bucket);
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
            }

            if (bucketList.clean(oldBucket)) {
                countToBucket.remove(oldBucket.count);
            }

            stringToBucket.put(key, newBucket);
            countToBucket.put(count, newBucket);
        }
    }
```