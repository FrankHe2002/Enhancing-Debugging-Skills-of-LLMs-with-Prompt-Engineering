```java
// Runtime: 2 ms (Top 94.07%) | Memory: 39.8 MB (Top 92.52%)
class Solution {
    // for the ease to check CDATA starting tag
    private static final char[] CDATA_TAG = {'[', 'C', 'D', 'A', 'T', 'A', '['};

    public boolean isValid(String code) {
        // make sure it is possible to have a start tag and an end tag
        if (! code.startsWith("<") || ! code.endsWith(">")) {
            return false;
        }
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < code.length(); ++ i) {
            char ch = code.charAt(i);
            // if it is a special tag
            if (ch == '<') {
                if (i == code.length() - 1) {
                    return false;
                }
                ch = code.charAt(++ i);
                // is end tag
                if (ch == '/') {
                    // we should have a start tag to match the end tag
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // get the end tag
                    StringBuilder sb = new StringBuilder();
                    // build tag and move i to the > for the next round
                    i = buildTag(code, i + 1, sb);
                    // if tag is unmatch, return false
                    if (! stack.pop().equals(sb.toString())) {
                        return false;
                    }
                    // if no start tag left and we are not at the end. The rest content is not enclosed. -> false
                    if (stack.isEmpty() && i < code.length() - 1) {
                        return false;
                    }
                } else if (ch == '!') { // is CDATA tag
                    // check if CDATA is encoded in a tag
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // check CDATA and move i to the end of ]]> for the next round
                    i = validAndMoveCDATA(code, i + 1);
                    // the above function return -1 if CDATA is not valid
                    if (i < 0) {
                        return false;
                    }
                } else { // start tag
                    // TAG_NAME should not empty
                    if (ch == '>') {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    i = buildTag(code, i,