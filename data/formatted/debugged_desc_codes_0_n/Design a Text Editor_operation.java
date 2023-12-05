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
        int tmp = pos;
        pos -= k;
        if (pos < 0) {
          pos = 0;
        }
        res.delete(pos, tmp);
        return tmp - pos;
    }

    public String cursorLeft(int k) {
        pos -= k;
        if (pos < 0) {
          pos = 0;
        }
        int len = Math.min(10, pos);
        return res.substring(pos - len, pos);
    }

    public String cursorRight(int k) {
        pos += k;
        if (pos > res.length()) {
          pos = res.length();
        }
        int len = Math.min(10, res.length() - pos);
        return res.substring(pos - len, pos);
    }
}
```