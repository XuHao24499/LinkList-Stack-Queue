package ASM2;

public class MyStack<T> {
    private Node top;

    public MyStack(){
    }

    public MyStack(Node top) {
        this.top = top;
    }

    //ham kiem tra stack co rong~ hay khong
    boolean isEmpty(){
        return (this.top == null);
    }

    //ham them node vao stack
    public  void push(Product data){
        Node newNode = new Node(data);
        newNode.setData(data);
        if (isEmpty()){
            newNode.setNextNode(null);
            this.top = newNode;
        }else {
            newNode.setNextNode(this.top);
            //cap nhat node top
            this.top = newNode;
        }
    }

    //ham hien thi stack
    public void displayStack(MyStack<Product> stack){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            Node cur = stack.top;
            while (cur != null){
                System.out.printf("%-10s | %-10s | %-10d | %-10.1f", cur.getData().getId(), cur.getData().getTitle(), cur.getData().getQuantity(), cur.getData().getPrice());
                System.out.println();
                cur = cur.getNextNode();
            }
        }
    }
}
