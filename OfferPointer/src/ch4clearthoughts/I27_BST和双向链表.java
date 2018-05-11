package ch4clearthoughts;

/**
 * 2018��3��23�� @author jiayuanan
 * item27��������������˫������
 * ��������������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
//ʹ�ö��������������
class Solution27{
    TreeNode convertNode(TreeNode pNode, TreeNode pLastNodeInList){
        if(pNode == null)
            return null;
        TreeNode pCurrent = pNode;

        //�ݹ鴦��������
        if(pCurrent.left != null)
            pLastNodeInList = convertNode(pNode.left, pLastNodeInList);

        //����ǰ�ڵ�
        //����ǰ�ڵ����ָ��ָ���Ѿ�ת���õ���������һ��λ��
        pCurrent.left = pLastNodeInList;
        //���Ѿ�ת���õ���������һ���ڵ����ָ��ָ��ǰ�ڵ�
        if(pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;
        //�����Ѿ�ת���õ���������һ���ڵ�
        pLastNodeInList = pCurrent;

        //�ݹ鴦��������
        if(pCurrent.right != null)
            pLastNodeInList = convertNode(pNode.right, pLastNodeInList);
        return pLastNodeInList;
    }

    //����������
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        //�������������
        TreeNode pLastNodeInList = null;
        pLastNodeInList = convertNode(pRootOfTree, pLastNodeInList);

        //�ҵ�ת����������ͷ�ڵ�
        TreeNode pHead = pLastNodeInList ;
        while(pLastNodeInList != null && pLastNodeInList.left != null)
            pHead = pHead.left;

        //����ͷ�ڵ�
        return pHead;
    }

}

public  class I27_BST��˫������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
