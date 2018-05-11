package ch4clearthoughts;

/**
 * 2018年3月22日 @author jiayuanan
 * item26:复杂链表的复制
 * 问题描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 *         返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class Solution26 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
        	return null;      
        //第一步，复制结点，处理next
        RandomListNode pClone = pHead;
    	while(pClone != null) {
    		
    		RandomListNode clone = new RandomListNode(pClone.label);
    		clone.next = pClone.next;
    		pClone.next = clone;
    		//迭代
    		pClone = clone.next;
    	}  	
        //第二步，处理random
    	pClone = pHead;
    	while(pClone != null) {
    		//为clone的每个结点设置random结点
    		RandomListNode clone = pClone.next;
    		if(pClone.random != null) //这一句不能忘
    			clone.random = pClone.random.next; //不要忘记加next
    		//迭代
    		pClone = clone.next;
    	}
         //第三步，分离
    	pClone = pHead;
    	RandomListNode head = pClone.next;
    	while(pClone != null) {
    		RandomListNode clone = pClone.next;
    		RandomListNode nextNode = clone.next; //保存
    		
    		if(nextNode != null)
    			clone.next = nextNode.next; //建立连接
    		//迭代
    		pClone = nextNode;  		
    		
    	}
    	return head;
    }    
}
public class I26_复杂链表的复制 {
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