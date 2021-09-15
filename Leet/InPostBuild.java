class InPostBuild{
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length, postLen = postorder.length;
        for (int i = 0; i<inLen; i++) {
        	if (inorder[i]==postorder[postLen-1]) {
        		TreeNode root = InPost(i, inorder, postorder);
        	}
        }
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