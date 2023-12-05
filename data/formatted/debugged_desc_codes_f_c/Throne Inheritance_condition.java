The bug in the provided Java code is in the `preOreder` method of the `ThroneInheritance` class. In the `preOreder` method, there are multiple issues:

1. The condition `if (n != null) return;` should be `if (n == null) return;`. The current condition is incorrect and does not allow the traversal of the tree.

2. The condition `if (! death.contains(n.name))` should be `if (!death.contains(n.name))`. There should not be a space between the `!` operator and the set name. 

3. The return type of the `preOreder` method should be `void`, and the name should be `preOrder`, not `preOreder`.

To fix the code, these issues should be addressed. The corrections can be summarized as follows:

```java
class ThroneInheritance {
    // other methods and variables

    void preOrder(Tree n, List<String> ans, Set<String> death) {
        if (n == null) return;
        if (!death.contains(n.name)) ans.add(n.name);
        for (Tree child : n.child) {
            preOrder(child, ans, death);
        }
    }
}
```

After applying the fixes, the updated code is as follows:

```java
class Tree {
    List<Tree> child;
    String name;

    public Tree(String name, List<Tree> child) {
        this.name = name;
        this.child = child;
    }
}

class ThroneInheritance {
    private Set<String> death;
    private Tree tree;
    private Map<String, Tree> addtoTree;

    public ThroneInheritance(String kingName) {
        death = new HashSet<>();
        tree = new Tree(kingName, new ArrayList());
        addtoTree = new HashMap();
        addtoTree.put(kingName, tree);
    }

    public void birth(String parentName, String childName) {
        Tree tmp = addtoTree.get(parentName);
        Tree childtree = new Tree(childName, new ArrayList());
        tmp.child.add(childtree);
        addtoTree.put(childName, childtree);
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preOrder(tree, ans, death);
        return ans;
    }

    void preOrder(Tree n, List<String> ans, Set<String> death) {
        if (n == null) return;
        if (!death.contains(n.name)) ans.add(n.name);
        for (Tree child : n.child) {
            preOrder(child, ans, death);
        }
    }
}
```