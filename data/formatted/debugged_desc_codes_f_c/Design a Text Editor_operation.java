Fixed code:
```java
// Runtime: 22 ms (Top 56.43%) | Memory: 39.3 MB (Top 95.98%)
class TextEditor {
    StringBuilder res;
    int pos = 0;

    public TextEditor() {
        res = new StringBuilder();
    }

    public void addText(String text) {
        res.insert(pos, text);
        pos += text.length();
    }

    public int deleteText(int k) {
        int tmp = pos;
        pos -= k;
        if (pos < 0) pos = 0;
        res.delete(pos, tmp);
        return tmp - pos;
    }

    public String cursorLeft(int k) {
        pos -= k;
        if (pos < 0) pos = 0;
        if (pos < 10) return res.substring(0, pos);
        return res.substring(pos - 10, pos);
    }

    public String cursorRight(int k) {
        pos += k;
        if (pos > res.length()) pos = res.length();
        if (pos < 10) return res.substring(0, pos);
        return res.substring(pos - 10, pos);
    }
}
```