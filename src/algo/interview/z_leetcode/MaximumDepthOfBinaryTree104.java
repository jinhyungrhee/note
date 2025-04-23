package algo.interview.z_leetcode;

public class MaximumDepthOfBinaryTree104 {

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    public static int maxVal;

    public static void main(String[] args) {

        // case1
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);

        // case2
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);

        dfs(root, 0);
        System.out.println(maxVal);
    }

    public static void dfs(TreeNode node, int step) {

        if (node == null) {
            if (maxVal < step) maxVal = step;
            return;
        }

        dfs(node.left, step + 1);
        dfs(node.right, step + 1);
    }
}
