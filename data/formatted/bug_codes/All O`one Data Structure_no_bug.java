class AllOne {

    private Map<String, Bucket> stringToBucket;
    private Map<Integer, Bucket> countToBucket;
    private BucketList bucketList;

    class Bucket {
        private Bucket prev;
        private Bucket next;

        private int count;
        private Set<String> keys;

        Bucket() {
            this.keys = new HashSet<>();
        }

        Bucket(String key) {
            this();
            this.count = 1;
            this.keys.add(key);
        }

    }

    class BucketList {
        private Bucket dummyHead;
        private Bucket dummyTail;

        public BucketList() {
            dummyHead = new Bucket();
            dummyTail = new Bucket();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public Bucket createNewBucket(String key) {
            Bucket bucket = new Bucket(key);

            Bucket nextBucket = dummyHead.next;
            dummyHead.next = bucket;
            bucket.prev = dummyHead;
            nextBucket.prev = bucket;
            bucket.next = nextBucket;

            return bucket;
        }

        public Bucket createBucketToTheRight(Bucket fromBucket, String key, int count) {
            Bucket toBucket = new Bucket(key);
            toBucket.count = count;

            Bucket nextBucket = fromBucket.next;
            fromBucket.next = toBucket;
            toBucket.prev = fromBucket;
            nextBucket.prev = toBucket;
            toBucket.next = nextBucket;

            return toBucket;
        }

        public Bucket createBucketToTheLeft(Bucket fromBucket, String key, int count) {
            Bucket toBucket = new Bucket(key);
            toBucket.count = count;

            Bucket prevBucket = fromBucket.prev;
            prevBucket.next = toBucket;
            toBucket.prev = prevBucket;
            fromBucket.prev = toBucket;
            toBucket.next = fromBucket;

            return toBucket;
        }

        public boolean clean(Bucket oldBucket) {
            if (! oldBucket.keys.isEmpty()) {
                return false;
            }

            removeBucket(oldBucket);

            return true;
        }

        public void removeBucket(Bucket bucket) {
            Bucket prevBucket = bucket.prev;
            Bucket nextBucket = bucket.next;

            prevBucket.next = nextBucket;
            nextBucket.prev = prevBucket;
        }
    }


    public AllOne() {
        this.stringToBucket = new HashMap<>();
        this.countToBucket = new HashMap<>();
        this.bucketList = new BucketList();
    }

    public void inc(String key) {
        if (! stringToBucket.containsKey(key)) {
            Bucket bucket = null;
            if (! countToBucket.containsKey(1)) {
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
            countToBucket.putIfAbsent(count, newBucket);
        }
    }

    public void dec(String key) {
        Bucket oldBucket = stringToBucket.get(key);
        Bucket newBucket = null;

        int count = oldBucket.count;
        count--;
        oldBucket.keys.remove(key);
        if (count == 0) {
            stringToBucket.remove(key);
        } else {
            if (countToBucket.containsKey(count)) {
                newBucket = countToBucket.get(count);
                newBucket.keys.add(key);
            } else {
                newBucket = bucketList.createBucketToTheLeft(oldBucket, key, count);
            }
            stringToBucket.put(key, newBucket);
            countToBucket.putIfAbsent(count, newBucket);
        }
        if (bucketList.clean(oldBucket)) {
            countToBucket.remove(oldBucket.count);
        }
    }

    public String getMaxKey() {
        Set<String> maxSet = bucketList.dummyTail.prev.keys;

        return maxSet.isEmpty() ? "" : maxSet.iterator().next();

    }

    public String getMinKey() {
        Set<String> minSet = bucketList.dummyHead.next.keys;

        return minSet.isEmpty() ? "" : minSet.iterator().next();
    }
}

