package ch4clearthoughts;

/**
 * 2018��3��22�� @author jiayuanan
 * item26:��������ĸ���
 * ��������������һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩
 *         ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */

class Solution26 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
        	return null;      
        //��һ�������ƽ�㣬����next
        RandomListNode pClone = pHead;
    	while(pClone != null) {
    		
    		RandomListNode clone = new RandomListNode(pClone.label);
    		clone.next = pClone.next;
    		pClone.next = clone;
    		//����
    		pClone = clone.next;
    	}  	
        //�ڶ���������random
    	pClone = pHead;
    	while(pClone != null) {
    		//Ϊclone��ÿ���������random���
    		RandomListNode clone = pClone.next;
    		if(pClone.random != null) //��һ�䲻����
    			clone.random = pClone.random.next; //��Ҫ���Ǽ�next
    		//����
    		pClone = clone.next;
    	}
         //������������
    	pClone = pHead;
    	RandomListNode head = pClone.next;
    	while(pClone != null) {
    		RandomListNode clone = pClone.next;
    		RandomListNode nextNode = clone.next; //����
    		
    		if(nextNode != null)
    			clone.next = nextNode.next; //��������
    		//����
    		pClone = nextNode;  		
    		
    	}
    	return head;
    }    
}
public class I26_��������ĸ��� {
	public static void main(String...args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
		node1.random = node3; node2.random = node5; node4.random = node2;
		System.out.println(node1);
	}
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
    public String toString() {
    	String result ="";
    	RandomListNode node = this;
    	while(node != null) {
    		result = result + node.label + " ";
    		node = node.next;
    	}
    	node = this;
    	while(node != null) {
    		if(node.random != null) {
    			result = result + node.random.label + " ";
    		} else {
    			result = result + "# ";
    		}
    		node = node.next;
    	}
    	return result;
    }
}