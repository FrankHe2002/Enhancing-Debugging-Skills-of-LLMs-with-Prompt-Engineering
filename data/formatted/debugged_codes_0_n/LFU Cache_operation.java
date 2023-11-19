class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }

    }

    class List {
        int size;
        Node head, tail;

        List() {
            size = 0;
            head = new Node(- 1, - 1);
            tail = new Node(- 1, - 1);
            head.next = tail;
            tail.prev = head;
        }

        void ins(Node newNode) {
            Node temp = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
            size++;

        }

        void del(Node newNode) {
            Node pr = newNode.prev;
            Node nx = newNode.next;
            pr.next = nx;
            nx.prev = pr;
            size--;
        }
    }

    Map<Integer, Node> mp;
    Map<Integer, List> listMap;
    int maxSize, minFreq, currSize;

    public LFUCache(int capacity) {
        maxSize = capacity;
        minFreq = 0;
        currSize = 0;
        mp = new HashMap<Integer, Node>();
        listMap = new HashMap<Integer, List>();
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            int val = node.value;
            updateFreq(node);
            return val;
        }
        return - 1;
    }

    public void put(int key, int value) {
        if (maxSize == 0)
            return;
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            node.value = value;
            updateFreq(node);
        } else {