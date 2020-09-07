package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandExplerssion {
	
	
	public static void main(String[] args) {
		String explerssion = "3 4 + 5 * 6 -";
		List<String> list = toList(explerssion);
		System.out.println(list);
		int caculate = caculate(list);
		System.out.println("结果:"+caculate);
	}
	
	
	//将字符串转换成集合
	public static List<String> toList(String explerssion){
		String[] split = explerssion.split(" ");
		List<String> List = new ArrayList<String>();
		for(String item:split) {
			List.add(item);
		}
		return List;
		
	}
	
	/**
	 * 计算后缀表达式的结果
	 * @param list
	 * @return
	 */
	public static int caculate(List<String> list) {
		//创建一个栈
		Stack<String> stack = new Stack<String>();
		int result = 0;
		int num1 = 0;
		int num2 = 0;
		
		for (String item : list) {
			//如果是多位数
			if(item.matches("\\d+")) {
				//直接入栈
				stack.push(item);
			}else {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				
				switch (item) {
				case "+":
					result = num1+num2;
					//把计算结果压栈
					stack.push(""+result);
					break;
				case "-":
					result = num2-num1;
					stack.push(""+result);
					break;
				case "*":
					result = num1*num2;
					stack.push(""+result);
					break;
				case "/":
					result = num2/num1;
					stack.push(""+result);
					break;
				default:
					System.out.println("运算符有误");
					break;
				}
			}
		}
		
		//弹出运算结果
		return Integer.parseInt(stack.pop());
	}
}


