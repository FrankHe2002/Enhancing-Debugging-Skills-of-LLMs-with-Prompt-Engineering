```java
//Intuitions get from the top answer by @AaronLin1992
class AllOne {
    //Thoughts
    //inc() and dec() can be done with a Simple Map, but how do we getMaxKey() and getMinKey() in O(1)?
    //in order to get max and/or min on the fly, we need to maintain some kind of ordering so that we can always access max and min
    //to maintain some kind of ordering, the first thing we think about is arrays/lists, however, arrays/lists when insert and delete in the middle, it is O(N) operation
    //so instead, a linked list might work
    //as a result, we considering using Map(s) and LinkedList for our supporting data structures, details below

    private Map<String, Bucket> stringToBucket; //maps a string to bucket
    private Map<Integer, Bucket> countToBucket; //maps string count to bucket, note that because when we design this we can have multiple strings in a bucket, that makes it convenient so that for each count, we only need 1 bucket, thus the map data structure
    private BucketList bucketList;

    //first, we need to create a class for the LinkedList elements
    class Bucket {
        private Bucket prev;
        private Bucket next;

        private int count; //recording the count of instances
        private Set<String> keys; //note that we are using Set of Strings. The reason is because multiple Strings can have the same count and we want to put them in one bucket. This makes the problem easier to solve instead of putting them into different buckets.

        Bucket() {
            this.keys = new HashSet<>();
        }

        Bucket(String key) {
            this();
            this.count = 1;
            this.keys.add(key);
        }

    }

    //second, we need to create a linked list data structure of buckets
    class BucketList {
        private Bucket dummyHead; //the fake head before the real head //useful for getMinKey()
        private Bucket dummyTail; //the fake tail before the real tail //useful for getMaxKey()

        public BucketList() {
            dummyHead = new Bucket();
            dummyTail = new Bucket();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public Bucket createNewBucket(String key) {
            Bucket bucket = new Bucket(key);

            Bucket nextBucket = dummyHead.next;
            dummyHead