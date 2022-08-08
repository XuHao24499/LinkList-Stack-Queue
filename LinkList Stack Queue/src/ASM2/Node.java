package ASM2;

public class Node {
    private Product data;
    private Node nextNode;

    public Node() {
    }

    public Node(Product data) {
        this.data = data;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String toString() {
        return getData().getId() + " " + getData().getTitle() + " " + getData().getQuantity() + " " + getData().getPrice();
    }

    public void displayNode(Node data) {
        System.out.printf("%-10s | %-10s | %-10d | %-10.1f", getData().getId(), getData().getTitle(), getData().getQuantity(), getData().getPrice());
    }
}

