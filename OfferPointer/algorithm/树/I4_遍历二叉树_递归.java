package 树;

/**
 * 2018年4月17日 @author jiayuanan
 * I4_遍历二叉树_递归.java
 * 
 */
import java.util.*;
public class I4_遍历二叉树_递归 {
	public static void main(String...args) {
		TreeNode node = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		node.left = node1; node.right = node2;
		node1.left = node3; node1.right = node4;
		node4.left = node5; node4.right = node6;
		
		postOrder(node);
	}
	
	
	
	//1.前序遍历
	public static void preOrder(TreeNode root) {
		if(root == null)
			return;
		ArrayList<Integer> list = new ArrayList<>();
		preOrderCore(root, list);
		System.out.println(list.toString());
	}
	
	public static void preOrderCore(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		list.add(root.val);
		preOrderCore(root.left, list);
		preOrderCore(root.right, list);
	}
	
	//2.中序遍历
	public static void midOrder(TreeNode root) {
		if(root == null)
			return;
		ArrayList<Integer> list = new ArrayList<>();
		midOrderCore(root, list);
		System.out.println(list);
	}
	public static void midOrderCore(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		midOrderCore(root.left, list);
		list.add(root.val);
		midOrderCore(root.right, list);
	}
	
	//3.后序遍历
	public static void postOrder(TreeNode root) {
		if(root == null)
			return;
		ArrayList<Integer> list = new ArrayList<Integer>();
		postOrderCore(root, list);
		System.out.println(list);
	}
	public static void postOrderCore(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		postOrderCore(root.left, list);
		postOrderCore(root.right, list);
		list.add(root.val);
	}
}
