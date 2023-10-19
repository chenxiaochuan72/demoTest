package leetcode;



public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(2);
        root.left=new TreeNode1(2);
        root.left.left=new TreeNode1(2);
        System.out.println(new 验证二叉搜索树().isValidBST(root));
    }

    private int maxValue = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode1 root) {
        if (root == null) {
            return true;
        }
        boolean rootLeft = isValidBST(root.left);
        if (root.val >= maxValue) {
            maxValue = root.val;
        } else {
            return false;
        }
        boolean rootRight = isValidBST(root.right);
        return rootLeft && rootRight;
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
