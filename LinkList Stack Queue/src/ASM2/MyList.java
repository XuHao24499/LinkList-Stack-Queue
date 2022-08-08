package ASM2;

import java.util.Scanner;

public class MyList<T> {
    public static Scanner sc = new Scanner(System.in);

    private Node head;

    private Node tail;

    public MyList() {
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    //ham tra ve node head
    public Node getHead() {
        return head;
    }

    //ham them vao cuoi list
    public void addTail(Product data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }

    //ham xoa node cuoi list
    public void delHead(MyList<Product> list) {
        if (list.head == null) {
            System.out.println("Cha co gi de xoa het");
        } else {
            list.head = list.head.getNextNode();//cap nhat node head
        }
    }

    //ham xoa node theo id
    public void delNodeById(MyList<Product> list, String delID) {
        if (list.head.getData().getId().equalsIgnoreCase(delID)) {
            delHead(list);
        } else {
            Node cur = list.head;
            //so sanh id cua node cur voi id node can xoa
            while (cur.getNextNode().getNextNode() != null && cur.getNextNode().getData().getId().equalsIgnoreCase(delID) == false) {
                cur = cur.getNextNode();
            }
            if (cur.getNextNode().getData().getId().equalsIgnoreCase(delID) == false) {
                System.out.println("Khong ton tai ID can xoa");
            } else {
                cur.setNextNode(cur.getNextNode().getNextNode());
            }
        }
    }

    //ham sap xep bang selectionsort
    public void selectionSortList(MyList<Product> list) {
        Node min;
        Node p, q;
        p = list.head;
        while (p.getNextNode() != null) {
            min = p;
            q = p.getNextNode();
            while (q.getNextNode() != null) {
                //chuyen 2 chuoi ve kieu int de so sanh
                int a = Integer.parseInt(q.getData().getId(), 30);
                int b = Integer.parseInt(min.getData().getId(), 30);
                if (a < b) {
                    min = q;
                }
                q = q.getNextNode();
            }
            //hoan vi
            Product temp = min.getData();
            min.setData(p.getData());
            p.setData(temp);

            p = p.getNextNode();
        }
        list.display(list);
    }

    //ham hien thi list
    public void display(MyList<Product> list) {
        Node current = this.getHead();
        while (current != null) {
            System.out.printf("%-10s | %-10s | %-10d | %-10.1f", current.getData().getId(), current.getData().getTitle(), current.getData().getQuantity(), current.getData().getPrice());
            System.out.println();
            current = current.getNextNode();
        }
    }

}
