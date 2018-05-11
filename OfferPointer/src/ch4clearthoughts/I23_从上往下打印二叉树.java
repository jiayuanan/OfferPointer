package ch4clearthoughts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2018��3��21�� @author jiayuanan
 * item23: �������´�ӡ������
 * �����������������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 */
class Solution23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        //�쳣���봦��
        if(root == null) 
        	return result;
        //��queue��Ž�㣬ʵ�������ȳ�
        Queue<TreeNode> node = new LinkedList<>();  //ע�⣬����Queue��LinkedListʵ��
       
        node.add(root);
        while(!node.isEmpty()) {
        	TreeNode forward = node.poll();
        	result.add(forward.val);
        	if(forward.left != null)
        		node.add(forward.left);
        	if(forward.right != null)
        		node.add(forward.right);
        }
        
        return result;
        
    }
}
public class I23_�������´�ӡ������ {

	public static void main(String[] args) {
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
		System.out.println(new Solution23().PrintFromTopToBottom(null));
	}

}
