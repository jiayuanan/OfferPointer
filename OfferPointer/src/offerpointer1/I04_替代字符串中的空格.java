package offerpointer1;
//item4:替代字符串中的空格：用"%20"替换字符串中的空格
//应用场景：网络编程中，特殊字符需要进行转化处理——转化为%+字符的ASCII表示
public class I04_替代字符串中的空格 {
	public static void main(String...args) {
		System.out.println(new SpaceReplace().replaceSpace(new StringBuffer("I love you")));
	}
}
// http://www.runoob.com/java/java-stringbuffer.html
// http://blog.csdn.net/u012877472/article/details/50808554
class SpaceReplace {
    public String replaceSpace(StringBuffer str) {
    	//先遍历确定空格的个数，确定输出的长度——在Java中没啥意义
    	int length = str.length();
    	for(int pos = 0, len = str.length(); pos < len; ++ pos) {
    		if(str.charAt(pos) == ' ') {
    			length += 2;
    		}
    	}
    	//开始构造输出的字符串
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