package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TestSolution solution=new TestSolution();
        solution.buildTree(inorder,postorder);

    }

}

class TestSolution {
//    Map<Integer, Integer> map;
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length );
//
//    }
//
//    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
//        if (inBegin >= inEnd || postBegin >= postEnd) {
//            return null;
//        }
//        int rootIndex = map.get(postorder[postEnd-1]); // 找到后序遍历最有一个节点就是根节点
//        TreeNode root = new TreeNode(inorder[rootIndex]);
//        int leftOfLeft = rootIndex - inBegin;
//        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + leftOfLeft);
//        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + leftOfLeft, postEnd - 1);
//        return root;
//    }
int[] inorder;
    int[] postorder;
    Map<Integer,Integer> map=new HashMap<>();
    int root_index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        root_index=postorder.length-1;
        return helper(0,inorder.length-1);

    }
    public TreeNode helper(int left,int right){
        if(left>right){
            return null;
        }
        // 确定根节点的值
        int root_val=postorder[root_index];
        TreeNode root=new TreeNode(root_val);
        // 查找根节点在中序数组的下标
        int index=map.get(root_val);
        root_index--;
        root.right=helper(index+1,right);
        root.left=helper(left,index-1);
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
