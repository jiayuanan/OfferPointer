package ch6differentAblities;

/**
 * 2018年3月27日 @author jiayuanan
 * item58: 二叉树的下一结点
 * 问题描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class Solution58 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
        	return null;
        
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class I58_nextNodeInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
