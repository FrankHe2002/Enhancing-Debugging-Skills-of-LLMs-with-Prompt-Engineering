class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> q;

    public PeekingIterator(Iterator<Integer> iterator) {
        q = new LinkedList<>();
        while (iterator.hasNext())
            q.add(iterator.next());
    }

    public Integer peek() {
        return q.peek();
    }

    @Override
    public Integer next() {
        return q.remove();
    }

    @Override
    public boolean hasNext() {
        return q.size() != 0;
    }
}
