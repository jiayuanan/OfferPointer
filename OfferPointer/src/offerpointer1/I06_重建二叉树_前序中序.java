package offerpointer1;

import java.util.HashMap;

//item6:重建二叉树——输入某二叉树的前序遍历和中序遍历，重建该二叉树
//关联：   item6,18,24,25,39   最优解——P171
public class I06_重建二叉树_前序中序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode tree = new Solution6().reConstructBinaryTree(pre, in);
		System.out.println(tree.right.val);
	}

}
// http://blog.csdn.net/bryan__/article/details/52412615          CSDN题解
class Solution6 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	//异常判断
    	if(pre == null || in == null) {
    		return null;
    	}
    	//存储中序数据；
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < in.length; ++i)
    		map.put(in[i], i);
        return reConstructCore(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }
    
    //递归处理
    public static TreeNode reConstructCore(int[] pre, int preStart, int preEnd,
    		                               int[] in,  int inStart,  int inEnd, HashMap<Integer,Integer> map) {
    	//递归结束条件
    	if(preStart > preEnd) {
    		return null;
    	}

    	TreeNode head = new TreeNode(pre[preStart]); //前序的第一个结点为根节点
    	int rootIn = map.get(pre[preStart]);         //获取根节点在中序遍历中位置，再次递归；
    	head.left = reConstructCore(pre, preStart + 1, preStart + rootIn - inStart,
    			                    in, inStart, rootIn-1, map);  //注意参数的具体值
    	head.right = reConstructCore(pre, preStart + rootIn - inStart + 1, preEnd,
    			                    in, rootIn + 1, inEnd, map);
    	return head;
    	
    }
}

