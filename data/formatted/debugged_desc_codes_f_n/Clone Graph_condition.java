```java
 /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;

//         now traverse for the adjacent nodes of root node
        for (Node n : node.neighbors) {
//             check whether that node is visited or not
//              if it is not visited, there must be null
            if (visited[n.val] == null) {
//                 so now if it not visited, create a new node
                Node newNode = new Node(n.val);
//                 add this node as the neighbor of the prev copied node
                copy.neighbors.add(newNode);
//                 make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
                dfs(n, newNode, visited);
            } else {
//                 if that node is already visited, retrieve that node from visited array and add it as the adjacent node of prev copied node
//                 THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
                copy.neighbors.add(visited[n.val]);
            }
        }

    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        dfs(node, copy, visited);
        return copy;
    }
}
```