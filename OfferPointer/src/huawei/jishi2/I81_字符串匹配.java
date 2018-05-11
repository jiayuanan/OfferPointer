package huawei.jishi2;

/**
 * 2018年4月18日 @author jiayuanan
题目标题：
判断短字符串中的所有字符是否在长字符串中全部出现
详细描述：
接口说明
原型
boolIsAllCharExist(char* pShortString,char* pLongString);
输入参数：
    char* pShortString：短字符串
    char* pLongString：长字符串
 */

//思路：如果字符串很长，可以创建一个数组进行标记；一般情况下，直接遍历就可以了
import java.util.Scanner;
public class I81_字符串匹配 {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	String shortStr = scan.nextLine();
        	String longStr = scan.nextLine();
        	System.out.println(IsAllCharExist(shortStr, longStr));
        }
        scan.close();
    }
    
    public static boolean IsAllCharExist(String shortStr, String longStr) {
    	if(shortStr == null || longStr == null)
    		return false;
    	for(int i = 0; i < shortStr.length(); ++i) {
    		if(longStr.indexOf(shortStr.charAt(i)) == -1)  //等于-1说明不含该字符
    			return false;
    	}
    	return true;
    		
    }
}
