package ch6differentAblities;

/**
 * 2018年3月27日 @author jiayuanan
 * item59:对称的二叉树
 * 问题描述：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
class Solution59 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }
    
    boolean isSymmetrical(TreeNode leftNode, TreeNode rightNode) {
    	if(leftNode == null && rightNode == null)
    		return true;
    	if(leftNode == null || rightNode == null)
    		return false;
    	if(leftNode.val != rightNode.val)
    		return false;
    	//递归
    	return isSymmetrical(leftNode.left, rightNode.right) &&
    			isSymmetrical(leftNode.right, rightNode.left);
    }
}
public class I59_isSymmetrical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
