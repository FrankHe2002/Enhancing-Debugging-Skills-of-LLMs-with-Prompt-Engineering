```java
// Runtime: 122 ms (Top 39.97%) | Memory: 81.7 MB (Top 80.48%)
class BrowserHistory {
    int current;
    ArrayList<String> history;

    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        history.add(homepage);
        this.current = 0;
    }

    public void visit(String url) {
        while (history.size() - 1 > current) {//delete forward history
            history.remove(history.size() - 1);//which means delete everything beyond our current website
        }
        history.add(url);
        current = history.size() - 1;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);//return current webpage
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);//return the current webpage
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url)
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
```