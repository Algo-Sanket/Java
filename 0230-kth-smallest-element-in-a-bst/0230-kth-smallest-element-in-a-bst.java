/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
 {
    public int kthSmallest(TreeNode root, int k) 
    {
        TreeNode p = root;
        while (p != null) 
        {
            TreeNode p2 = p.left;
            if (p2 != null) 
            {
                while (p2.right != null && p2.right != p) 
                {
                    p2 = p2.right;
                }
                if (p2.right == null) 
                {
                    p2.right = p;
                    p = p.left;
                    continue;
                } else 
                {
                    p2.right = null;
                }
            }
            if (k == 1) 
            {
                return p.val;
            }
            k--;
            p = p.right;
        }
        return Integer.MIN_VALUE;
    }
}
      
                