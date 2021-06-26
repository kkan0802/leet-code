package donaldAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeNode {
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

class Solution {
	
//617. Merge Two Binary Trees 
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

    	
    	TreeNode result_tree = null;
    	
    
    	if(root1 == null && root2 == null) {
    		result_tree = null;
    	} else if (root1 != null && root2 == null) {
    		result_tree = root1;
    	} else if (root1 == null && root2 != null) {
    		result_tree = root2;
    	} else if (root1 == null && root2 == null) {
    		int result_val =  root1.val + root2.val;
            TreeNode result_left = this.mergeTrees(root1.left,root2.left);
            TreeNode result_right = this.mergeTrees(root1.right,root2.right);
            
            result_tree = new TreeNode(result_val, result_left, result_right);
    	}
    	
    	return result_tree;
    }
    
//104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        int root_dep = 0;
        int left_dep = 0;
        int right_dep = 0;
        
        if(root == null){
            return 0;
        }else{
            root_dep = 1;
        }
        
        left_dep = this.maxDepth(root.left);
        right_dep = this.maxDepth(root.right);
        
        if(left_dep >= right_dep) root_dep += left_dep;
        else root_dep += right_dep;
        
        return root_dep;
    }
    
//226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        TreeNode ivtTree;
        if(root == null) {
            ivtTree = root;
        }else {
            ivtTree = new TreeNode(root.val, this.invertTree(root.right), this.invertTree(root.left));
        }
        
        return ivtTree;
    }
    
//94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
    	if(root == null) return ans;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	if(left != null) ans.addAll(this.inorderTraversal(root.left));
    	ans.add(root.val);
    	if(right != null) ans.addAll(this.inorderTraversal(root.right));

        return ans;
    }
    
//543. Diameter of Binary Tree
    
    /*
    public int maxDepth(TreeNode root) {
        int root_dep = 0;
        int left_dep = 0;
        int right_dep = 0;
        
        if(root == null){
            return 0;
        }else{
            root_dep = 1;
        }
        
        left_dep = this.maxDepth(root.left);
        right_dep = this.maxDepth(root.right);
        
        if(left_dep >= right_dep) root_dep += left_dep;
        else root_dep += right_dep;
        
        return root_dep;
    }
    */
    public int subDiameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root.left;
    	TreeNode right = root.right;
    	return this.maxDepth(left) + this.maxDepth(right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int top = this.subDiameterOfBinaryTree(root);
        int left = this.diameterOfBinaryTree(root.left);
        int right = this.diameterOfBinaryTree(root.right);
        if(top >= left && top >= right){
            return top;
        }else if(left >= top && left >= right){
            return left; 
        }else if(right >= top && right >= left){
            return right;
        }else {
            return top;
        }
    }
}
