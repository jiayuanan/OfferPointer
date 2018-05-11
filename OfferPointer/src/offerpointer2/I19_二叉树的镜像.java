package offerpointer2;

/**
 * 2018年3月21日 @author jiayuanan
 * item19:二叉树的镜像
 * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像
 * 思路：画图可知，对于存在子节点的结点，交换其左右结点即可
 */

class Solution19 {
    public void Mirror(TreeNode root) {
    	//递归解法
    	//结束的情形
        if(root == null)
        	return;
        if(root.left == null && root.right == null)
        	return;
        //实际操作——交换左右结点
        swapLeftAndRight(root);
        //递归
        Mirror(root.left);
        Mirror(root.right);
    }
    
    public void swapLeftAndRight(TreeNode root) {
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    }
}
public class I19_二叉树的镜像 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
