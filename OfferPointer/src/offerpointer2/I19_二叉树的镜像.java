package offerpointer2;

/**
 * 2018��3��21�� @author jiayuanan
 * item19:�������ľ���
 * ��Ŀ���������������Ķ�����������任ΪԴ�������ľ���
 * ˼·����ͼ��֪�����ڴ����ӽڵ�Ľ�㣬���������ҽ�㼴��
 */

class Solution19 {
    public void Mirror(TreeNode root) {
    	//�ݹ�ⷨ
    	//����������
        if(root == null)
        	return;
        if(root.left == null && root.right == null)
        	return;
        //ʵ�ʲ��������������ҽ��
        swapLeftAndRight(root);
        //�ݹ�
        Mirror(root.left);
        Mirror(root.right);
    }
    
    public void swapLeftAndRight(TreeNode root) {
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    }
}
public class I19_�������ľ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
