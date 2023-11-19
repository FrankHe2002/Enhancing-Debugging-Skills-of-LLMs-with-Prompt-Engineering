class Solution {
    static class Hand {
        int red;
        int yellow;
        int green;
        int blue;
        int white;

        Hand(String hand) {
            String splitter = hand + "x";
            red = splitter.split("R").length - 1;
            yellow = splitter.split("Y").length - 1;
            green = splitter.split("G").length - 1;
            blue = splitter.split("B").length - 1;
            white = splitter.split("W").length - 1;
        }

        Hand(Hand hand) {
            red = hand.red;
            yellow = hand.yellow;
            blue = hand.blue;
            green = hand.green;
            white = hand.white;
        }

        boolean isEmpty() {
            return red == 0 && yellow == 0 && green == 0 && blue == 0 && white == 0;
        }

        List<String> colors() {
            List<String> res = new ArrayList<>();
            if (red > 0) res.add("R");
            if (yellow > 0) res.add("Y");
            if (green > 0) res.add("G");
            if (blue > 0) res.add("B");
            if (white > 0) res.add("W");
            return res;
        }

        void removeColor(String color) {
            switch (color) {
                case "R":
                    red--;
                    break;
                case "Y":
                    yellow--;
                    break;
                case "G":
                    green--;
                    break;
                case "B":
                    blue--;
                    break;
                case "W":
                    white--;
                    break;
            }
        }

        public StringBuilder buildStringWithColon() {
            return new StringBuilder().append(red)
                    .append(",")
                    .append(yellow)
                    .append(",")
                    .append(green)
                    .append(",")
                    .append(blue)
                    .append(",")
                    .append(white)
                    .append(":");
        }
    }

    private final Map<String, Integer> boardHandToMinStep = new HashMap<>();

    public int findMinStep(String board, String hand) {
        Hand h = new Hand(hand);
        return findMinStep(board, h, 9999);
    }

    private int findMinStep(String board, Hand hand, int remainingDepth) {
        board = resolve(board);
        final String key = hand.buildStringWithColon().append(board).toString();
        if (board.length() == 0) {
            return 0;
        } else if (boardHandToMinStep.containsKey(key)) {
            return boardHandToMinStep.get(key);
        }
        if (remainingDepth <= 0
                || ! canWin(board, hand)) {
            boardHandToMinStep.put(key, - 1);
            return - 1;
        }

        int minStep = - 1;
        for (String color : hand.colors()) {
            Hand nextHand = new Hand(hand);
            nextHand.removeColor(color);
            for (int loc : effectiveLocations(color, board, nextHand.isEmpty())) {
                String nextBoard = board.substring(0, loc) + color + board.substring(loc);
                int childMinStep = findMinStep(nextBoard, nextHand, minStep == - 1 ? remainingDepth - 1 : minStep - 2);
                if (childMinStep != - 1) {
                    minStep = minStep == - 1 ? (1 + childMinStep) : Math.min(minStep, 1 + childMinStep);
                }
            }
        }
        boardHandToMinStep.put(key, minStep);
        return minStep;
    }

    private boolean canWin(String board, Hand hand) {
        String splitter = board + "x";
        int red = splitter.split("R").length - 1;
        int yellow = splitter.split("Y").length - 1;
        int green = splitter.split("G").length - 1;
        int blue = splitter.split("B").length - 1;
        int white = splitter.split("W").length - 1;

        return (red == 0 || red + hand.red > 2)
                && (yellow == 0 || yellow + hand.yellow > 2)
                && (green == 0 || green + hand.green > 2)
                && (blue == 0 || blue + hand.blue > 2)
                && (white == 0 || white + hand.white > 2);
    }

    private List<Integer> effectiveLocations(String color, String board, boolean isLastInHand) {
        List<Integer> res = new ArrayList<>();
        List<Integer> greedy2 = new ArrayList<>();
        List<Integer> greedy3 = new ArrayList<>();
        for (int i = 0; i <= board.length(); i++) {
            if (i < board.length() - 1 && board.substring(i, i + 2).equals(color + color)) {
                res.add(i);
                i += 2;
            } else if (i < board.length() && board.substring(i, i + 1).equals(color)) {
                greedy2.add(i);
                i++;
            } else {
                if (i > 0 && board.length() > i && board.substring(i - 1, i).equals(board.substring(i, i + 1))) {
                    greedy3.add(i);
                }
            }
        }
        if (isLastInHand) {
            return res;
        }
        res.addAll(greedy2);
        res.addAll(greedy3);
        return res;
    }

    private String resolve(String board) {
        String copy = "";
        while (! board.equals(copy)) {
            copy = board;
            board = copy.replaceFirst("(.)\\1\\1+", "");
        }
        return board;
    }
}