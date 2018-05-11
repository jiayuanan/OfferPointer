package ch4clearthoughts;

/**
 * 2018年4月10日 @author jiayuanan
 * Solution.java
 * 
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        //1.复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        RandomListNode pClone = pHead;
        while(pClone!=null){
            RandomListNode node = new RandomListNode(pClone.label); //创建伴生结点并插入
            node.next = pClone.next;
            pClone.next = node;
            pClone = node.next; //迭代
        }
        //第二步，处理random
        pClone = pHead;
        while(pClone!=null){
            if(pClone.random!=null)
                pClone.next.random = pClone.random.next;
            pClone = pClone.next.next;
        }
      //第三步，分离
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

