package com.cqsd.utils;

import java.util.Stack;

public class LinkedListOld {
    private final SingleLinkedList list;

    public LinkedListOld() {
        list = new SingleLinkedList();
    }

    public LinkedListOld add(int id, String name, String nickName) {
        list.add(new HeroNode(id, name, nickName));
        return this;
    }

    public LinkedListOld addByOrder(int id, String name, String nickName) {
        list.addByOrder(new HeroNode(id, name, nickName));
        return this;
    }
    public LinkedListOld addByOrder(HeroNode hero) {
        list.addByOrder(hero);
        return this;
    }

    public void list() {
        this.list.list();
    }

    public String get(int id) {
        return this.list.get(id);
    }

    public LinkedListOld update(int id, String name, String nickName) {
        list.update(new HeroNode(id, name, nickName));
        return this;
    }
    public LinkedListOld update(HeroNode node) {
        list.update(node);
        return this;
    }

    public LinkedListOld remove(int id) {
        list.remove(id);
        return this;
    }

    public void pop() {
        this.list.pop();
    }

    public int lenght() {
        return this.list.lenght();
    }

    public void reverse() {
        this.list.reverse();
    }


    static class LinkedError extends Throwable {
        public LinkedError(String message) {
            super(message);
        }

        public String getMsg() {
            return super.getMessage();
        }
    }

    private static class HeroNode {
        int no;
        String name;
        String nickName;
        HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

    private static class SingleLinkedList {
        //头节点，不加数据
        private final HeroNode head = new HeroNode(0, "", "");

        private void add(HeroNode node) {
//            HeroNode temp = head;
            //查找空闲位置
//            while (temp.next != null) {
//                temp = temp.next;
//            }
            HeroNode temp;
            for (temp=this.head;temp.next!=null;temp=temp.next){}
            //找到了就把传入的node赋值给它
            temp.next = node;
        }

        private void addByOrderAsc(HeroNode node) throws LinkedError {
            HeroNode temp = head;
            //判断添加的节点是否在链表中
            boolean exist = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > node.no) {
                    break;
                }
                if (temp.next.no == node.no) {
                    exist = true;
                    break;
                }
                temp = temp.next;
            }
            if (exist) {
                System.err.printf("准备插入的编号%d已经存在:\n%s\n\n", node.no, node);
                throw new LinkedError("编号已存在");
            }
            // 把节点插入到 temp 和 temp.next 之间
            // temp  ->  node  -> temp.next
            node.next = temp.next;
            temp.next = node;
        }

        private void listEntry() throws LinkedError {
            if (head.next == null) {
                System.out.println("数据为空");
                throw new LinkedError("数据为空");
            }
            HeroNode temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        private String getItem(int no) throws LinkedError {
            if (head.next == null) {
                System.out.println("链表为空");
                throw new LinkedError("链表为空");
            }
            HeroNode temp = head.next;
            while (temp != null) {
                if (temp.no == no) {
                    return temp.toString();
                }
                temp = temp.next;
            }
            throw new LinkedError("未检索到数据");
        }

        private void updateItem(HeroNode newNode) throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("链表为空");
            }
            HeroNode temp = head.next;
            boolean exist = false;
            while (temp != null) {
                if (temp.no == newNode.no) {
                    exist = true;
                    break;
                }
                temp = temp.next;
            }
            if (exist) {
                temp.name = newNode.name;
                temp.nickName = newNode.nickName;
            } else {
                throw new LinkedError("未找到编号为" + newNode.no + "的数据");
            }
        }


        private void removeItem(int no) throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("链表为空");
            }
            HeroNode temp = head.next;
            boolean exist = false;
            while (temp != null) {
                if (temp.next.no == no) {
                    exist = true;
                    break;
                }
                temp = temp.next;
            }
            if (exist) {
                temp.next = temp.next.next;
            } else {
                throw new LinkedError("未匹配到的编号");
            }
        }

        private void popItem() throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("链表为空");
            }
            head.next = head.next.next;
        }

        private int lenght() {
            if (head.next == null)
                return 0;
            HeroNode temp = head.next;
            int num = 0;
            while (temp != null) {
                num++;
                temp = temp.next;
            }
            return num;
        }

        private void reverseList() throws LinkedError {
            if (lenght() == 0) {
                throw new LinkedError("链表为空");
            }
            HeroNode cur = head.next;
            HeroNode next = null;
            HeroNode reverseHead = new HeroNode(0, "", "");
            while (cur != null) {
                //将链表里的下一个赋值给next
                next = cur.next;
                //将cur的链表清空
                cur.next = reverseHead.next;
                //当前的cur给reverseHead.next赋值
                reverseHead.next = cur;
                //next给cur赋值以确保循环
                cur = next;
            }
            head.next = reverseHead.next;
        }

        private void reversePrint() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            Stack<HeroNode> stack = new Stack<>();
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        public void pop() {
            try {
                this.popItem();
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }

        public void addByOrder(HeroNode node) {
            try {
                addByOrderAsc(node);
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }

        public String get(int no) {
            String err;
            try {
                return this.getItem(no);
            } catch (LinkedError error) {
                err = error.getMsg();
            }
            return err;
        }

        public void list() {
            try {
                this.listEntry();
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }

        public void update(HeroNode newNode) {
            try {
                this.updateItem(newNode);
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }

        public void remove(int id) {
            try {
                this.removeItem(id);
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }

        public void reverse() {
            try {
                this.reverseList();
            } catch (LinkedError error) {
                System.err.println(error.getMsg());
            }
        }
    }

    private static class HeroTest {
//        SingleLinkedList list = new SingleLinkedList();
        LinkedListOld list=new LinkedListOld();

        void run() {
            HeroNode hero1 = new HeroNode(1, "松江", "即使雨");
            HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
            HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
            HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
//            list.add(hero1).add(hero2).add(hero3).add(hero4);
            this.list.addByOrder(hero1).addByOrder(hero2).addByOrder(hero4).addByOrder(hero3).list();
            System.out.println("\t");
            this.testGet();
            System.out.println("\t");
            this.testUpdate();
            System.out.println("\t");
            this.testPop();
            System.out.println("\t");
            this.testReverse();
        }

        void testGet() {
            System.out.printf("id5获取到的内容是:%s\n", this.list.get(5));
            System.out.printf("id4获取到的内容是:%s\n", this.list.get(4));
        }

        void testUpdate() {
            System.out.println("修改前");
            list.list();
            list.update(new HeroNode(2, "CaseyCheng", "Cheng"));
            System.out.println("修改后");
            list.list();
        }

        void testPop() {
            list.pop();
            list.list();
        }

        void testReverse() {
            System.out.println("反转前");
            list.list();
            list.reverse();
            System.out.println("反转后");
            list.list();
        }

        public static void main(String[] args) {
            (new HeroTest()).run();
        }
    }

}
