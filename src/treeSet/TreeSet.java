package treeSet;

public class TreeSet {
	
	public TreeNode root; //public only for testing
	
	public static TreeNode getNextNode(TreeNode currentNode, int moveDirection){
		if (moveDirection > 0) {return currentNode.getMoreNode();} //move right
		else if (moveDirection < 0) {return currentNode.getLessNode();} //move left
		else if (moveDirection == 0) {return null;}//throw new ArithmeticException();} // last element
		throw new IllegalArgumentException(); //null int
	}
	
	public boolean add(StringType T){
		if (this.root == null) { //first element
			this.root = new TreeNode(T, null, null);
			return true;
		}
		int currentMoveDirection = T.compareTo(this.root.getNodeObj());
		if (currentMoveDirection == 0) {return false;} //value exists
		
		int nextMoveDirection = currentMoveDirection;
		TreeNode currentNode = this.root;
		TreeNode nextNode = this.root;
		nextNode = TreeSet.getNextNode(currentNode, nextMoveDirection);
		
		while (nextNode != null){//loop on 2nd+ elements
			//current node assignments
			currentNode = nextNode; 
			currentMoveDirection = nextMoveDirection;
			
			//next node assignments 
			nextMoveDirection = T.compareTo(currentNode.getNodeObj());
			nextNode = TreeSet.getNextNode(currentNode, nextMoveDirection);
			if (nextMoveDirection == 0) {return false;}
		}
		
		// assigning next node
		TreeNode newNode = new TreeNode(T, null, null);
		if (nextMoveDirection > 0){			
			currentNode.setMoreNode(newNode);
			return true;
		}
		else if (nextMoveDirection < 0){	
			currentNode.setLessNode(newNode);
			return true;
		}
		return false; //should not get here
	}

	//методы add, contains, remove. 
}
