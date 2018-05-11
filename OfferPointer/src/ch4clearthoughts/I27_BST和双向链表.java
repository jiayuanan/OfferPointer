package ch4clearthoughts;

/**
 * 2018年3月23日 @author jiayuanan
 * item27：二叉搜索树与双向链表
 * 问题描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
//使用二叉树的中序遍历
class Solution27{
    TreeNode convertNode(TreeNode pNode, TreeNode pLastNodeInList){
        if(pNode == null)
            return null;
        TreeNode pCurrent = pNode;

        //递归处理左子树
        if(pCurrent.left != null)
            pLastNodeInList = convertNode(pNode.left, pLastNodeInList);

        //处理当前节点
        //将当前节点的左指针指向已经转换好的链表的最后一个位置
        pCurrent.left = pLastNodeInList;
        //将已经转换好的链表的最后一个节点的右指针指向当前节点
        if(pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;
        //更新已经转换好的链表的最后一个节点
        pLastNodeInList = pCurrent;

        //递归处理右子树
        if(pCurrent.right != null)
            pLastNodeInList = convertNode(pNode.right, pLastNodeInList);
        return pLastNodeInList;
    }

    //处理主程序
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        //处理二叉搜索树
        TreeNode pLastNodeInList = null;
        pLastNodeInList = convertNode(pRootOfTree, pLastNodeInList);

        //找到转换后的链表的头节点
        TreeNode pHead = pLastNodeInList ;
        while(pLastNodeInList != null && pLastNodeInList.left != null)
            pHead = pHead.left;

        //返回头节点
        return pHead;
    }

}

public  class I27_BST和双向链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
