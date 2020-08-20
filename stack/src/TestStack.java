import org.junit.Test;

public class TestStack {

    @Test
    public void testStack(){
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);


        myStack.showStack();
        for (int i = 0; i <4 ; i++) {
            int pop = myStack.pop();
            System.out.println("栈顶元素:"+pop);
        }

    }
}

//创建一个栈
class MyStack{
    private int maxSize; // 最大容量
    private int[] stack;  //数组模拟栈，存放数据
    private int top = -1;   //栈顶指针

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];  //初始化数组
    }

    //判断栈是否满
    public boolean isFull(){
       return top == maxSize-1;
    }

    //判断栈是否空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int data){
        //判断是否满
        if(isFull()){
            throw  new RuntimeException("栈满，不能压栈");
        }
        //top 向上移动
        top++;
        //往栈顶添加数据
        stack[top] = data;
    }


    //出栈
    public int pop(){
        //判断是否空
        if(isEmpty()){
            System.out.println("栈空，无数据");
        }
        int value = stack[top];
        top--;
        return value;
    }


    //遍历栈(从栈顶开始遍历)
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

}
