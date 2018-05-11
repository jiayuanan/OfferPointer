package offerpointer2;

/**
 * 2018年3月22日 @author jiayuanan
 * item24：二叉搜索树的后序遍历序列
 * 
 */

class Solution24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length ==0)//后面一句开始忘记
        	return false;
        return VerifySequenceOfBST(sequence, 0, sequence.length);
    }
    
    public boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
    	//递归结束条件判断，相等说明为空，相差1说明为一个数字
    	if(start == end || end - start ==1)  //这两个条件缺一不可
    		return true;
    	//后序遍历的最后一个元素是root，遍历，比root小的为左子树，剩下的应该为右子树
    	//找到分界点，若分界点后边有数字小于root，则不为BST；满足条件，再递归判断其左子树和右子树是否为BST
    	int root = sequence[end - 1];
    	int division = start;
    	for(int index = start; index < end; ++index) {
    		if(sequence[index] < root)
    			++division;
    		else
    			break;
    	}
    	for(int index = division; index < end; ++index) {
    		if(sequence[index] < root)
    			return false;
    	}
    	//注意后面一个是end-1
    	return VerifySequenceOfBST(sequence, start, division) && VerifySequenceOfBST(sequence, division, end - 1);
    }
}
public class I24_二叉搜索树的后序遍历序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {5,7,6,9,11,10,8};
		System.out.println(new Solution24().VerifySquenceOfBST(test));

	}

}
