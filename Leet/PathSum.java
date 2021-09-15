public class PathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean left = returnLength(root.left, root.val, targetSum);
        boolean right = returnLength(root.right, root.val, targetSum);

        if (left || right) return true;
        return false;
    }

    public boolean returnLength(TreeNode root, int curLength, int targetSum){
    	int curSum = curLength + root.val;
    	if (curSum == targetSum && root.left==null && root.right == null) return true;
    	if (root.left == null && root.right == null) return false;
    	returnLength(root.left, curSum, targetSum);
    	returnLength(root.right, curSum, targetSum);

    	return false; 
    }
}

class TreeNode {
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