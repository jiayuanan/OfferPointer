package ch6differentAblities;

/**
 * 2018��3��26�� @author jiayuanan
 * item42: ��һ�⡪����ת����˳��
 * ������������student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 */
class Solution42 {
    public String ReverseSentence(String str) {
    	if(str == null)
    		return null;
    	//��һ���жϺô�����Ŀ��������
        if(str.trim().equals(""))
            return str;
        String[] ss = str.split(" ");
        
        StringBuilder result = new StringBuilder("");
        int length = ss.length;
        for(int i = length - 1; i >= 0; --i) {
        	result.append(ss[i]);
        	if(i != 0)
        		result.append(" ");
        }
        
        return result.toString();
    }
}
public class I42_��ת����˳�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " ";
		System.out.print(new Solution42().ReverseSentence(str));
		System.out.println("haha");
	}

}
