package ch4clearthoughts;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2018年3月22日 @author jiayuanan
 * item25:二叉树中和为某一个值的路径
 * 问题描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
class Solution25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();  //存储结果
    	//异常输入处理
    	if(root == null)
    		return result;
    	//初始路径
    	ArrayList<Integer> path = new ArrayList<>();
    	//用递归实现路径查找
    	addPath(root, target, path, result);
    	
    	return result;
    		
    }
    
    public void addPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    	path.add(root.val);
    	boolean isLeaf = root.left == null && root.right == null;
    	//叶节点且符合条件则添加该路径
    	if(isLeaf && sum(path) == target) {
    		result.add(path);
    		return;
    	}
    	//若存在左子树，则继续计算，注意要创建新的path
    	if(root.left != null) {
    		ArrayList<Integer> leftPath = new ArrayList<>();
    		leftPath.addAll(path);
    		addPath(root.left, target, leftPath, result);
    	}
    	//若存在右子树，则继续计算，同上
    	if(root.right != null) {
    		ArrayList<Integer> rightPath = new ArrayList<>();
    		rightPath.addAll(path);
    		addPath(root.right, target, rightPath, result);
    	}
    }
    //路径求和
    public int sum(ArrayList<Integer> path) {
    	int sum = 0;
    	for(int index = 0; index < path.size(); ++index)
    		sum += path.get(index);
    	return sum;
    }
}


//牛客网的答案单一，正确的解法也算错
/*class MySolution25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	
    	ArrayList<Integer> path = new ArrayList<>();
    	//找到所有的路径，一个叶节点对应一条path
    	findAllPath(root, result, path);
    	System.out.println(result);
    	//删除路径中不符合条件的路径
    	Iterator<ArrayList<Integer>> iterator = result.iterator();
    	while(iterator.hasNext()) {
    		if(sum(iterator.next()) != target)
    			iterator.remove();
    	}
    	
        return result;
    }
    public int sum(ArrayList<Integer> path) {
    	int result = 0;
    	for(int index = 0; index < path.size(); ++index)
    		result += path.get(index);
    	return result;
    }
    
    public void findAllPath(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
    	if(root == null)
    		return;
    	
    	path.add(root.val);
    	
    	if(root.left == null && root.right == null) {
    		result.add(path);
    		return;
    	} 
    	//注意，下面2个if语句是可以同时存在的，所以不能写成if-else结构
    	if(root.right != null) {
    		//必须重新创建新的 链表，不然会指向同一条path
    		ArrayList<Integer> right = new ArrayList<Integer>();
    		right.addAll(path);
    		findAllPath(root.right, result, right);
    	} 
    	if (root.left != null) {
    		ArrayList<Integer> left = new ArrayList<Integer>();
    		left.addAll(path);
    		findAllPath(root.left, result, left);
    	}
    	if(root.left == null && root.right == null) {
    		result.add(path);
    		return;
    	} 
    }
}*/

public class I25_二叉树中和为某一个值的路径 {
	public static void main(String...args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(12);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		System.out.println(new Solution25().FindPath(node1, 22));
	}
}
