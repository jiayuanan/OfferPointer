package ch4clearthoughts;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2018��3��22�� @author jiayuanan
 * item25:�������к�Ϊĳһ��ֵ��·��
 * ��������������һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 */
class Solution25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();  //�洢���
    	//�쳣���봦��
    	if(root == null)
    		return result;
    	//��ʼ·��
    	ArrayList<Integer> path = new ArrayList<>();
    	//�õݹ�ʵ��·������
    	addPath(root, target, path, result);
    	
    	return result;
    		
    }
    
    public void addPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
    	path.add(root.val);
    	boolean isLeaf = root.left == null && root.right == null;
    	//Ҷ�ڵ��ҷ�����������Ӹ�·��
    	if(isLeaf && sum(path) == target) {
    		result.add(path);
    		return;
    	}
    	//����������������������㣬ע��Ҫ�����µ�path
    	if(root.left != null) {
    		ArrayList<Integer> leftPath = new ArrayList<>();
    		leftPath.addAll(path);
    		addPath(root.left, target, leftPath, result);
    	}
    	//����������������������㣬ͬ��
    	if(root.right != null) {
    		ArrayList<Integer> rightPath = new ArrayList<>();
    		rightPath.addAll(path);
    		addPath(root.right, target, rightPath, result);
    	}
    }
    //·�����
    public int sum(ArrayList<Integer> path) {
    	int sum = 0;
    	for(int index = 0; index < path.size(); ++index)
    		sum += path.get(index);
    	return sum;
    }
}


//ţ�����Ĵ𰸵�һ����ȷ�ĽⷨҲ���
/*class MySolution25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	
    	ArrayList<Integer> path = new ArrayList<>();
    	//�ҵ����е�·����һ��Ҷ�ڵ��Ӧһ��path
    	findAllPath(root, result, path);
    	System.out.println(result);
    	//ɾ��·���в�����������·��
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
    	//ע�⣬����2��if����ǿ���ͬʱ���ڵģ����Բ���д��if-else�ṹ
    	if(root.right != null) {
    		//�������´����µ� ������Ȼ��ָ��ͬһ��path
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

public class I25_�������к�Ϊĳһ��ֵ��·�� {
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
