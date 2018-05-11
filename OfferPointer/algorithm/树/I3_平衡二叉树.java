package ��;

/**
 * 2018��4��17�� @author jiayuanan
 * I3_ƽ�������.java
 * 
 */
public class I3_ƽ������� {
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
		
		System.out.println(isBalanced(node));
	}
	
	
	//1.�ж��Ƿ�Ϊƽ�������������������������ΪBST����������������Ȳ����1
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right) && Math.abs(Depth(root.left) - Depth(root.right)) <= 1;
	}
	
	public static int Depth(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(Depth(root.left), Depth(root.right));
	}
}
