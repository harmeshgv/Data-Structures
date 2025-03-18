class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
 
}

public class SegOddEven {

    public static void display(Node n) {
        System.out.println( "Our LinkedList is ");
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
            
        }

    }


    public static void main(String [] args) {
        Node head = new Node(10);
        head.next  = new Node(21);
        head.next.next = new Node(33);
        head.next.next.next = new Node(40);
        display(head);
        System.out.println("____________________________");

        Node n = head;

        Node Ehead, Etail, Ohead, Otail;
        Ehead = Etail = Ohead = Otail = null;

        while (n != null) {
            if( n.data % 2 == 0){

            
                if(Ehead  == null) {
                   Ehead = n;
                   Etail = n;
                }
                else{
                   Etail.next = n;
                   Etail = Etail.next;
                }
                display(Ehead);


                n = n.next;
            
            }


        }


    
    }
}
