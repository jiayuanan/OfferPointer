package 树;

/**
 * 2018年4月17日 @author jiayuanan
 * I2_结点个数.java
 * 1.二叉树的结点个数
 * 2.二叉树的叶子结点个数
 * 3.二叉树中第k层结点的个数
 */
public class I2_结点个数 {
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
	//1.二叉树的结点个数
	static int sumOfNodes(TreeNode root) {
		if(root == null)
			return 0;  //递归退出条件
		
		return 1 + sumOfNodes(root.left) + sumOfNodes(root.right);
	}
	
	//2.二叉树的叶子结点个数
	static int sumOfLeaves(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;    //此情形下为叶子结点
		return sumOfLeaves(root.left) + sumOfLeaves(root.right);
	}
	//3.二叉树中第k层结点的个数
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
