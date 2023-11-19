// Runtime: 1091 ms (Top 50.54%) | Memory: 147.1 MB (Top 58.06%)
class Solution {
    static class Hand {
        int red;
        int yellow;
        int green;
        int blue;
        int white;

        Hand(String hand) {
            // add an extra character, because .split() throws away trailing empty strings
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

    /**
     * key = hand + ":" + board
     */
    private final Map<String, Integer> boardHandToMinStep = new HashMap<>();

    /**
     * store hand in a custom object; eases work and memoization (handles equivalency of reordered hand)
     * for each color in your hand:
     * try to insert the color in each *effective* location
     * - effective location means "one preceding a same-color set of balls"; in other words: "a location to the left of a same-color ball AND NOT to the right of a same-color ball"
     * resolve the board
     * if inserting to that location finishes the game, return 1
     * otherwise, recur to the resulting hand
     * minstep for this setup == minimum of all resulting hands + 1
     * memoize this minstep, then return it
     */
    public int findMinStep(String board, String hand) {
        // store hand in a custom object; eases work and memoization (handles equivalency of reordered hand)
        Hand h = new Hand(hand);
        return findMinStep(board, h, 9999);
    }

    private int findMinStep(String board, Hand hand, int remainingDepth) {
        // resolve board, i.e. remove triples and higher
        board = resolve(board);
        final String key = hand.buildStringWithColon().append(board).toString();
        if (board.length() == 0) {
            return 0;
        } else if (boardHandToMinStep.containsKey(key)) {
            return boardHandToMinStep.get(key);
        }

        // OPTIMIZATION #3 - reduced time by 25%
        // don't go deeper than the deepest known solution - 1
        if (remainingDepth <= 0
                // OPTIMIZATION #2 - lowered from 1min to 4sec reduced time by 93%
                // for each color in the board, if there are ever fewer than three of that color in the board and hand combined, fast fail
                || ! canWin(board, hand)) {
            boardHandToMinStep.put(key, - 1);
            return - 1;
        }

        int minStep = - 1;
        // for each color in your hand:
        for (String color : hand.colors()) {
            // Store a new "next hand" and remove the color
            Hand nextHand = new Hand(hand);
            nextHand.removeColor(color);
            // for each *effective* insert location