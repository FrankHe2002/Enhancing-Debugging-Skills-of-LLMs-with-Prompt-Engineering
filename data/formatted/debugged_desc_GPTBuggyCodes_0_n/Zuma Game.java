```java
            for (int i = 0; i <= board.length(); i++) {
                String newBoard = new StringBuilder(board).insert(i, color).toString();
                int removeCnt = remove(newBoard);
                if (removeCnt > 0) {
                    int next = findMinStep(newBoard, nextHand, remainingDepth - 1);
                    if (next >= 0) {
                        if (minStep == -1) {
                            minStep = next + 1;
                        } else {
                            minStep = Math.min(minStep, next + 1);
                        }
                    }
                }
            } 
        }
        boardHandToMinStep.put(key, minStep);
        return minStep;
    }
    
    private int remove(String board) {
        for (int i = 0; i < board.length(); i++) {
            int j = i;
            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                return j - i;
            }
        }
        return 0;
    }
    
    private String resolve(String board) {
        int removeCnt = - 1;
        while (removeCnt != 0) {
            removeCnt = remove(board);
            if (removeCnt > 0) {
                StringBuilder newBoard = new StringBuilder();
                for (int i = 0, j = 0; i < board.length(); i++) {
                    if (i == j) {
                        while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                            j++;
                        }
                        if (j - i >= 3) {
                            i = j - 1;
                        } else {
                            newBoard.append(board.charAt(i));
                        }
                    }
                }
                board = newBoard.toString();
            }
        }
        return board;
    }
    
    private boolean canWin(String board, Hand hand) {
        Set<Character> colors = new HashSet<>();
        for (char c : board.toCharArray()) {
            colors.add(c);
        }
        for (String color : hand.colors()) {
            colors.add(color.charAt(0));
        }
        for (char c : colors) {
            Hand nextHand = new Hand(hand);
            String b = board + c;
            remove(b);
            if (b.length() == board.length()) {
                continue;
            }
            nextHand.removeColor(String.valueOf(c));
            if (findMinStep(b, nextHand, 5) > 0) {
                return true;
            }
        }
        return false;
    }
}
```