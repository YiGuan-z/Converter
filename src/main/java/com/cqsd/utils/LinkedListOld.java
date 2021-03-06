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
        //????????????????????????
        private final HeroNode head = new HeroNode(0, "", "");

        private void add(HeroNode node) {
//            HeroNode temp = head;
            //??????????????????
//            while (temp.next != null) {
//                temp = temp.next;
//            }
            HeroNode temp;
            for (temp=this.head;temp.next!=null;temp=temp.next){}
            //????????????????????????node????????????
            temp.next = node;
        }

        private void addByOrderAsc(HeroNode node) throws LinkedError {
            HeroNode temp = head;
            //???????????????????????????????????????
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
                System.err.printf("?????????????????????%d????????????:\n%s\n\n", node.no, node);
                throw new LinkedError("???????????????");
            }
            // ?????????????????? temp ??? temp.next ??????
            // temp  ->  node  -> temp.next
            node.next = temp.next;
            temp.next = node;
        }

        private void listEntry() throws LinkedError {
            if (head.next == null) {
                System.out.println("????????????");
                throw new LinkedError("????????????");
            }
            HeroNode temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        private String getItem(int no) throws LinkedError {
            if (head.next == null) {
                System.out.println("????????????");
                throw new LinkedError("????????????");
            }
            HeroNode temp = head.next;
            while (temp != null) {
                if (temp.no == no) {
                    return temp.toString();
                }
                temp = temp.next;
            }
            throw new LinkedError("??????????????????");
        }

        private void updateItem(HeroNode newNode) throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("????????????");
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
                throw new LinkedError("??????????????????" + newNode.no + "?????????");
            }
        }


        private void removeItem(int no) throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("????????????");
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
                throw new LinkedError("?????????????????????");
            }
        }

        private void popItem() throws LinkedError {
            if (head.next == null) {
                throw new LinkedError("????????????");
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
                throw new LinkedError("????????????");
            }
            HeroNode cur = head.next;
            HeroNode next = null;
            HeroNode reverseHead = new HeroNode(0, "", "");
            while (cur != null) {
                //?????????????????????????????????next
                next = cur.next;
                //???cur???????????????
                cur.next = reverseHead.next;
                //?????????cur???reverseHead.next??????
                reverseHead.next = cur;
                //next???cur?????????????????????
                cur = next;
            }
            head.next = reverseHead.next;
        }

        private void reversePrint() {
            if (head.next == null) {
                System.out.println("????????????");
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
            HeroNode hero1 = new HeroNode(1, "??????", "?????????");
            HeroNode hero2 = new HeroNode(2, "?????????", "?????????");
            HeroNode hero3 = new HeroNode(3, "??????", "?????????");
            HeroNode hero4 = new HeroNode(4, "??????", "?????????");
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
            System.out.printf("id5?????????????????????:%s\n", this.list.get(5));
            System.out.printf("id4?????????????????????:%s\n", this.list.get(4));
        }

        void testUpdate() {
            System.out.println("?????????");
            list.list();
            list.update(new HeroNode(2, "CaseyCheng", "Cheng"));
            System.out.println("?????????");
            list.list();
        }

        void testPop() {
            list.pop();
            list.list();
        }

        void testReverse() {
            System.out.println("?????????");
            list.list();
            list.reverse();
            System.out.println("?????????");
            list.list();
        }

        public static void main(String[] args) {
            (new HeroTest()).run();
        }
    }

}
