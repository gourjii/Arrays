package treeSet;

public class TreeSet {
	
	private final int removeStrategy = 1; //1 for right->leftmost; -1 for left->rightmost 
	
	private TreeNode root; //public only for testing
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public static TreeNode getNextNode(TreeNode currentNode, int moveDirection){
		if (moveDirection > 0) {return currentNode.getMoreNode();} //move right
		else if (moveDirection < 0) {return currentNode.getLessNode();} //move left
		else if (moveDirection == 0) {return null;}// last element
		throw new IllegalArgumentException(); //null int
	}
	
	public void updateTreeNodeLink (TreeNode parent, 
			TreeNode newChild, 
			int moveDirection){
		// risky side effect; if parent is null it's a root - so it's updated directly
		if (parent == null){
			this.setRoot(newChild);
		}
		else if (moveDirection > 0){
			parent.setMoreNode(newChild);
		}
		else if (moveDirection < 0){
			parent.setLessNode(newChild);
		}
		else throw new NullPointerException("updateTreeNodeLink can't update link; maybe moveDirection is 0");
	}
	
	
	public TreeNodeChain findClosestMatch(StringType T){
		TreeNodeChain chain = new TreeNodeChain();
		if (this.root == null) { //first element
			return chain;
		} 
		chain.setCurrentNode(this.root);
		int nextMoveDirection;
		TreeNode nextNode;

		boolean resume = true; // a flag to continue looping
		do {	
			nextMoveDirection = T.compareTo(chain.getCurrentNode().getNodeObj());
			if (nextMoveDirection == 0) {resume = false;} // equals
			nextNode = TreeSet.getNextNode(chain.getCurrentNode(), nextMoveDirection); //node or null (equals or next doesn't exist)
			if (nextNode == null) {resume = false;} //next doesn't exist
			if (resume == true) {
			chain.setParentNode(chain.getCurrentNode());
			chain.setCurrentNode(nextNode);
			chain.setMoveDirection(nextMoveDirection);
			}
		} while (resume);
		return chain;
	}
		
	public boolean add(StringType T){
		TreeNodeChain chain;
		chain = this.findClosestMatch(T);
		if (chain.getCurrentNode() == null){
			this.root = new TreeNode(T, null, null);
			return true;
			}
		//TreeNode nextNode;
		int moveDirection = T.compareTo(chain.getCurrentNode().getNodeObj());
		// assigning next node
		if (moveDirection == 0) {return false;} //equals
		TreeNode newNode = new TreeNode(T, null, null);
		if (moveDirection > 0){ //more			
			chain.getCurrentNode().setMoreNode(newNode);
			return true;
		}
		else if (moveDirection < 0){ //less
			chain.getCurrentNode().setLessNode(newNode);
			return true;
		}
		return false; //should not get here
	}
		
	public boolean contains (StringType T){
		TreeNodeChain chain = this.findClosestMatch(T);
		if (T.compareTo(chain.getCurrentNode().getNodeObj()) == 0) {return true;} //closes match has the same value
		return false; //value was not found
	}
	
