package stack;

import javax.swing.Popup;

import org.junit.Test;

public class MyStackTest {
	
	@Test
	public void test() {
		
	}
	
	/**
	 * 只能处理一位数字的情况
	 */
	@Test 
	public void test2() {
		String expl = "3+2*7-2";
		//创建数栈
		MyStack numStack = new MyStack(10);
		//创建操作数栈
		MyStack operStack = new MyStack(10);
		//扫描表达式指针
		int index = 0;
		
		int num1 = 0;
		int num2 = 0;
		int result = 0; //计算结果
		int oper = 0;  //从操作符栈弹出的运算符
		char ch = ' '; //表达式的字符
		
		//扫描表达式
		while(true) {
			//得到表达式的每一个字符
			ch = expl.substring(index, index+1).charAt(0);
			//判断ch类型
			if(operStack.isOper(ch)) {
				//判断当前的符号栈是否为空
				if(!operStack.isEmpty()) {
					//判断当前的符号的优先级和占中的优先级
					if(operStack.priority(ch)<=operStack.priority(operStack.getTop())) {
						//条件满足从数栈取出一个数
						num1 = numStack.pop();
						num2 = numStack.pop();
						//从操作符栈取出一个操作符
						oper = operStack.pop();
						//进行运算
						result = numStack.caculate(num1, oper, num2);
						//把运算的结果入数栈
						numStack.push(result);
						//把当前的符号入符号栈
						operStack.push(ch);
					}else {
						//当前的符号优先级大于符号栈中的符号，直接入栈
						operStack.push(ch);
					}
					
				}else {
					//空直接入符号栈
					operStack.push(ch);
				}
			}else { // 如果是数则直接入数栈
				numStack.push(ch-48);
			}
			
			//index + 1，判断是否扫描到表达式最后
			index++;
			if(index>=expl.length()) {
				break;
			}
			
			
		}
		
		
		//扫描结束后进行运算
		//数栈只有一个数，或者符号栈为空退出循环
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			//从操作符栈取出一个操作符
			oper = operStack.pop();
			//进行运算
			result = numStack.caculate(num1, oper, num2);
			//把运算的结果入数栈
			numStack.push(result);
		}
		
