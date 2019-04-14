package com.company.test1;

public class LinkList {

    public class Node{
        public int index;
        public Node next;
        public Node(int x){
            index = x;
            next = null;
        }
    }

    public int num;
    public Node start;
    public Node end;

    public LinkList(int n){
        if(n == 0){
            start = null;
            end = null;
            num = n;
        }else if(n == 1){
            start = new Node(1);
            end = start;
        }else if(n == 2){
            start = new Node(1);
            end = new Node(2);
            start.next = end;
            end.next = start;
        }else {
            num = n;
            start = new Node(1);
            end = start;
            Node temp = new Node(2);
            start.next = temp;
            for(int i=3;i<=num;i++){
                temp.next = new Node(i);
                end = temp;
                temp = end.next;
            }
            end = temp;
            end.next = start;
        }
    }

}
