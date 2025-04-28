package algo.interview.zz_concept.union_find;

public class UnionFind {

    public static class Node {
        int key;
        Node parent;
        int rank = 0;

        public Node(int key) {
            this.key = key;
            this.parent = this;
        }
    }

    public static Node makeSet(int key) {
        return new Node(key);
    }

    public static Node find(Node node) {
        while(node.parent != node) {
            node = node.parent;
        }
        return node;
    }

    public static void union(Node nodeX, Node nodeY) {
        Node nodeV = find(nodeX), nodeW = find(nodeY);
        // 교환 방식
        if (nodeV.rank > nodeW.rank) {
            Node tmp;
            tmp = nodeV;
            nodeV = nodeW;
            nodeW = tmp;
        }
        nodeV.parent = nodeW;

        if (nodeV.rank == nodeW.rank) nodeW.rank++;

    }

    public static void main(String[] args) {
        Node a = makeSet(1);
        Node b = makeSet(2);
        Node c = makeSet(3);
        Node d = makeSet(4);
        Node e = makeSet(5);
        union(a, b);
        // System.out.println(find(a).key);
        union(a, c);
        // System.out.println(find(a).key);
        union(d, e);
        // System.out.println(find(a).key);
        union(c, d);
        // System.out.println(find(a).key);
    }

}
