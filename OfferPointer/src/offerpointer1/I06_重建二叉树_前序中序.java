package offerpointer1;

import java.util.HashMap;

//item6:�ؽ���������������ĳ��������ǰ�����������������ؽ��ö�����
//������   item6,18,24,25,39   ���Ž⡪��P171
public class I06_�ؽ�������_ǰ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode tree = new Solution6().reConstructBinaryTree(pre, in);
		System.out.println(tree.right.val);
	}

}
// http://blog.csdn.net/bryan__/article/details/52412615          CSDN���
class Solution6 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//�쳣�ж�
    	if(pre == null || in == null) {
    		return null;
    	}
    	//�洢�������ݣ�
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < in.length; ++i)
    		map.put(in[i], i);
        return reConstructCore(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }
    
    //�ݹ鴦��
    public static TreeNode reConstructCore(int[] pre, int preStart, int preEnd,
    		                               int[] in,  int inStart,  int inEnd, HashMap<Integer,Integer> map) {
    	//�ݹ��������
    	if(preStart > preEnd) {
    		return null;
    	}

    	TreeNode head = new TreeNode(pre[preStart]); //ǰ��ĵ�һ�����Ϊ���ڵ�
    	int rootIn = map.get(pre[preStart]);         //��ȡ���ڵ������������λ�ã��ٴεݹ飻
    	head.left = reConstructCore(pre, preStart + 1, preStart + rootIn - inStart,
    			                    in, inStart, rootIn-1, map);  //ע������ľ���ֵ
    	head.right = reConstructCore(pre, preStart + rootIn - inStart + 1, preEnd,
    			                    in, rootIn + 1, inEnd, map);
    	return head;
    	
    }
}

