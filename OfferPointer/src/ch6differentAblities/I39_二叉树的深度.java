package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item39:�����������
 * ��������������һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
class Solution39 {
    public int TreeDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return 1 + Math.max(TreeDepth(root.right), TreeDepth(root.left));
    }
}
public class I39_����������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
