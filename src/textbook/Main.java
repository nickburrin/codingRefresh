package textbook;

import static java.lang.System.*;

public class Main {
	public static void main(String[] args){
		BinaryTree testMe = new BinaryTree();
		
		//createBinaryTree(testMe, 5, 3);
		createRandomBinaryTree(testMe, 5, 10);
		
		out.println("------ In-order traversal ------");
		testMe.inOrderTraverse(testMe.getRoot());
		out.println("------ Pre-order traversal ------");
		testMe.preOrderTraverse(testMe.getRoot());
		out.println("------ Post-order traversal ------");
		testMe.postOrderTraverse(testMe.getRoot());
	}
	
	private static void createRandomBinaryTree(BinaryTree tree, int numElements, int maxInt) {
		for(int i = 1; i <= numElements; i++){
			tree.insert((int) (Math.random()*maxInt));
		}
	}

	private static void createBinaryTree(BinaryTree tree, int numElements, int factor){
		for(int i = 0; i < numElements * factor; i+= factor){
			tree.insert(i);
		}
	}
}