	public boolean remove(StringType T){
		TreeNodeChain chain;
		chain = this.findClosestMatch(T);
		//System.out.println(chain.getCurrentNode().getNodeObj().getValue());
		//System.out.println(chain.getParentNode() == null);
		if (T.compareTo(chain.getCurrentNode().getNodeObj()) == 0){//delete algo
			if (chain.getCurrentNode().getLessNode() == null //no children  // will fail if root is single value
					&& chain.getCurrentNode().getMoreNode() == null) {
				this.updateTreeNodeLink(chain.getParentNode(), 
						null, //parent has null as next node 
						chain.getMoveDirection());
				return true;
			}
			else if (chain.getCurrentNode().getLessNode() != null // only less child 
					&& chain.getCurrentNode().getMoreNode() == null) {
				this.updateTreeNodeLink(chain.getParentNode(), 
						chain.getCurrentNode().getLessNode(), //parent child's less as new child in the same direction 
						chain.getMoveDirection());
				return true;
			}
			else if (chain.getCurrentNode().getLessNode() == null // only more child 
					&& chain.getCurrentNode().getMoreNode() != null) {
				System.out.println("got here?");
				///what if root?
				//if (chain.getParentNode() == null) {
					
				//	return true;
				//	}
				///
				this.updateTreeNodeLink(chain.getParentNode(), 
						chain.getCurrentNode().getMoreNode(), //parent child's less as new child in the same direction 
						chain.getMoveDirection());
				return true;
			}
			 // both children
			//System.out.println("and in if both - current chain - " + chain.getCurrentNode().getNodeObj().getValue());
			
			TreeNodeChain lowestChild = new TreeNodeChain(); //this block used to be ... = chain, but it messed up with ref later
			lowestChild.setCurrentNode(chain.getCurrentNode());
			lowestChild.setParentNode(chain.getParentNode());
			lowestChild.setMoveDirection(chain.getMoveDirection());
			
			//System.out.println("initial parent of chain - " + chain.getParentNode().getNodeObj().getValue());
			lowestChild.setParentNode(lowestChild.getCurrentNode());
			//System.out.println("did I update parent of chain here - " + chain.getParentNode().getNodeObj().getValue());
			lowestChild.setMoveDirection(removeStrategy); //1 or -1
			//System.out.println("and in locatino 5 - current chain - " + chain.getCurrentNode().getNodeObj().getValue());
			TreeNode ttt = TreeSet.getNextNode(
					lowestChild.getCurrentNode(),
					lowestChild.getMoveDirection()); 
			//System.out.println("ttt next node is " + ttt.getNodeObj().getValue());
			//System.out.println("current chain loca 5.5 - " + chain.getCurrentNode().getNodeObj().getValue());
			
			lowestChild.setCurrentNode(ttt); //first step
			//System.out.println("chain current node - " + chain.getCurrentNode().getNodeObj().getValue());
			//System.out.println("and lowest child current node - " + lowestChild.getCurrentNode().getNodeObj().getValue());
			TreeNode nextNode;
			while ((nextNode = TreeSet.getNextNode(
					lowestChild.getCurrentNode(),
					(-1)*removeStrategy)) != null){ //first step 
				lowestChild.setParentNode(lowestChild.getCurrentNode());
				lowestChild.setMoveDirection((-1)*removeStrategy); //changing sign
				lowestChild.setCurrentNode(nextNode);				
			} 
			//System.out.println("node after all steps - " + lowestChild.getCurrentNode().getNodeObj().getValue());
			this.remove(lowestChild.getCurrentNode().getNodeObj()); //removing lowestChild with recursion
			//TreeSet.updateTreeNodeLink(chain.getParentNode(), 
			//		lowestChild.getCurrentNode(), //parent child's less as new child in the same direction 
			//		removeStrategy);
			//System.out.println("here current chain is - " + chain.getCurrentNode().getNodeObj().getValue());
			chain.getCurrentNode().setNodeObj(lowestChild.getCurrentNode().getNodeObj());
			return true; //removed node in case of both children
		}
		return false; //value not found 
	}
	
	public void printTree() //for testing only :)
	{
		TreeNode[][] nodeMatrix = new TreeNode[10][20];
		nodeMatrix[1][1] = this.root;
		System.out.println(this.root.getNodeObj().getValue());
		TreeNode nextNode; 
		int vert = 1; 
		int hor = 1;
		int vertNext;
		int horNext;
		while (vert<=4){ //will drill till this level
			//System.out.println("first while " + vert + hor);
			while (hor <= Math.pow(2,vert-1)){
				// try less child
				vertNext = vert+1;
				horNext = hor*2-1;
				try{
					nextNode = TreeSet.getNextNode(nodeMatrix[vert][hor], -1);
					if (nextNode != null){
						nodeMatrix[vertNext][horNext] = nextNode;
						//System.out.println(nextNode);
					}
					else{
						nodeMatrix[vertNext][horNext] = new TreeNode(new StringType("0"),null,null);
					}
					
				}
				catch (Exception e){
					nodeMatrix[vertNext][horNext] = new TreeNode(new StringType("0"),null,null);
				}
				System.out.print(nodeMatrix[vertNext][horNext].getNodeObj().getValue() + "|");// + "'" + vertNext + "'" + horNext);
				// try more child
				vertNext = vert+1;
				horNext = hor*2;
				try{
					nextNode = TreeSet.getNextNode(nodeMatrix[vert][hor], 1);
					if (nextNode != null){
						nodeMatrix[vertNext][horNext] = nextNode;
						//System.out.println(nextNode);
					}
					else{
						nodeMatrix[vertNext][horNext] = new TreeNode(new StringType("0"),null,null);
					}
					
				}
				catch (Exception e){
					nodeMatrix[vertNext][horNext] = new TreeNode(new StringType("0"),null,null);
				}
				System.out.print(nodeMatrix[vertNext][horNext].getNodeObj().getValue() + "|");// + "'" + vertNext + "'" + horNext + "|");				
				//increase counters
				hor += 1; 
				}
			System.out.println("");//adding new line
			vert += 1;
			hor = 1;
			}
		}
}
