package offerpointer3;

import java.util.ArrayList;

/**
 * 2018年3月27日 @author jiayuanan
 * item60:把二叉树打印成多行
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
class Solution60 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(pRoot == null)
    		return result;
    	
    	ArrayList<Integer> line = new ArrayList<>();
    	line.add(pRoot.val);
    	result.add(line);
    	
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    }

}
public class I60_PrintBTInlines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
