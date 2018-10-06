package textbook;

public class BinaryNode extends Node {
	
	public BinaryNode(int val) {
		super(val);
		this.setChildren(new Node[2]);
		this.setLeft(null);
		this.setRight(null);
	}

	public BinaryNode getLeft() {
		return (BinaryNode) getChildren()[0];
	}

	public void setLeft(BinaryNode left) {
		this.getChildren()[0] = left;
	}

	public BinaryNode getRight() {
		return (BinaryNode) getChildren()[1];
	}

	public void setRight(BinaryNode right) {
		this.getChildren()[1] = right;
	}

	
}
