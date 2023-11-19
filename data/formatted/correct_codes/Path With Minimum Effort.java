class Tuple {

    int distance;

    int row;

    int col;


    Tuple(int distance, int row, int col) {

        this.distance = distance;

        this.row = row;

        this.col = col;

    }

}


class Solution {

    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);


        int rows = heights.length;

        int cols = heights[0].length;

        int effort[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            Arrays.fill(effort[i], Integer.MAX_VALUE);

        }


        effort[0][0] = 0;

        minHeap.add(new Tuple(0, 0, 0));

        int dr[] = {- 1, 0, 1, 0};

        int dc[] = {0, 1, 0, - 1};


        while (! minHeap.isEmpty()) {

            Tuple current = minHeap.poll();

            int distance = current.distance;

            int row = current.row;

            int col = current.col;


            if (row == rows - 1 && col == cols - 1) {

                return distance;

            }

            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];

                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {

                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), distance);

                    if (newEffort < effort[newRow][newCol]) {

                        effort[newRow][newCol] = newEffort;

                        minHeap.add(new Tuple(newEffort, newRow, newCol));

                    }

                }

            }

        }

        return 0;

    }

}

