The bug in the provided code is in the else statement of the category 1 condition. It wrongly adds 2 to the `removeEdge` count. It should only add 1 because removing the edge will maintain the connectivity. 

To fix it, we need to change `removeEdge += 2;` to `removeEdge += 1;` in the else statement of the category 1 condition.

Fixed code:
```java
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> {
            return b[0] - a[0];
        });//giving the priority to third type of edge or the edge which Bob and Alice both can access

        //1-based indexing of nodes 
        int[] parentAlice = new int[n + 1];//Graph 1 for Alice connectedness
        int[] parentBob = new int[n + 1];//Graph 2 for Bob connectedness

        for (int i = 0; i < n + 1; i++) {//every node is pointing to itself, at first no connection is considered all sets are independent(no dependency)
            parentAlice[i] = i;
            parentBob[i] = i;
        }

        //number of merged unique node for Alice and Bob that are required to maintain the connectedness of Alice and Bob graph nodes//intialised with one because merging happens in pair 
        int mergeAlice = 1;
        int mergeBob = 1;

        //number of cyclic or the non dependent node, that are not required for the connectedness of Alice and Bob nodes  
        int removeEdge = 0;

        for (int[] edge : edges) {
            int cat = edge[0];//category of edge 1)edge Alice can only access 2)edge Bob can only access 3)edge both Alice and Bob can access
            int u = edge[1];
            int v = edge[2];

            if (cat == 3) {//edge both Alice and Bob an access

                //creating dependency of nodes in graph 1 and 2 
                boolean tempAlice = union(u, v, parentAlice);
                boolean tempBob = union(u, v, parentBob);

                if (tempAlice == true)
                    mergeAlice += 1;

                if (tempBob == true)
                    mergeBob += 1;

                if (tempAlice == false && tempBob == false)//retund