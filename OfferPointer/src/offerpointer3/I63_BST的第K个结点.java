package offerpointer3;

/**
 * 2018��4��16�� @author jiayuanan
����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 */
import java.util.*;
public class I63_BST�ĵ�K����� {
	public static void main(String...args) {
		TreeNode root = new TreeNode(5);
		System.out.println(new Solution63().KthNode(root, 1));
	}
}

//˼·�������������������������˳���ӡ�������þ�������õ�˳��
//���ԣ������������˳���ҵ���k�������ǽ����


class TreeIterator {
	//�ǵݹ��������
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
        Stack<TreeNode> stack = new Stack<TreeNode>(); //ʹ��stackʵ�ַǵݹ�
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
        int[] count = new int[1]; //��λ
        TreeNode[] result = new TreeNode[1];//��¼���,������Ҫʹ�����飬��Ϊ�����ڷ������޷��ı������õĶ���
        KthNode(pRoot, k, count, result);
        return result[0];
    }
    
    //�ݹ�д�����������
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