package offerpointer2;


/**
 * 2018�?3�?21�? @author jiayuanan
 * 公用�?
 * 适用：item06,item18,item19,item23
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootA = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		rootA.left = node1; rootA.right = node2;
		node1.left = node3; node1.right = node4;
		node4.left = node5; node4.right = node6;
		
		TreeNode rootB = new TreeNode(8);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(2);
		rootB.left = node7;
		rootB.right = node8;
	}
}

/*链接：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5
来源：牛客网

方法�?：非递归�?
解题思路�?
1.核心是中序遍历的非�?�归算法�?
2.修改当前遍历节点与前�?遍历节点的指针指向�??
    import java.util.Stack;
    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上�?节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第�?个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }      
            p = p.right;
        }
        return root;
    }
方法二：递归�?
解题思路�?
1.将左子树构�?�成双链表，并返回链表头节点�?
2.定位至左子树双链表最后一个节点�??
3.如果左子树链表不为空的话，将当前root追加到左子树链表�?
4.将右子树构�?�成双链表，并返回链表头节点�?
5.如果右子树链表不为空的话，将该链表追加到root节点之后�?
6.根据左子树链表是否为空确定返回的节点�?
    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构�?�成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节�?
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构�?�成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;       
    }
方法三：改进递归�?
解题思路�?
思路与方法二中的递归版一致，仅对�?2点中的定位作了修改，新增�?个全�?变量记录左子树的�?后一个节点�??
    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节�?
    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null){
            leftLast = root;// �?后的�?个节点可能为�?右侧的叶节点
            return root;
        }
        // 1.将左子树构�?�成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节�?
        // 4.将右子树构�?�成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;       
    }*/