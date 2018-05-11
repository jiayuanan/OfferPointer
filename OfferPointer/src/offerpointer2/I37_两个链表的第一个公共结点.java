package offerpointer2;

/**
 * 2018��3��26�� @author jiayuanan
 * item37:��������ĵ�һ���������
 * �����������������������ҳ����ǵĵ�һ��������㡣
 */
class Solution37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) 
    		return null;
    	
    	//�ֱ���㳤�ȣ����������������������
    	int length1 = getListLength(pHead1);
    	int length2 = getListLength(pHead2);
    	ListNode longList = length1 > length2 ? pHead1 : pHead2;
    	ListNode shortList = length1 < length2 ? pHead1 : pHead2;
    	int diff = Math.abs(length2 - length1);
    	for(int i = 0; i < diff; ++i)
    		longList = longList.next;
    	
    	while(longList != null && longList.val != shortList.val) {
    		longList = longList.next;
    		shortList = shortList.next;
    	}
    	return longList;
    }
    
    public int getListLength(ListNode list) {
    	int result = 0;
    	while(list != null) {
    		++result;
    		list = list.next;
    	}
    	return result;
    }
}
public class I37_��������ĵ�һ��������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
