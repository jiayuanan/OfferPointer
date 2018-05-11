package ch4clearthoughts;

/**
 * 2018��4��10�� @author jiayuanan
 * Solution.java
 * 
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        //1.����next ��ԭ����A->B->C ���A->A'->B->B'->C->C'
        RandomListNode pClone = pHead;
        while(pClone!=null){
            RandomListNode node = new RandomListNode(pClone.label); //����������㲢����
            node.next = pClone.next;
            pClone.next = node;
            pClone = node.next; //����
        }
        //�ڶ���������random
        pClone = pHead;
        while(pClone!=null){
            if(pClone.random!=null)
                pClone.next.random = pClone.random.next;
            pClone = pClone.next.next;
        }
      //������������
        RandomListNode head = pHead.next;
        RandomListNode clone = head;
        pClone = pHead;
        while(pClone!=null){
            pClone.next = pClone.next.next; //ABC
            if(clone.next!=null)
                clone.next = clone.next.next;  //A'B'C'
            clone = clone.next;
            pClone = pClone.next;
        }
        return head;       
    }
}

