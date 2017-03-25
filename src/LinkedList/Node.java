package linkedList;

public class Node {
		private Object nodeObj;
		private Node nextNode;
		
		public Node(Object nodeObj, Node nextNode)
		{
			this.nodeObj = nodeObj;
			this.nextNode = nextNode;
		}
		
		/*public void setNodeObj (Object nodeObj)
		{
			this.nodeObj = nodeObj;
		}*/
		
		public void setNextNode (Node nextNode)
		{
			this.nextNode = nextNode;
		}
		
		public Object getNodeObj ()
		{
			return this.nodeObj;
		}
		
		public Node getNextNode ()
		{
			return this.nextNode;
		}
		
}
