import org.junit.Test;

import java.util.Stack;

public class MySingleLinkList {


    @Test
    public void DemoTest(){
        SingleLinkList singleLinkList = new SingleLinkList();
        //创建节点
        Node node = new Node("小王",1);
        Node node1 = new Node("小李",2);
        Node node2 = new Node("小张",3);
//        //添加节点
//        singleLinkList.addNode(node);
//        singleLinkList.addNode(node1);
//        singleLinkList.addNode(node2);

        System.out.println("原先:");
        singleLinkList.addNodeByOrder(node);
        singleLinkList.addNodeByOrder(node2);
        singleLinkList.addNodeByOrder(node1);
        singleLinkList.showLinkList(singleLinkList.getHead());

        singleLinkList.reserverLinkListByStack(singleLinkList.getHead());

//        Node reservseHead = singleLinkList.reservseLinkList(singleLinkList.getHead());
//
//        System.out.println("反转后：");
//        singleLinkList.showLinkList(reservseHead);
//        int index = 3;
//        Node lastIndexNode = singleLinkList.getLastIndexNode(singleLinkList.getHead(),index);
//        System.out.println("倒数第"+index+"节点是:"+lastIndexNode);


//        System.out.println("链表长度："+singleLinkList.getLinkListlength());

//        System.out.println("删除后：");
//        singleLinkList.deleteNodeByNo(2);
//        singleLinkList.showLinkList();
//        System.out.println("链表长度："+singleLinkList.getLinkListlength());

//        Node newNode = new Node("老王", 1);
//        singleLinkList.updateNodeByNo(newNode);
//        singleLinkList.showLinkList();



    }




    /*
        单链表类
     */
    class SingleLinkList {
        private Node head = new Node(null,0);  //单链表的头结点，有了头节点相当于知道了整个单链表

        public Node getHead() {
            return head;
        }

        /*
                    添加节点的方法
                    1.先找到最后一个节点位置
                    2.添加节点
                 */
        public void addNode(Node node){
            //当前节点
            Node temp  = head;
            //找到最后节点的位置
            while (true){
                if(temp.next==null){
                    break;
                }
                //如果没找到指针后移
                temp = temp.next;
            }

            //退出循环说明找到了
            temp.next = node;

        }

        /*
            顺序添加节点添加后的单链表有序
            此时 temp 是添加位置的前一个节点
         */
        public void addNodeByOrder(Node node){
            Node temp = head;
            //找到添加节点的位置

            while (true){
                //在左后添加
                if(temp.next==null){
                    break;
                }
                //如果当前节点的下一个节点的编号比新节点的编号大，则将新节点替换之前的当前节点的下一个节点
                if(temp.next.no>node.no){
                    break;
                }

                temp = temp.next;
            }

            //退出循环说明能进行添加
            node.next = temp.next;
            temp.next = node;

        }


        //根据编号更新节点
        //此时 temp 就是要更新的节点
        public void updateNodeByNo(Node newNode){
            if(head.next==null){
                System.out.println("链表为空");
                return;
            }
            Node temp = head.next;
            //找到需要更新的节点
            boolean flag = false; //判断是否找到需要更新的节点

            while (true){
                //已经遍历到的最后一个节点
               if(temp==null){
                   break;
               }
               if(temp.no == newNode.no){
                   System.out.println("找到了需要更新的节点");
                   flag = true;
                   break;
               }
               //不满足以上条件则继续循环
               temp = temp.next;
            }

            if(flag){
                temp.data = newNode.data;
            }else{
                System.out.println("找不到需要更新的节点");
            }


        }

        //根据编号删除节点
        //此时 temp 是待删除位置的前一个节点
        public void deleteNodeByNo(int no){
            if(head.next==null){
                return;
            }
            Node temp = head;
            boolean flag = false;  //

            while (true){
                if(temp.next==null){
                    break;
                }
                if(temp.next.no==no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            //退出循环则说明找到了
            if(flag){
                temp.next = temp.next.next;
            }else{
                System.out.println("无法删除");
                return;
            }
        }


        //获取有效节点的个数 （除去头结点）
        public int getLinkListlength(){
            //判断链表是否为空
            if(head.next==null){
                return 0;
            }

            Node temp = head.next;
            int length = 0;

            while (temp!=null){
                length++;
                temp = temp.next;
            }

            return length;
        }


        //获取倒数第 index 个节点
        public Node getLastIndexNode(Node head,int index){
            if(head.next==null){
                return null;
            }

            //获取链表的长度
            int linkListlength = this.getLinkListlength();

            Node temp = head.next;
            //遍历length-index个节点
            //对index做校验
            if(index<=0 || index >linkListlength){
                System.out.println("index输入有误");
                return null;
            }
            for (int i = 0; i <linkListlength-index ; i++) {
                temp = temp.next;
            }
            return temp;
        }


        //反转单链表输出
        public Node reservseLinkList(Node head){
            //判断链表是否为空
            if(head.next==null){
               return  head;
            }
            //temp 指向当前节点
            Node temp = head.next;
            //next 保存当前节点的下一个节点
            Node next = null;
            //创建一个新的单链表
            Node reservseHead = new Node(null,0);

            //遍历原来的单链表
            while (temp!=null){
                //先保存当前节点的下一个节点
                next = temp.next;
                //修改当前节点的next域
                temp.next = reservseHead.next;
                //修改新表头的next域指向当前遍历出来的节点
                reservseHead.next = temp;
                //指向当前节点的指针后移
                temp = next;
            }

            //返回新链表的头结点
            return  reservseHead;

        }


        //链表的反转  单链表 + 栈
        public void reserverLinkListByStack(Node head){
            //原来的链表为空或者只有一个节点时不用反转
            if(head.next==null || head.next.next==null){
                return;
            }
            //辅助变量，指向当前节点
             Node cur = head.next;
            //创建一个栈，用于保存当前元素
            Stack<Node> stack = new Stack<>();
            while (cur!=null){
                //将当前节点压栈
                stack.push(cur);
                //指针后移
                cur = cur.next;
            }

            System.out.println("反转后（栈）：");
            //弹栈
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.println(pop);
            }

        }

        public void showLinkList(Node head){
            //判断链表是否为空
            if(head.next==null){
                return;
            }
            //借助辅助节点
            Node temp = head.next;
            while (true){
                if(temp==null){
                    break;
                }
                //输出当前节点信息
                System.out.println(temp);
                //指针后移
                temp = temp.next;
            }
        }
    }




    //创建一个节点类
    /*
        节点类包含
        1.指针域 （实质上也是一个节点）
        2.数据域
        3.可选：若是要求排序，可以加上编号
     */
    class Node{
        private Object data;  //数据域
        private Node next;   //指针域
        private int no;        //编号



        public Node(Object data, int no) {
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
