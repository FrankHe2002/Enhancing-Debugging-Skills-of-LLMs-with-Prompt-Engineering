```java
public void inc(String key) {
    //first check if the string already present
    if (!stringToBucket.containsKey(key)) { //if not present
        Bucket bucket = null;

        //check if there is count of 1 bucket already
        if (!countToBucket.containsKey(1)) { //if does not contain count of 1
            //we need to create a new bucket for count of 1 and add to the head (the minimum). Because count 1 should be the minimum exists in the bucket list
            bucket = bucketList.createNewBucket(key);
        } else { //if contains count of 1
            //then we just need to add the key to the bucket
            bucket = countToBucket.get(1);
            bucket.keys.add(key);
        }

        //don't forget to update the maps
        stringToBucket.put(key, bucket);
        countToBucket.put(1, bucket);
    } else { //if the key alreay present
        //first of all we need to get the current count for the key
        Bucket oldBucket = stringToBucket.get(key);
        Bucket newBucket = null;

        int count = oldBucket.count;
        count++; //increment 1
        //don't forget that we need to remove the key from existing bucket
        oldBucket.keys.remove(key);

        //now let's add the key with new count
        if (countToBucket.containsKey(count)) { //if there is already a bucket for this count
            //then just add to the set of keys
            newBucket = countToBucket.get(count);
            newBucket.keys.add(key);
        } else { //if there is no bucket for this count, create a new bucket, but where to place it? Ans: to the right of the old bucket
            newBucket = bucketList.createBucketToTheRight(oldBucket, key, count);
        }

        //special scenario: if old bucket don't have any keys after removing the last key, then we need to remove the entire old bucket from the bucket list
        if (bucketList.clean(oldBucket)) {
            countToBucket.remove(oldBucket.count); //remove from map because the old bucket was removed
        }

        //don't forget to update the maps
        stringToBucket.put(key, newBucket);
        countToBucket.put(count, newBucket);
    }
}
```