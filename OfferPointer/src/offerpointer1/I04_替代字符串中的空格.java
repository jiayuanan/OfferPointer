package offerpointer1;
//item4:����ַ����еĿո���"%20"�滻�ַ����еĿո�
//Ӧ�ó������������У������ַ���Ҫ����ת��������ת��Ϊ%+�ַ���ASCII��ʾ
public class I04_����ַ����еĿո� {
	public static void main(String...args) {
		System.out.println(new SpaceReplace().replaceSpace(new StringBuffer("I love you")));
	}
}
// http://www.runoob.com/java/java-stringbuffer.html
// http://blog.csdn.net/u012877472/article/details/50808554
class SpaceReplace {
    public String replaceSpace(StringBuffer str) {
    	//�ȱ���ȷ���ո�ĸ�����ȷ������ĳ��ȡ�����Java��ûɶ����
    	int length = str.length();
    	for(int pos = 0, len = str.length(); pos < len; ++ pos) {
    		if(str.charAt(pos) == ' ') {
    			length += 2;
    		}
    	}
    	//��ʼ����������ַ���
    	StringBuffer result = new StringBuffer(length);
    	for(int pos = 0, len = str.length(); pos < len; ++ pos) {
    		if(str.charAt(pos) == ' ') {
    			result.append("%20");
    		} else {
    			result.append(str.charAt(pos));
    		}
    		System.out.println(result.length());
    	}
    	
    	return result.toString();
    }
}