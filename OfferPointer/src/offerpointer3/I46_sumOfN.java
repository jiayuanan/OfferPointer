package offerpointer3;

/**
 * 2018��3��26�� @author jiayuanan
 * item46:��1+2+3+4+����+n
 * ������������1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * ˼·��ʹ�������� �ضϹ���
 */
class Solution46 {
    public int Sum_Solution(int n) {
        int result = n;
        boolean helper = (result > 0) && (result += Sum_Solution(n - 1)) > 0; //Java��ȱ�ٲ�������ת�������벹ȫ
        return result;
    }
}
public class I46_sumOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution46().Sum_Solution(5));
	}

}
