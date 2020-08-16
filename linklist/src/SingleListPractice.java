import org.junit.Test;

public class SingleListPractice {





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


//        int length = getLength(singleLinkList.getHead());
//        System.out.println("节点个数:"+length);
        Node lastIndexNode = getLastIndexNode(singleLinkList.getHead(),2);
        System.out.println("倒数节点："+lastIndexNode);

        singleLinkList.showLinkList();

//        Node node4 = new Node("2号修改测试",2);
//
//        singleLinkList.updateNode(node4);

//        singleLinkList.deleteNodeByNo(1);
//
//        singleLinkList.showLinkList();



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

    6、遍历：通过while死循环，满足某个条件时说明找到的节点，退出循环
            当不满足条件时，通过 temp = temp.next 指针后移，指导找到节点或者遍历到最后节点
     */
    class SingleLinkList{

        private Node head = new Node();

        public Node getHead() {
            return head;
        }

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




        /*
            反转单链表
            未完成
        */
        public   void reverseLinkList(Node head){
            //判断原来的链表是否为空或者只有一个节点时不用反转
            if(head.next==null || head.next.next==null){
                return;
            }
            //辅助指针，遍历链表
            Node temp = head;
            //创建一个新的链表头结点，用于保存反转后的链表
            Node reverseHead = new Node(null,0);
            //创建一个next节点，用于保存当前节点的下一个节点
            Node nextNode = null;

            while (temp!=null){
                //首先保存当前节点的下一个节点，防止链表断裂
                nextNode = temp.next;
                temp.next = reverseHead.next;
                temp = nextNode;
            }
            //将原来的头结点指向新链表的前端
            head.next = reverseHead.next;

        }

    }


    /*
        获取单链表的节点个数
        拿到头结点就相当于拿到了整个单链表
         */
    public static int getLength(Node head){

        if(head.next==null){
            return 0;
        }
        int length = 0; // 链表的长度
        Node temp = head.next; // 没有统计头结点
        while (temp!=null){
            length++;
            temp = temp.next;
        }

        return length;
    }




    /*
       获取倒数第 index 个节点
       1.获取到链表的总长度 length
       2.正序遍历到 length-index 即为倒数第 index 个节点

    */
    public static Node getLastIndexNode(Node head,int index){

        if(head.next==null){
            return null;
        }
        //辅助变量
        Node temp = head.next;
        //第一次遍历获取链表的长度
        int length = getLength(head);

        //先做数据校验，看index是否合理
        if(index<=0 || index>length){
            System.out.println("index 不合理，找不到该节点");
            return null;
        }

        //第二次遍历 length-index 个节点
        //遍历length - index 次
        for (int i = 0; i <length-index ; i++) {
            //通过指针后移的方式遍历
            temp = temp.next;
        }

        //此时temp就是倒数第k个节点
        return temp;
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
