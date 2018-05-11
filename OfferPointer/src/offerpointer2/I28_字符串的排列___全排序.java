package offerpointer2;

/**
 * 2018��3��23�� @author jiayuanan
 * item28:�ַ���������
 * ��������������һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * ���õݹ��˼�룺
����Ҫȫ���е��ַ�����Ϊ�����ֿ�����
��1���ַ����ĵ�һ���ַ���
��2����һ���ַ�����������ַ���
�����п��ܳ����ڵ�һ��λ�õ��ַ�������һ���ַ��ͺ�����ַ�һ�ν�����
�̶���һ���ַ����Ե�һ���ַ�����������ַ���ȫ���С���һ���ַ�����������ַ��ֿ��Է�Ϊ������
 */
import java.util.*; 
class Solution28 {  
    public ArrayList<String> Permutation(String str) {  
        ArrayList<String> result = new ArrayList<String>();  
        if(str == null || str.length() == 0) {  
            return result;  
        }  
        char[] charArray = str.toCharArray();  
        //������������ֵ�˳��  
        TreeSet<String> tempRes = new TreeSet<String>();  
        PermutationCore(charArray, tempRes, 0);  
        result.addAll(tempRes);  
        return result;  
          
    }  
    private void PermutationCore( char[] charArray,TreeSet<String> tempRes,int loc)  
    {  
        if(charArray == null || charArray.length == 0 || loc < 0 || loc > charArray.length - 1)  {  
            return ;  
        }  
        if(loc == charArray.length - 1)  {  
            tempRes.add(String.valueOf(charArray));//�ݹ�ĳ���  
        }  else  {  
            for(int i = loc;i < charArray.length; i++)   {  
                swap(charArray, i, loc);//����һ���ַ��������ַ�����  
                PermutationCore(charArray, tempRes, loc + 1);//�Ժ������е��ַ�����ȫ����  
                swap(charArray, i, loc);//�ٽ�֮ǰ�������ַ������������Ա��һ���ַ����������ַ�����  
            }  
               
        }  
    }  
    private void swap(char[] charArray,int i,int j)  
    {  
        char temp = charArray[i];  
        charArray[i] = charArray[j];  
        charArray[j] = temp;  
    }  
}  

public class I28_�ַ���������___ȫ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
