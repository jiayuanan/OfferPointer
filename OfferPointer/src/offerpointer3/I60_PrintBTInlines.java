package offerpointer3;

import java.util.ArrayList;

/**
 * 2018��3��27�� @author jiayuanan
 * item60:�Ѷ�������ӡ�ɶ���
 * ��Ŀ��������ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
