package offerpointer2;

/**
 * 2018��3��22�� @author jiayuanan
 * item24�������������ĺ����������
 * 
 */

class Solution24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length ==0)//����һ�俪ʼ����
        	return false;
        return VerifySequenceOfBST(sequence, 0, sequence.length);
    }
    
    public boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
    	//�ݹ���������жϣ����˵��Ϊ�գ����1˵��Ϊһ������
    	if(start == end || end - start ==1)  //����������ȱһ����
    		return true;
    	//������������һ��Ԫ����root����������rootС��Ϊ��������ʣ�µ�Ӧ��Ϊ������
    	//�ҵ��ֽ�㣬���ֽ����������С��root����ΪBST�������������ٵݹ��ж������������������Ƿ�ΪBST
    	int root = sequence[end - 1];
    	int division = start;
    	for(int index = start; index < end; ++index) {
    		if(sequence[index] < root)
    			++division;
    		else
    			break;
    	}
    	for(int index = division; index < end; ++index) {
    		if(sequence[index] < root)
    			return false;
    	}
    	//ע�����һ����end-1
    	return VerifySequenceOfBST(sequence, start, division) && VerifySequenceOfBST(sequence, division, end - 1);
    }
}
public class I24_�����������ĺ���������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {5,7,6,9,11,10,8};
		System.out.println(new Solution24().VerifySquenceOfBST(test));

	}

}
