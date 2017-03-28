package treeSet;

public class TreeNodeChain {
	private TreeNode parentNode;
	private TreeNode currentNode;
	private int moveDirection;
	
	public int getMoveDirection() {
		return moveDirection;
	}
	public void setMoveDirection(int moveDirection) {
		this.moveDirection = moveDirection;
	}
	public TreeNode getParentNode() {
		return parentNode;
	}
	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}
	public TreeNode getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(TreeNode currentNode) {
		this.currentNode = currentNode;
	}
}
