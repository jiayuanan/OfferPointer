package ch4clearthoughts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2018年3月21日 @author jiayuanan
 * item23: 从上往下打印二叉树
 * 问题描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
class Solution23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        //异常输入处理
        if(root == null) 
        	return result;
        //用queue存放结点，实现先入先出
        Queue<TreeNode> node = new LinkedList<>();  //注意，这里Queue用LinkedList实现
       
        node.add(root);
        while(!node.isEmpty()) {
        	TreeNode forward = node.poll();
        	result.add(forward.val);
        	if(forward.left != null)
        		node.add(forward.left);
        	if(forward.right != null)
        		node.add(forward.right);
        }
        
        return result;
        
    }
}
public class I23_从上往下打印二叉树 {

	public static void main(String[] args) {
		TreeNode rootA = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		rootA.left = node1; rootA.right = node2;
		node1.left = node3; node1.right = node4;
		node4.left = node5; node4.right = node6;
		System.out.println(new Solution23().PrintFromTopToBottom(null));
	}

}
