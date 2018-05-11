package 树;

/**
 * 2018年4月17日 @author jiayuanan
 * I1_树的深度.java
 * 1.树的最小深度
 * 2.树的最大深度
 */
public class I1_树的深度 {
	public static void main(String...args) {
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
		
		System.out.println(minDepth(rootA));
	}
	
	 //1.树的最大深度
	static int maxDepth(TreeNode node){
	    if(node==null){
	        return 0;
	    }
	    int left = maxDepth(node.left);
	    int right = maxDepth(node.right);
	    return Math.max(left,right) + 1;
	}
	
	//2.树的最小深度
	static int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }



}
