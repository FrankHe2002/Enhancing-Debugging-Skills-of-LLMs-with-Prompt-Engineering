class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0;
        int farthestSofar = 0;

        int xloc = 0;
        int yloc = 0;

        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        int steps;

        for (int i : commands) {

            if (i == - 1) {
                dir++;
            } else if (i == - 2) {
                dir--;
            } else {
                dir = dir % 4;
                if (dir == - 1) {
                    dir = 3;
                } else if (dir == - 3) {
                    dir = 1;
                } else if (dir == - 2) {
                    dir = 2;
                }
                if (dir == 0) {
                    steps = 0;
                    while (steps < i && ! set.contains((xloc) + "," + (yloc + 1))) {
                        yloc++;
                        steps++;
                    }
                } else if (dir == 1) {
                    steps = 0;
                    while (steps < i && ! set.contains((xloc + 1) + "," + (yloc))) {
                        xloc++;
                        steps++;
                    }
                } else if (dir == 2) {
                    steps = 0;
                    while (steps < i && ! set.contains((xloc) + "," + (yloc - 1))) {
                        yloc--;
                        steps++;
                    }
                } else {
                    steps = 0;
                    while (steps < i && ! set.contains((xloc - 1) + "," + (yloc))) {
                        xloc--;
                        steps++;
                    }
                }
            }
            farthestSofar = Math.max(farthestSofar, xloc * xloc + yloc * yloc);
        }
        return farthestSofar;
    }
}