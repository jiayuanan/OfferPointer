package offerpointer1;

/**
 * 2018��3��21�� @author jiayuanan
 * item18:�����ӽṹ
 * ��Ŀ�������������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 */




class Solution18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean result = false;
    	if(root1 != null && root2 != null) {  //��ʼifд��while�ˣ����Է��ִ���
    		//�������ֵ��ͬ�����жԱ��ж�
    		if(root1.val == root2.val) {
    			result = compareSubTree(root1, root2);
    		}
    			
    		//�������ж�Ϊfalse�������ж���A����������B
    		if(!result)
    			result = HasSubtree(root1.left,root2);
    		//����A��������
    		if(!result)
    			result = HasSubtree(root1.right,root2);
    	}
    	return result;
    }
    
    public boolean compareSubTree(TreeNode root1, TreeNode root2) {
    	//�����ʼroot1��root2����Ϊnull
    	//�ȵ����������������ͬ������true
    	if(root2 == null)
    		return true;
    	//˵��root2��Ӧ�ķ�null��root1��Ӧ��null������false
    	if(root1 == null)
    		return false;
    	if(root1.val != root2.val)   //ֵ�����ȣ�ֱ�ӷ���false
    		return false;
    	//�ݹ�Ƚϣ����������������ֱ�Ƚ�
    	return compareSubTree(root1.left,root2.left) && compareSubTree(root1.right,root2.right);
    }
}



public class I18_�����ӽṹ {
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
