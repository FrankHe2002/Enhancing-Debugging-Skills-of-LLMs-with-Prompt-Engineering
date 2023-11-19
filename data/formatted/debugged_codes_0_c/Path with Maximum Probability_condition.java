Bug Type: Logic Error

Reasoning:
1. The code aims to find the maximum probability of reaching the 'end' node from the 'start' node through a series of connected nodes.
2. The code initializes an adjacency list to represent the graph, where each node is connected to other nodes with a certain probability.
3. The code uses a PriorityQueue to visit the nodes in order of decreasing probability, updating the probabilities of reaching each node.
4. The bug lies in the comparison condition inside the 'while' loop, specifically the 'if' statement that checks if the current probability is greater than the probability already stored in the 'probs' array for a certain node.
5. The condition '(curr.prob) * (x.prob) < probs[x.to]' should actually be '(curr.prob) * (x.prob) > probs[x.to]'. The current code is updating the probability of reaching a node only if the product of the current probability and the edge probability is less than the stored probability. It should update the probability if it is greater than the stored probability.
6. This bug results in incorrect probability updates, leading to incorrect final probabilities and subsequently incorrect results.

Fix:
To fix the bug, we need to modify the condition in the 'if' statement from '<' to '>'.

```java
// Runtime: 82 ms (Top 52.25%) | Memory: 75.8 MB (Top 66.61%)
class Pair {
    int to;
    double prob;

    public Pair(int to, double prob) {
        this.to = to;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        //node,to node,probability
        double probs[] = new double[n];
        Arrays.fill(probs, 0.0);
        probs[start] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2.prob,