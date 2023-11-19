class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, int[]> seats = new HashMap<>();
        int availableSlots = 2 * n;

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            int[] slots = seats.getOrDefault(row, new int[3]);

            if (col >= 2 && col <= 5) {
                slots[0] = 1;
            }
            if (col >= 4 && col <= 7) {
                slots[1] = 1;
            }
            if (col >= 6 && col <= 9) {
                slots[2] = 1;
            }

            seats.put(seat[0], slots);
        }

        for (int[] slots : seats.values()) {
            int taken = slots[0] + slots[2];

            if (taken == 2) {
                if (slots[1] == 0) {
                    availableSlots--;
                 else{
                        availableSlots -= 2;
                    }
                } else if (taken == 1) {
                    availableSlots--;
                } else {
                    continue;
                }
            }

            return availableSlots;
        }
    }