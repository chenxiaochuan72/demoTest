package leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        solution.buildTree();
    }

}

class Solution {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        // 中序数组根节点下表
        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int leftIndex = rootIndex - inBegin;
        // 左中序，左后序
        root.left = build(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + leftIndex);
        // 右中序，右后序
        root.right = build(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + leftIndex, postEnd - 1);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}