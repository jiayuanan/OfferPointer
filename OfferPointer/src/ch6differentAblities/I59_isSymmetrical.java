package ch6differentAblities;

/**
 * 2018��3��27�� @author jiayuanan
 * item59:�ԳƵĶ�����
 * ������������ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
    	//�ݹ�
    	return isSymmetrical(leftNode.left, rightNode.right) &&
    			isSymmetrical(leftNode.right, rightNode.left);
    }
}
public class I59_isSymmetrical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
