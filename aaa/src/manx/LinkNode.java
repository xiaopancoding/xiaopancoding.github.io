package manx;


public class LinkNode {

    public static void main(String[] args) {
        ListNode ans = new ListNode();
        ans.add();
        ans.Print();
        ans.deleteNode(3);
        ans.Print1();
    }



}

class Node {
    int val;
    Node next;
    public Node () {

    }
    public Node(int val) {
        this.val = val;
    }
}
class ListNode {
    Node head;
    public void add() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        this.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }
    public void Print() {
        Node head1 = this.head;
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }
    public void deleteNode (int val) {
        if (this.head.val == val)
            this.head = this.head.next;
        else {
            Node head1 = this.head;
            while (head1.next.val != val) {
                head1 = head1.next;
            }
            head1.next = head1.next.next;

        }
    }
    public void Print1() {
        Node head2 = this.head;
        while (head2 != null) {
            System.out.println(head2.val);
            head2 = head2.next;
        }
    }

}


