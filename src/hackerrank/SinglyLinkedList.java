class SinglyLinkedList {
    public Node head;
    public Node tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        Node node = new Node(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }

    public String toString() {
        Node node = this.head;
        String asString = "";

        while (node != null) {
            asString += node.data + "\n";
            node = node.next;
        }

        return asString;
    }
}