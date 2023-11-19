```java
class Skiplist {

    public static final int MAX_LEVEL = 4;

    private final int levels;

    private SkipListEntry head;

    private SkipListEntry tail;

    public Skiplist() {
        this.levels = MAX_LEVEL;
    }

    public Skiplist(int levels) {
        this.levels = levels;

        SkipListEntry left = new SkipListEntry(Integer.MIN_VALUE, Integer.MIN_VALUE);
        SkipListEntry right = new SkipListEntry(Integer.MAX_VALUE, Integer.MAX_VALUE);
        left.right = right;
        right.left = left;

        this.head = left;
        this.tail = right;

        for (int i = 1; i < this.levels; i++) {
            left.down = new SkipListEntry(
                    Integer.MIN_VALUE,
                    Integer.MIN_VALUE,
                    null,
                    null,
                    left,
                    null
            );
            left = left.down;

            right.down = new SkipListEntry(
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE,
                    null,
                    null,
                    right,
                    null
            );
            right = right.down;

            left.right = right;
            right.left = left;
        }
    }

    public boolean search(int target) {
        return this.find(target).key == target;
    }

    public void add(int num) {
        SkipListEntry current = this.head;

        while (current.hasDown()) {
            current = current.down;
        }

        while (current.hasRight() && num > current.right.key) {
            current = current.right;
        }

        if (num == current.key) {
            return;
        }

        SkipListEntry newNode = new SkipListEntry(num, num, current, current.right);
        current.right.left = newNode;
        current.right = newNode;

        for (int level = this.levels - 2; level >= 0; level--) {
            if (! this.coinFlip(level)) {
                return;
            }

            while (! current.hasUp() && current.hasLeft()) {
                current = current.left;
            }
            current = current.up;

            newNode.up = new SkipListEntry(
                    num,
                    num,
                    current,
                    current.right,
                    null,
                    newNode
            );
            newNode = newNode.up;

            current.right.left = newNode;
            current.right = newNode;
        }
    }

    public boolean erase(int num) {
        SkipListEntry entry = this.find(num);
        if (entry.key != num) {
            return false;
        }

        entry