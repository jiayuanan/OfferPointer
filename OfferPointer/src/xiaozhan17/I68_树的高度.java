package xiaozhan17;

/**
 * 2018年4月20日 @author jiayuanan
 * .java
题目描述
现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
输入描述:
输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
输出描述:
输出树的高度，为一个整数
 */
//思路：子节点层数比父节点大1，构建一个map，记录层数
//智障题目：题目本身不保证为二叉树
//看别人正确的解答：需要再用一个map保存子节点数，超过2个时，忽略。。。。
import java.util.*;
public class I68_树的高度{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
        	HashMap<Integer, Integer> levelMap = new HashMap<>(); //分别存放节点编号和对应层数
        	HashMap<Integer, Integer> childNum = new HashMap<>();//分别存放编号和对应的子节点个数
        	//处理根结点
        	levelMap.put(0, 1);
        	childNum.put(0, 0);
        	int number = scan.nextInt();
        	for(int i = 0; i < number - 1; ++i) {
        		int father = scan.nextInt();
        		int self = scan.nextInt();
        		//若找不到父节点——被前面的程序给忽略掉了；或现情况子节点超标了，就忽略吧
        		if(!levelMap.containsKey(father) || childNum.get(father) >= 2) 
        			continue;
        		//更新两个map信息
        		childNum.put(father, childNum.get(father) + 1);
        		levelMap.put(self, levelMap.get(father) + 1);
        		childNum.put(self, 0);   //开始这个忘了
        	}
        	int height = 1;
        	for(Integer i : levelMap.keySet())
        		if(levelMap.get(i) > height)
        			height = levelMap.get(i);
        	System.out.println(height);
        }
        scan.close();
    }
}