		System.out.println("表达式:"+expl+":结果:"+numStack.pop());
		
	}
	
	/**
	 * 自己写的测试
	 */
	@Test
	public void mytest() {
		String expl = "3+2*7-2";
		//创建数栈
		MyStack numStack = new MyStack(10);
		//创建符号栈
		MyStack operStack = new MyStack(10);
		//定义一些变量
		int index = 0; //用于扫描表达式
		int num1 = 0;
		int num2 = 0;
		int  result = 0; //最后的计算结果
		char ch = ' '; //存放当前扫描到的字符
		int  oper = 0; //接受从符号栈弹出的符号
		
		//扫描表达式
		while(true) {
			
			
			//开始扫描表达式
			ch = expl.substring(index, index+1).charAt(0);
			//判断是否是操作符
			if(operStack.isOper(ch)) {
				//判断当前的符号栈是否为空,不为空
				if(!operStack.isEmpty()) {
					//比较当前符号和符号栈中符号的优先级
					//当前符号的优先级小则从数栈弹出两个数，符号栈弹出一个数，计算结果入数栈，当前符号入符号栈
					if(operStack.priority(ch)<=operStack.priority(operStack.getTop())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						result = numStack.caculate(num1, oper, num2);
						//结果入数栈
						numStack.push(result);
						//当前操作符入符号栈
						operStack.push(ch);	
					}else {
						//当前符号的优先级大则直接入符号栈
						operStack.push(ch);
					}
				}else {
					//为空直接入符号栈
					operStack.push(ch);
				}
			}else {
				//数字直接入数栈 
				//根据ASCLL码表数字符号和数值相差48
				numStack.push(ch-48);
			}
			
			//index++
			index++;
			if(index>=expl.length()) {
				System.out.println("表达式扫描完毕");
				break;
			}
			
		}
		
		
		//开始计算结果
		//操作数栈只有一个元素或者符号栈为空则是最终结果
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			result = numStack.caculate(num1, oper, num2);
			//结果入数栈
			numStack.push(result);			
		}
		System.out.println("表达式"+expl+"="+result);
		
		
	}
	
	/**
	 * 处理多位数字的情况
	 */
	@Test 
	public void test4() {
		String expl = "3+2*7-2";
		//创建数栈
		MyStack numStack = new MyStack(10);
		//创建操作数栈
		MyStack operStack = new MyStack(10);
		//扫描表达式指针
		int index = 0;
		
		int num1 = 0;
		int num2 = 0;
		int result = 0; //计算结果
		int oper = 0;  //从操作符栈弹出的运算符
		char ch = ' '; //表达式的字符
		
		//扫描表达式
		while(true) {
			//得到表达式的每一个字符
			ch = expl.substring(index, index+1).charAt(0);
			//判断ch类型
			if(operStack.isOper(ch)) {
				//判断当前的符号栈是否为空
				if(!operStack.isEmpty()) {
					//判断当前的符号的优先级和占中的优先级
					if(operStack.priority(ch)<=operStack.priority(operStack.getTop())) {
						//条件满足从数栈取出一个数
						num1 = numStack.pop();
						num2 = numStack.pop();
						//从操作符栈取出一个操作符
						oper = operStack.pop();
						//进行运算
						result = numStack.caculate(num1, oper, num2);
						//把运算的结果入数栈
						numStack.push(result);
						//把当前的符号入符号栈
						operStack.push(ch);
					}else {
						//当前的符号优先级大于符号栈中的符号，直接入栈
						operStack.push(ch);
					}
					
				}else {
					//空直接入符号栈
					operStack.push(ch);
				}
			}else { // 如果是数则直接入数栈
				numStack.push(ch-48);
			}
			
			//index + 1，判断是否扫描到表达式最后
			index++;
			if(index>=expl.length()) {
				break;
			}
			
			
		}
		
		
		//扫描结束后进行运算
		//数栈只有一个数，或者符号栈为空退出循环
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			//从操作符栈取出一个操作符
			oper = operStack.pop();
			//进行运算
			result = numStack.caculate(num1, oper, num2);
			//把运算的结果入数栈
			numStack.push(result);
		}
		
		System.out.println("表达式:"+expl+"=:"+numStack.pop());
		
	}
	
}

class MyStack{
	private int[] data; //存放数据
	private int top;  //栈顶
	private int maxsize; // 最大容量
	
	/**
	 * 初始化栈
	 * @param maxsize
	 */
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		this.top = -1;
		this.data = new int[maxsize];
		
	}
	
	public boolean isFull() {
		return top==maxsize-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	/**
	 * 出栈
	 */
	public int pop() {
		//判断是否为空
		if(isEmpty()) {
			System.out.println("占空");
			return -1;
		}
		//取出栈顶元素
		int result = data[top];
		top--;
		
		return result;
		
	}
	
	
	/**
	 * 获取栈顶元素
	 * 不是真正出栈
	 */
	public int getTop() {
		//判断是否为空
		if(isEmpty()) {
			System.out.println("占空");
			return -1;
		}
		//取出栈顶元素
		return data[top];
		
	}
	
	
	/**
	 * 入栈
	 * @param indata
	 */
	public void  push(int indata) {
		if(isFull()) {
			System.out.println("栈满");
			return ;
		}
		top++;
		data[top] = indata;
	}
	
	
	
	
	
	/**
	 * 遍历栈
	 */
	public void showMyStack() {
		if(isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for(int i=maxsize-1;i>=0;i--) {
			System.out.println("栈顶:"+data[i]);
		}
	}
	
	
	
	/**
	 * 判断优先级
	 */
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+' || oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	/**
	 * 判断是否是运算符
	 * @param value
	 * @return
	 */
	public boolean isOper(char value) {
		return value=='+' || value=='-' || value=='*' || value=='/';
	}
	
	
	/**
	 *计算结果
	 * @param num1
	 * @param oper
	 * @param num2
	 * @return
	 */
	public int caculate(int num1,int oper,int num2) {
		int result = 0; //计算结果
		switch (oper) {
		case '+':
			result = num1+num2;
			break;
		case '-':
			result = num2-num1;
			break;
		case '*':
			result = num1*num2;
			break;
		case '/':
			result = num2/num1;
			break;
		default:
			break;
		}
		return result;
	}
	
	
	
}


