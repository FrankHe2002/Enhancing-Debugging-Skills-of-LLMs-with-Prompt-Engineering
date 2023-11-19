```java
class AllOne {
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
            if (!oldBucket.keys.isEmpty()) {
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
  
    private Map<String, Bucket> stringToBucket;
    private Map<Integer, Bucket> countToBucket;
    private BucketList bucketList;
  
    public AllOne() {
        this.stringToBucket = new HashMap<>();
        this.countToBucket = new HashMap<>();
