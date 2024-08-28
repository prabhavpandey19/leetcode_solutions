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
    public static Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> oldVsNew = new HashMap<>();
        return dfs(node, oldVsNew);
    }

    private static Node dfs(Node node, Map<Node,Node> oldVsNew) {
        if (oldVsNew.containsKey(node)) {
            return oldVsNew.get(node);
        }
        ArrayList<Node> nodeList = new ArrayList<>();
        Node node1 = new Node(node.val,nodeList);
        oldVsNew.put(node,node1);
        for (Node ne: node.neighbors) {
            nodeList.add(dfs(ne, oldVsNew));
        }
        return node1;
    }


}