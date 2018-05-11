package ch6differentAblities;

/**
 * 2018年4月16日 @author jiayuanan
 * I62_序列化二叉树.java
 * 
 */
public class I62_序列化二叉树 {

}

class Solution62 {
    
    String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        SerializeCore(root, sb);//递归实现
        return sb.toString();
    }
    //以前序遍历的方式序列化二叉树
    void SerializeCore(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');  //分隔符
        SerializeCore(root.left, sb);
        SerializeCore(root.right, sb);
    }
     
    int index = -1;
     
    TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return DeserializeCore(strs);
    }  
    //以前序遍历的顺序反序列化——注意index
    TreeNode DeserializeCore(String[] strs) {
        index++;
        if(!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);     
            root.val = Integer.parseInt(strs[index]);
            root.left = DeserializeCore(strs);
            root.right = DeserializeCore(strs);
            return root;
        }
        return null;
    }
}