package offerpointer1;

/**
 * 2018年3月21日 @author jiayuanan
 * item18:树的子结构
 * 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */




class Solution18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean result = false;
    	if(root1 != null && root2 != null) {  //开始if写成while了，调试发现错误
    		//若根结点值相同，进行对比判断
    		if(root1.val == root2.val) {
    			result = compareSubTree(root1, root2);
    		}
    			
    		//若上述判断为false，继续判断树A的左子树和B
    		if(!result)
    			result = HasSubtree(root1.left,root2);
    		//换成A的右子树
    		if(!result)
    			result = HasSubtree(root1.right,root2);
    	}
    	return result;
    }
    
    public boolean compareSubTree(TreeNode root1, TreeNode root2) {
    	//这里，初始root1和root2都不为null
    	//比到这里，所以上述都相同，返回true
    	if(root2 == null)
    		return true;
    	//说明root2对应的非null，root1对应的null，返回false
    	if(root1 == null)
    		return false;
    	if(root1.val != root2.val)   //值都不等，直接返回false
    		return false;
    	//递归比较，左子树和右子树分别比较
    	return compareSubTree(root1.left,root2.left) && compareSubTree(root1.right,root2.right);
    }
}



public class I18_树的子结构 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		TreeNode rootB = new TreeNode(8);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(2);
		rootB.left = node7;
		rootB.right = node8;
		System.out.println(new Solution18().HasSubtree(rootA, rootB));
	}

}
