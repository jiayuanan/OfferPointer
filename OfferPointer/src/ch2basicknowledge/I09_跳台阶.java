package ch2basicknowledge;

/**
 * 2018��3��20�� @author jiayuanan
 * ţ��������Ŀ����̨�׺ͱ�̬��̨��
 * ��̬��̨�ף�һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * ˵��������ϵͳ��bug����ô���޷�ͨ��
 */
public class I09_��̨�� {
	//�ҹ��ɿ���
    public static int JumpFloor(int target) {
        if(target <= 0)
            throw new RuntimeException("target should be above 0");
        return (int) Math.pow(2, target -1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(JumpFloor(3));
	}

}
