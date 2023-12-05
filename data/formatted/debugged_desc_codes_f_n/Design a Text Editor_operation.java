```java
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
        int tmp = Math.min(pos, k);
        pos -= tmp;
        res.delete(pos, pos + tmp);
        return tmp;
    }

    public String cursorLeft(int k) {
        pos = Math.max(0, pos - k);
        if (pos < 10) return res.substring(0, pos);
        return res.substring(pos - 10, pos);
    }

    public String cursorRight(int k) {
        pos = Math.min(res.length(), pos + k);
        if (pos < 10) return res.substring(0, pos);
        return res.substring(pos - 10, pos);
    }
}
```