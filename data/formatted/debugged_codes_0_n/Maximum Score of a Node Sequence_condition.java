```java
// Runtime: 25 ms (Top 99.80%) | Memory: 131.6 MB (Top 18.36%)
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;

        int[][] count = new int[n][6];
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            if (count[s][0] == 0) {
                count[s][1] = e;
                count[s][0] = scores[e];
            } else if (count[s][2] == 0) {
                if (scores[e] > count[s][0]) {
                    count[s][3] = count[s][1];
                    count[s][2] = count[s][0];
                    count[s][1] = e;
                    count[s][0] = scores[e];
                } else {
                    count[s][3] = e;
                    count[s][2] = scores[e];
                }
            } else if (scores[e] > count[s][4]) {
                if (scores[e] > count[s][0]) {
                    count[s][5] = count[s][3];
                    count[s][4] = count[s][2];
                    count[s][3] = count[s][1];
                    count[s][2] = count[s][0];
                    count[s][1] = e;
                    count[s][0] = scores[e];
                } else if (scores[e] > count[s][2]) {
                    count[s][5] = count[s][3];
                    count[s][4] = count[s][2];
                    count[s][3] = e;
                    count[s][2] = scores[e];
                } else {
                    count[s][5] = e;
                    count[s][4] = scores[e];
                }
            }
            if (count[e][0] == 0) {
                count[e][1] = s;
                count[e][0] = scores[s];
            } else if (count[e][2] == 0) {
                if (scores[s] > count[e][0]) {
                    count[e][3] = count[e][1];
                    count[e][2] = count[e][0];
                    count[e][1] = s;
                    count[e][0] = scores[s];
                } else {
                    count[e][