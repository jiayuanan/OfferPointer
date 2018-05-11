package ��;

/**
 * 2018��4��17�� @author jiayuanan
 * I2_������.java
 * 1.�������Ľ�����
 * 2.��������Ҷ�ӽ�����
 * 3.�������е�k����ĸ���
 */
public class I2_������ {
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
		
		System.out.println(sumOfNodesinKth(node,5));
	}
	//1.�������Ľ�����
	static int sumOfNodes(TreeNode root) {
		if(root == null)
			return 0;  //�ݹ��˳�����
		
		return 1 + sumOfNodes(root.left) + sumOfNodes(root.right);
	}
	
	//2.��������Ҷ�ӽ�����
	static int sumOfLeaves(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;    //��������ΪҶ�ӽ��
		return sumOfLeaves(root.left) + sumOfLeaves(root.right);
	}
	//3.�������е�k����ĸ���
	static int sumOfNodesinKth(TreeNode root, int K) {
		if(root == null || K <= 0)
			return 0;
		return sumOfNodesinKthCore(root, 1, K);
	}
	
	static int sumOfNodesinKthCore(TreeNode root, int i, int K) {
		if(root == null || i > K)
			return 0;
		if(i == K) {
			int result = 0;
			if(root.left != null)
				++result;
			if(root.right != null)
				++result;
			return result;
		} else {
			return sumOfNodesinKthCore(root.left, i + 1, K) + sumOfNodesinKthCore(root.right, i + 1, K);
		}
	}
}
