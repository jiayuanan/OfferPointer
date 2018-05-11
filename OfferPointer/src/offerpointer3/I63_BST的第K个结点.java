package offerpointer3;

/**
 * 2018年4月16日 @author jiayuanan
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
import java.util.*;
public class I63_BST的第K个结点 {
	public static void main(String...args) {
		TreeNode root = new TreeNode(5);
		System.out.println(new Solution63().KthNode(root, 1));
	}
}

//思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
//所以，按照中序遍历顺序找到第k个结点就是结果。


class TreeIterator {
	//非递归中序遍历
	public static void MediumOrder(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		do {
			if(node != null) {
				stack.add(node);
				node = node.left;
			} else {
				node = stack.pop();
				node = node.right;
			}
		} while(node != null || !stack.isEmpty());
	}
}
class Solution63 {
	TreeNode KthNode(TreeNode root, int k){
        if(root==null||k==0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>(); //使用stack实现非递归
        int count = 0;
        TreeNode node = root;
        do{
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }while(node!=null||!stack.isEmpty());
        return null;
    }
}






/*class Solution63 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        int[] count = new int[1]; //定位
        TreeNode[] result = new TreeNode[1];//记录结果,这里需要使用数组，若为对象，在方法中无法改变其引用的对象
        KthNode(pRoot, k, count, result);
        return result[0];
    }
    
    //递归写法，中序遍历
     void KthNode(TreeNode pRoot, int k,int[] count,TreeNode[] result) {
         if(result[0] != null || pRoot == null)
             return;
         KthNode(pRoot.left, k, count, result);
         count[0]++;
         if(count[0] == k) {
        	 result[0] = pRoot;
        	// System.out.println(k);
        	 //System.out.println(result[0].val);
         }
             
         KthNode(pRoot.right, k, count, result);
     }
}*/