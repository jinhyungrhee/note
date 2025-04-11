package algo.interview.z_leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidBinarySearchTree98 {

    /**
     * Definition for a binary tree node.
     */
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

    public static List<Integer> orderedList = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left =  new TreeNode(1);
        root.right =  new TreeNode(4);
        root.right.left =  new TreeNode(3);
        root.right.right =  new TreeNode(6);

        System.out.println(isValidBST(root));

    }

    public static boolean isValidBST(TreeNode root) {

        // Method 1 - recursive DFS
//         dfs(root);
//         System.out.println(orderedList);
//
//         if (orderedList.isEmpty()) return false;
//         for (int i = 0; i < orderedList.size() - 1; i++) {
//             if (orderedList.get(i) >= orderedList.get(i + 1)) return false;
//         }
//         return true;

        // Method 2 - iterative DFS
        inorderTraversal(root);
        System.out.println(orderedList);

        if (orderedList.isEmpty()) return false;
        for (int i = 0; i < orderedList.size() - 1; i++) {
            if (orderedList.get(i) >= orderedList.get(i + 1)) return false;
        }
        return true;

        // Method 3 - 잘못된 큐 사용 (DFS이긴 하지만 queue 자료구조 특성상 뒤에서부터 탐색함)
//        iterativeDFS(root);
//        System.out.println(orderedList);
//
//        if (orderedList.isEmpty()) return false;
//        for (int i = 0; i < orderedList.size() - 1; i++) {
//            if (orderedList.get(i) >= orderedList.get(i + 1)) return false;
//        }
//        return true;

    }

    public static void dfs(TreeNode node) {
        if (node == null) return;

        if (node.left != null) dfs(node.left);
        // 저장 위치를 어디에 두느냐에 따라 순회 방식이 결정
        orderedList.add(node.val); // in-order (중위 순회 방식)
        if (node.right != null) dfs(node.right);

    }

    public static void inorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            // 1. 왼쪽 노드를 계속해서 스택에 push
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. 왼쪽 끝에 도달하면 스택에서 꺼내서 방문
            current = stack.pop();
            orderedList.add(current.val);

            // 3. 오른쪽 노드로 이동
            current = current.right;
        }
    }
    /**
     * Q. 오른쪽 노드는 계속해서 스택에 넣어주는 작업이 필요없는 이유?
     * A.[3.오른쪽 노드로 이동] 부분이 결국 오른쪽 sub-tree로 이동하는 것
     *   while()문 안에서 반복적으로 오른쪽 sub-tree에 대해서 1-2-3 과정을 반복하게 된다!
     */

    public static void iterativeDFS(TreeNode node) {

        List<Integer> visited = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.push(node);
        while (!queue.isEmpty()) {

            TreeNode v = queue.pop();
            orderedList.add(v.val);

            if (!visited.contains(v)) {

                if (v.left != null) {
                    visited.add(v.left.val);
                    queue.push(v.left);
                }

                if (v.right != null){
                    visited.add(v.right.val);
                    queue.push(v.right);
                }
            }

        }
    }

}