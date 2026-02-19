package mylinkedlist;


import java.util.List;


class MyLinkedList {
    private int data;
    private MyLinkedList next;


    public MyLinkedList(int data){
        this.data = data;
        this.next = null;
    }


    public void add(int data){

        if(this.next == null){
            this.next = new MyLinkedList(data); 
        }
        else{
            this.next.add(data);
        }
        
    }


    public void print(){
       System.out.println(data);
       
       if(this.next != null){
            this.next.print();
       }
    }



    public int find(int data){
        MyLinkedList current = this;
        int index = 0;

        while (current != null) {
            if(current.data == data){
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
        
    }


    public void delete(int data){
        int index = find(data);
        MyLinkedList current = this;
        MyLinkedList before = this;

        if (index == -1) {
            return;
        }

        if(index != 0){
            for (int i = 0; i < index; i++) {
                before = current;
                current = current.next;
            }

            before.next = current.next;
        }


        current.data = current.next.data;
        current.next = current.next.next;

    }

    public List<Integer> dump(List<Integer> list){
        MyLinkedList current = this;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

}

public class Main {
    public static void main(String[] args){
        MyLinkedList my = new MyLinkedList(0);
        my.add(12);
        my.add(25);
        my.add(45);
        
        
        //my.print();
        System.out.println(my.find(12));
        my.delete(0);
        my.print();

    }
}
