```java
            for (int i = 0; i <= board.length(); i++) {
                // try to insert the color in each *effective* location
                String newBoard = board.substring(0, i) + color + board.substring(i);
                // resolve the board
                String resolvedBoard = resolve(newBoard);
                
                // if inserting to that location finishes the game, return 1
                if (resolvedBoard.length() == 0) {
                    return 1;
                }
                
                // recur to the resulting hand
                int step = findMinStep(resolvedBoard, nextHand, remainingDepth - 1);
                
                // if the step is valid and it's smaller than the current minStep, update minStep
                if (step != -1 && (minStep == -1 || step < minStep)) {
                    minStep = step;
                }
            }
        }
        
        // if minStep is still -1, set it to -1 to indicate no valid step
        if (minStep == -1) {
            minStep = -1;
        }
        
        // memoize minStep
        boardHandToMinStep.put(key, minStep);
        
        // return minStep
        return minStep;
    }

    private String resolve(String board) {
        StringBuilder sb = new StringBuilder(board);
        boolean hasResolved = true;
        
        while (hasResolved) {
            hasResolved = false;
            int start = 0;
            
            for (int i = 0; i <= sb.length(); i++) {
                if (i == sb.length() || sb.charAt(i) != sb.charAt(start)) {
                    if (i - start >= 3) {
                        sb.delete(start, i);
                        hasResolved = true;
                    }
                    start = i;
                }
            }
        }
        
        return sb.toString();
    }

    // helper to check if there are enough balls in the board and hand for each color
    private boolean canWin(String board, Hand hand) {
        Set<String> colors = new HashSet<>();
        for (char c : board.toCharArray()) {
            colors.add(String.valueOf(c));
        }

        for (String color : colors) {
            int boardCount = countBalls(board, color);
            int handCount = countBalls(hand, color);

            if (boardCount + handCount < 3) {
                return false;
            }
        }

        return true;
    }

    // helper to count