package ch6differentAblities;

/**
 * 2018��4��16�� @author jiayuanan
 * I62_���л�������.java
 * 
 */
public class I62_���л������� {

}

class Solution62 {
    
    String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        SerializeCore(root, sb);//�ݹ�ʵ��
        return sb.toString();
    }
    //��ǰ������ķ�ʽ���л�������
    void SerializeCore(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');  //�ָ���
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
    //��ǰ�������˳�����л�����ע��index
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