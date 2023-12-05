```java
            int length = board.length();
            for (int i = 0; i <= length; i++) {
                StringBuilder sb = new StringBuilder(board);
                sb.insert(i, color);
                minStep = resolveMinStep(board, hand, remainingDepth, minStep, color, nextHand, length, sb.toString());
                if (minStep != -1) {
                    break;
                }
            }
        }
        boardHandToMinStep.put(key, minStep);
        return minStep;
    }

    private int resolveMinStep(String board, Hand hand, int remainingDepth, int minStep, String color, Hand nextHand, int length, String nextBoard) {
        int minStepNew;
        String prevBoard = board;
        if (prevBoard.equals(nextBoard)) {
            return -1;
        }
        boolean containsThreeOrMore = containsThreeOrMore(nextBoard);
        if (containsThreeOrMore) {
            nextBoard = resolve(nextBoard);
            Hand nextHandNew = new Hand(nextHand);
            nextHandNew.removeColor(color);
            int step = findMinStep(nextBoard, nextHandNew, remainingDepth - 1);
            if (step != - 1) {
                minStepNew = step + 1;
                if (minStep == - 1 || minStep > minStepNew) {
                    minStep = minStepNew;
                }
            }
        }
        return minStep;
    }

    private boolean containsThreeOrMore(String board) {
        char[] boardChars = board.toCharArray();
        int count = 1;
        for (int i = 1; i <= boardChars.length; i++) {
            if (boardChars[i] != boardChars[i - 1] || i == boardChars.length) {
                if (count >= 3) {
                    return true;
                }
                count = 1;
            } else {
                count++;
            }
        }
        return false;
    }

    private String resolve(String board) {
        int count;
        do {
            count = 0;
            char[] chars = board.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= chars.length; i++) {
                if (i == chars.length) {
                    if (count >= 3) {
                        board = sb.toString();
                    }
                } else if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                    sb.append(new String(new char[count < 3 ? count : 0]).replace("\0", String.valueOf(chars[i])));
                    count = 1;
                } else {
                    count++;
                    continue;
                }
                break;
            }
        } while (count != 0);
        return board;
    }

    private boolean canWin(String board, Hand hand) {
        int y = board.length();
        if (y == 0) {
            return true;
        }
        int x = hand.colors().size();
        switch (y) {
            case 1:
                return x >= 1;
            case 2:
                return x >= 2;
            case 3:
                return x >= 3;
            case 4:
                return x >= 4;
            default:
                return false;
        }
    }

}
```