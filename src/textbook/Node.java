package textbook;

public class Node {
	private int value;
	private Node[] children;
	
	public Node(int val){
		this.value = val;
	}
	
	public int getValue(){
		return this.value;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
