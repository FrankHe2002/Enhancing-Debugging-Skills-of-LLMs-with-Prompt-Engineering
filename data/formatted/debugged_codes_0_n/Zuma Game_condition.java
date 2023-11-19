```java
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
            this.red = hand.red;
            this.yellow = hand.yellow;
            this.green = hand.green;
            this.blue = hand.blue;
            this.white = hand.white;
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
     * store hand in a custom object; eases work and memoization