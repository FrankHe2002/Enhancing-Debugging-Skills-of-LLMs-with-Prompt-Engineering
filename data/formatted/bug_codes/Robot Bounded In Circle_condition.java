class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() != 0) {
            return true;
        }

        Robot bender = new Robot();
        int[] start = new int[] {0, 0};
        for (int i = 0; i < 4; i++) {
            boolean orientationChanged = bender.performSet(instructions);

            int[] location = bender.location;
            if (location[0] == start[0] && location[1] == start[1]) {
                return true;
            } else if (! orientationChanged) {
                return false;
            }
        }

        return false;
    }
}

class Robot {
    int[] location;
    int[] orientation;
    int[][] orientations;
    int orientationPos;
    boolean orientationChangeCheck;

    Robot() {
        location = new int[] {0, 0};
        orientations = new int[][] {{1, 0}, {0, 1}, {- 1, 0}, {0, - 1}};
        orientationPos = 0;
        orientation = orientations[orientationPos];
        orientationChangeCheck = false;
    }

    public boolean performSet(String orders) {
        this.orientationChangeCheck = false;

        for (int i = 0; i < orders.length(); i++) {
            this.perform(orders.charAt(i));
        }

        return this.orientationChangeCheck;
    }

    public void perform(char order) {
        if (order == 'G') {
            this.go();
        } else if (order == 'L' || order == 'R') {
            this.turn(order);
        } else {
        }
    }

    public void turn(char direction) {
        if (direction == 'L') {
            this.orientationPos = this.orientationPos == 0 ? 3 : this.orientationPos - 1;
        } else if (direction == 'R') {
            this.orientationPos = (this.orientationPos + 1) % 4;
        }

        this.orientation = this.orientations[this.orientationPos];
        this.orientationChangeCheck = true;
    }

    public int[] go() {
        this.location[0] += this.orientation[0];
        this.location[1] += this.orientation[1];
        return this.location;
    }
}