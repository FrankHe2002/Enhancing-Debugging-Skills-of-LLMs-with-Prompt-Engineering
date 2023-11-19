```java
                // initialize insert index and inserted flag
                int insertIndex = 0;
                boolean inserted = false;

                // iterate over the board
                for (int i = 0; i <= board.length(); i++) {
                    // if the current position is the end of the board or the next character is different from the current color
                    if (i == board.length() || board.charAt(i) != color.charAt(0)) {
                        // get the substring from the insert index to the current position
                        String sub = board.substring(insertIndex, i);

                        // calculate the length of the substring
                        int len = i - insertIndex;

                        // if the length is less than 3 and the remaining depth is greater than or equal to 3 minus the length
                        if (len < 3 && remainingDepth >= 3 - len) {
                            // check if the color can be inserted at the current position
                            if (len == 0 || len == 1 || len == 2 && !sub.equals(color)) {
                                // insert the color at the current position
                                StringBuilder newBoard = new StringBuilder(board);
                                newBoard.insert(i, color);

                                // recursively find the minimum step for the new board and next hand
                                int steps = findMinStep(newBoard.toString(), nextHand, remainingDepth - (3 - len));

                                // update the minimum step if necessary
                                if (steps != -1) {
                                    if (minStep == -1 || steps + 1 < minStep) {
                                        minStep = steps + 1;
                                    }                                    
                                }
                            }
                        }
                        // update the insert index
                        insertIndex = i;
                    }
                }
                // remove color after iterated color not found in the board
                if (inserted) {
                    nextHand.removeColor(color);
                }
            }
        }
    return minStep;
    }

    // remove triples and higher
    private String resolve(String board) {
        boolean resolved;
        do {
            resolved = false;
            int start = -1;
            int count = 1;
            for (int i = 0; i <= board.length(); i++) {
                if (i < board.length() && board.charAt(i) == board.charAt(start)) {
                    count++;
                } else {
                    if (count >= 3) {
                        board = board.substring(0, start) + board.substring(i);
                        resolved = true;
                        break;
                    }
                   