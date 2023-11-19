class Solution {
    private static final char[] CDATA_TAG = {'[','C','D','A','T','A','['};
    public boolean isValid(String code) {
        if (!code.startsWith("<") || !code.endsWith(">")) {
            return false;
        }
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < code.length(); ++i) { // Bug: Change > to <
            char ch = code.charAt(i);
            if (ch == '<') {
                if (i == code.length() - 1) {
                    return false;
                }
                ch = code.charAt(++i);
                if (ch == '/') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    i = buildTag(code, i + 1, sb);
                    if (!stack.pop().equals(sb.toString())) {
                        return false;
                    }
                    if (stack.isEmpty() && i < code.length() - 1) {
                        return false;
                    }
                } else if (ch == '!') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    i = validAndMoveCDATA(code, i + 1);
                    if (i < 0) {
                        return false;
                    }
                } else {
                    if (ch == '>') {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    i = buildTag(code, i , sb);
                    if (sb.isEmpty() || sb.length() > 9) {
                        return false;
                    }
                    stack.push(sb.toString());
                }
            }
        }
        return stack.isEmpty();
    }

    private int buildTag(String code, int start, StringBuilder sb) {
        int i = start;
        for (; i < start + 10 && i < code.length(); ++i) {
            char ch = code.charAt(i);
            if (ch == '>') {
                break;
            }
            if (!Character.isUpperCase(ch)) {
                sb.setLength(0);
                break;
            }
            sb.append(ch);
        }
        return i;
    }

    private int validAndMoveCDATA(String code, int start) {
        if (code.length() - start < 10) {
            return -1;
        }
        int i = start;
        for (int j = 0; j < CDATA_TAG.length; ++j) {
            char ch = code.charAt(i++);