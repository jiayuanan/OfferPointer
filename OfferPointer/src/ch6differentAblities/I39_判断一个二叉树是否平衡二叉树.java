package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item39:����������ж�һ���������Ƿ�ƽ�������
 * ���������������������������1
 */
class Solution39_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
        	return true; //intersting,�ݹ���Ҫ
        if(Math.abs(TreeDepth(root.right) - TreeDepth(root.left)) > 1)
        	return false;
        
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int TreeDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return 1 + Math.max(TreeDepth(root.right), TreeDepth(root.left));
    }
}
class IsBalanced {
    public boolean isBalanced2(TreeNode root){  
        int depth = 0;  
        return isBalanced2(root,depth);  
    }  
    public boolean isBalanced2(TreeNode root,int depth){  
        if(root == null){  
            depth = 0;  
            return true;  
        }  
        int left = 0,right = 0;  
        if(isBalanced2(root.left,left) && isBalanced2(root.right,right)){  
            if(Math.abs(left - right) <= 1){  
                depth = 1 + Math.max(left, right);  
                return true;  
            }  
        }  
        return false;  
    }  
}
public class I39_�ж�һ���������Ƿ�ƽ������� {

}
