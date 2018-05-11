package huawei.jishi1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class I31_单词倒排_中级 {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String s=line.replaceAll("[^a-zA-Z]+"," ").trim();  //正则表达式
        String [] strs=s.split(" ");
        for(int i=strs.length-1;i>=1;--i){
            System.out.print(strs[i]+" ");
        }
        System.out.print(strs[0]);
    }
	
	
//我的方法	
/*	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String sentence = scan.nextLine();
			int start = 0;
			Stack<String> stack = new Stack<>();
			for(int i = 0; i < sentence.length(); ++i) {
				//寻找终点
				char ch = sentence.charAt(i);
				if(Character.isLetter(ch)) {
					if(i == sentence.length() - 1) {  //最后一个单词需要特殊处理
						stack.push(sentence.substring(start, i + 1));
					} else 
					    continue;
				} else {
					stack.push(sentence.substring(start, i));
					//找到下一个起点
					int j = i;
					for(; j < sentence.length(); ++j) {
						char c = sentence.charAt(j);
						if(Character.isLetter(c)) {
							break;
						}
					}
					if(j == sentence.length())
						break;
					else {       //结尾的特殊处理
						start = j;
						i = j - 1;
					}

				}
			}
			
			boolean first = true;
			while(!stack.isEmpty()) {
				String word = stack.pop();
				if("".equals(word)) {  //对于开头可能存在的空情形的特殊处理
					continue;
				} else {
					if(first) {
						System.out.print(word);
						first = false;
					} else {
						System.out.print(" " + word);
					}
				}

			}
		}
	}*/
}
