package ch6differentAblities;

/**
 * 2018年3月26日 @author jiayuanan
 * item39:二叉树的深度
 * 问题描述：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
class Solution39 {
    public int TreeDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return 1 + Math.max(TreeDepth(root.right), TreeDepth(root.left));
    }
}
public class I39_二叉树的深度 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
