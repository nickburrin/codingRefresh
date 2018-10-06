package textbook;

public class BinaryTree {
	private BinaryNode root;

	public BinaryTree(){
		this.root = null;
	}
	
	public BinaryTree(BinaryNode n){
		this.root = n;
	}
	
	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}
	
	public boolean insert(int val){
		return this.insert(new BinaryNode(val));
	}
	
	public boolean insert(BinaryNode leaf){
		if(this.getRoot() == null){
			this.setRoot(leaf);
			return true;
		} else{
			if(this.contains(this.getRoot(), leaf) == true){
				System.out.println("This tree already contains this value and does not allow duplicates.");
				return false;
			} else{
				BinaryNode parent = this.getRoot();
				BinaryNode p = null;
				
				while(true){
					if(leaf.getValue() < parent.getValue())
						p = parent.getLeft();
					else
						p = parent.getRight();
					
					if(p == null) { break; }
					parent = p;
				}
				
				if(leaf.getValue() < parent.getValue())
					parent.setLeft(leaf);
				else
					parent.setRight(leaf);
				
				return true;
			}
		}
	}
	
	public boolean contains(BinaryNode temp, BinaryNode findMe){
		if(temp == null){
			return false;
		} else{
			if(findMe.getValue() < temp.getValue()){
				contains(temp.getLeft(), findMe);
			} else if(findMe.getValue() > temp.getValue()){
				contains(temp.getRight(), findMe);
			} else{
				return true;
			}
		}

		return false;
	}
	
	void inOrderTraverse(BinaryNode node){
		if(node != null){
			inOrderTraverse(node.getLeft());
			visit(node);
			inOrderTraverse(node.getRight());
		}
	}
	
	void preOrderTraverse(BinaryNode node){
		if(node != null){
			visit(node);
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
	
	void postOrderTraverse(BinaryNode node){
		if(node != null){
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			visit(node);
		}
	}

	private void visit(BinaryNode node) {
		System.out.println(node.getValue());
	}
}
