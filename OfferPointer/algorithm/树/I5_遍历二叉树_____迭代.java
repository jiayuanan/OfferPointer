package 树;

/**
 * 2018年4月17日 @author jiayuanan
 * I5_遍历二叉树_____迭代.java
 * 
 */
import java.util.*;

import offerpointer2.ListNode;
public class I5_遍历二叉树_____迭代 {
	public static void main(String...args) {
		TreeNode node = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		node.left = node1; node.right = node2;
		node1.left = node3; node1.right = node4;
		node4.left = node5; node4.right = node6;
		
		//System.out.println(preOrder(node));
		System.out.println(postOrder(node));
	}
	
	
	
	//1.前序遍历
	public static ArrayList<Integer> preOrder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root == null)
			return list;
		//核心代码
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null)
				stack.add(node.right);   //注意，先压入右结点
			if(node.left != null)
				stack.add(node.left);
		}
		
		return list;
	}
	
	//2.中序遍历
	public static ArrayList<Integer> inOrder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root == null)
			return list;
		
		//核心部分
		TreeNode current = root;
		while(current != null|| !stack.empty()){
			//先找到左下的结点
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;           
        }
        return list;

	}
	
	//3.后序遍历:双栈法
	//https://blog.csdn.net/clam_clam/article/details/6845399
	public static ArrayList<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();    
        Stack<TreeNode> temp = new Stack<>(); 
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = root;    
        while (node != null || stack.size() > 0) {    
            while (node != null) {    
                temp.push(node);    
                stack.push(node);    
                node = node.right;    
            }    
            if (stack.size() > 0) {    
                node = stack.pop();    
                node = node.left;    
            }    
        }    
        while (temp.size() > 0) {//把插入序列都插入到了temp。  
            node = temp.pop();    
            //visit(node); 
            list.add(node.val);
        } 
        return list;
	}
}
