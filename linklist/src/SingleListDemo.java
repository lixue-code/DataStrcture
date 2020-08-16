import org.junit.Test;

public class SingleListDemo {


    @Test
    public void test(){
        Node node = new Node("1",1);
        Node node1 = new Node("2",2);
        Node node2 = new Node("3",3);
        Node node3 = new Node("4",4);

        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addNodeByOrde(node);
        singleLinkList.addNodeByOrde(node1);
        singleLinkList.addNodeByOrde(node3);
        singleLinkList.addNodeByOrde(node2);

        singleLinkList.showLinkList();

//        Node node4 = new Node("2号修改测试",2);
//
//        singleLinkList.updateNode(node4);

        singleLinkList.deleteNodeByNo(1);

        singleLinkList.showLinkList();



    }

    //单链表类

    /*
    小结：
    1、节点添加，删除是对节点进行操作，temp = head 即要从头结点开始遍历
    2、节点的修改，链表的显示是对节点数据的操作，temp = head.next 从头指针开始操作，即头结点的下一个节点
    3、添加：找到添加位置前一个节点，后添加
        （1）链表最后添加：只需要将最后节点指针域指向新节点
        （2）链表中间插入：1.新节点的next指向前一个节点的next 即 newNode.next = temp.next
                         2.前一个节点的next指向新节点 即 temp.next = newNode
    4、删除：一样也是找到待删除位置的前一个节点
         （1）找到需要删除位置的前一个节点temp
         （2）删除：temp.next = temp.next.next
    5、更新：找到需要跟新位置的节点 temp
        （1）更新：修改temp的数据域为新节点的数据域
     */
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


        //按照编号顺序添加节点
        public void addNodeByOrde(Node node){
            Node temp = head; //需要从头结点开始遍历，temp 指向头结点

            boolean flag = false;//用于判断节点编号是否重复

            //找到添加节点的位置,循环条件退出表示找到了添加的位置
            while (true){
                //最后节点
                if(temp.next==null){
                    break;
                }
                if(temp.next.no>node.no){
                    break;
                }else if(temp.next.no==node.no){
                    flag = true;
                    break;
                }
                //以上条件都不满足时。temp后移，继续比较
                temp = temp.next;
            }

            //退出循环时说明已经找到节点位置
            if(flag){
                System.out.println("节点编号重复，无法添加");
                return;
            }else{

                //这里的顺序不能改变
                node.next = temp.next;
                temp.next = node;

            }
        }

        //修改节点信息,更具编号修改节点信息
        public void updateNode(Node newNode){
            if(head.next==null){
                System.out.println("链表为空");
                return;
            }
            //找到需要修改的节点
            Node temp = head.next; //只需要遍历数据，所以temp直接指向投头结点的下一个节点
            boolean flag = false;//表示是否找到需要修改的节点
            while (true){
                if(temp==null){  //说明已经到最后一个节点
                    break;
                }
                if(temp.no == newNode.no){
                    System.out.println("找到了");
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            // 根据flag判断是否找到节点
            if(flag){
                //修改节点数据
                temp.data = newNode.data;
            }else{
                System.out.println("没有找到节点"+newNode.no);
                return;
            }
        }

        public void deleteNodeByNo(int no){
            //判断链表是否为空
            if(head.next==null){
                return;
            }
            boolean flag = false;  //是否找到节点
            Node temp = head;
            //找到需要删除的节点的前一个节点
            while (true){
                //遍历到了最后节点
                if(temp.next==null){
                    break;
                }
                if(temp.next.no == no){
                    System.out.println("找到了待删除节点的前一个节点");
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if(flag){
                temp.next = temp.next.next;
            }else{
                System.out.println("没有找到该节点");
                return;
            }
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

              //temp 后移才能实现遍历
              temp = temp.next;
          }


        }




    }



    //节点类
    class Node{
        private Object data;  //数据域
        private Node next;   //指针域
        private int no;

        public Node() {
        }

        public Node(Object data,int no) {
            this.data = data;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", no=" + no +
                    '}';
        }
    }
}
