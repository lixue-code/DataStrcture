import org.junit.Test;

public class SingleListDemo {


    @Test
    public void test(){
        Node node = new Node("1");
        Node node1 = new Node("2");
        Node node2 = new Node("3");

        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addNode(node);
        singleLinkList.addNode(node2);
        singleLinkList.addNode(node1);


        singleLinkList.showLinkList();
    }

    //单链表类

    class SingleLinkList{

        private Node head = new Node();

        //添加节点
        //1.找到最后一个节点(指针域为空说明为最后节点)
        //2.最后节点的指针域指向新节点
        public void addNode(Node node){
            //辅助节点
            Node temp = head;
            //找到最后一个节点
            while (true){
                //从head开始找
                if(temp.next==null){
                    break;
                }
                temp = temp.next;
            }
            //退出循环时，temp指向了最后节点
            //temp指向新的节点
            temp.next = node;
        }


        //显示链表
        //1.判断是否为空
        //2.遍历
        public void showLinkList(){
            //判断是否为空
          if(head.next==null){
              System.out.println("链表为空");
              return;
          }
          Node temp = head.next;
          while (true){
              //为空说明到了链表的最后节点
              if(temp==null){
                break;
              }
              //输出节点信息
              System.out.println(temp);

              //temp 后移
              temp = temp.next;
          }


        }
    }

    //节点类
    class Node{
        private Object data;  //数据域
        private Node next;   //指针域

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
