package treeSet;

public class TreeNode {
	private StringType nodeObj;
	private TreeNode lessNode;
	private TreeNode moreNode;
	
	public StringType getNodeObj() {
		return nodeObj;
	}
	public void setNodeObj(StringType nodeObj) {
		this.nodeObj = nodeObj;
	}
	public TreeNode getLessNode() {
		return lessNode;
	}
	public void setLessNode(TreeNode lessNode) {
		this.lessNode = lessNode;
	}
	public TreeNode getMoreNode() {
		return moreNode;
	}
	public void setMoreNode(TreeNode moreNode) {
		this.moreNode = moreNode;
	}
	
	public TreeNode(StringType nodeObj, TreeNode lessNode, TreeNode moreNode) { //implement constructor
		this.nodeObj = nodeObj;
		this.lessNode = lessNode;
		this.moreNode = moreNode;
	}
	
	
	
}
