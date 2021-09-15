class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length, loc = 0;
        //System.out.println(Arrays.toString(inorder));
        //System.out.println(Arrays.toString(postorder));
        if(length == 0)return null;
        if(length == 1){
            System.out.println("Exe");
            return new TreeNode(inorder[0]);
        }
        TreeNode root = new TreeNode(postorder[length-1]);
        loc = find(postorder[length-1], inorder);
        //System.out.println("Location: "+ loc);
        int[] in = Arrays.copyOfRange(inorder,0,loc);
        int[] post = Arrays.copyOfRange(postorder,0,loc);
        root.left = buildTree(in, post);
        in = Arrays.copyOfRange(inorder,loc+1,length);
        post = Arrays.copyOfRange(postorder,loc,length-1);
        root.right = buildTree(in, post);
        return root;
    }
    
    public int find(int val, int[] inorder){
        int length = inorder.length;
        for(int i = 0; i<length; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}