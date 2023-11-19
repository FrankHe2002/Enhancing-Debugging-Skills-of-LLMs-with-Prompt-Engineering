import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {
    
    Deque<Integer> dq;
    int max_size;
    
    MyCircularDeque(int k) {
        dq = new LinkedList<>();
        max_size = k;
    }
    
    boolean insertFront(int value) {
        if(dq.size() < max_size) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }
    
    boolean insertLast(int value) {
        if(dq.size() < max_size) {
            dq.addLast(value);
            return true;
        }
        return false;
    }
    
    boolean deleteFront() {
        if(dq.size() > 0) {
            dq.removeFirst();
            return true;
        }
        return false;
    }
    
    boolean deleteLast() {
        if(dq.size() > 0) {
            dq.removeLast();
            return true;
        }
        return false;
    }
    
    int getFront() {
        if(dq.size() > 0)
            return dq.getFirst();
        return -1;
    }
    
    int getRear() {
        if(dq.size() > 0)
            return dq.getLast();
        return -1;
    }
    
    boolean isEmpty() {
        return dq.isEmpty();
    }
    
    boolean isFull() {
        return dq.size() == max_size;
    }
}