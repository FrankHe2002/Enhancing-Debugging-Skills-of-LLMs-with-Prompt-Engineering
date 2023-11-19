```java
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int sLen = stamp.length();
        int tLen = target.length();

        Queue<Integer> reversedCharIndices = new LinkedList<>();
        boolean[] isReversedCharOfThisIndex = new boolean[tLen];
        Stack<Integer> stack = new Stack<>();
        List<Window> windowList = new ArrayList<>();

        for (int windowStartIndex = 0; windowStartIndex <= tLen - sLen; windowStartIndex++) {
            Set<Integer> matched = new HashSet<>();
            Set<Integer> notMatched = new HashSet<>();

            for (int j = 0; j < sLen; j++) {
                int charIndex = windowStartIndex + j;

                if (stamp.charAt(j) == target.charAt(charIndex)) {
                    matched.add(charIndex);
                } else {
                    notMatched.add(charIndex);
                }
            }

            windowList.add(new Window(matched, notMatched));

            if (notMatched.isEmpty()) {
                stack.push(windowStartIndex);

                for (int index : matched) {
                    if (!isReversedCharOfThisIndex[index]) {
                        reversedCharIndices.add(index);
                        isReversedCharOfThisIndex[index] = true;
                    }
                }

            }
        }

        while (!reversedCharIndices.isEmpty()) {
            int reversedCharIndex = reversedCharIndices.remove();
            int start = Math.max(0, reversedCharIndex - sLen + 1);
            int end = Math.min(reversedCharIndex, tLen - sLen);

            for (int windowIndex = start; windowIndex <= end; windowIndex++) {
                if (windowList.get(windowIndex).notMatched.contains(reversedCharIndex)) {
                    windowList.get(windowIndex).notMatched.remove(reversedCharIndex);

                    if (windowList.get(windowIndex).notMatched.isEmpty()) {
                        stack.push(windowIndex);

                        for (int index : windowList.get(windowIndex).matched) {
                            if (!isReversedCharOfThisIndex[index]) {
                                reversedCharIndices.add(index);
                                isReversedCharOfThisIndex[index] = true;
                            }
                        }
                    }
                }
            }
        }

        for (boolean reversed : isReversedCharOfThisIndex) {
            if (!reversed) {
                return new int[0];
            }
        }

        int[] result = new int[stack.size()];
        int i = stack