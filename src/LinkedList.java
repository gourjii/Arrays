public class LinkedList{

	//private Node firstNode = new Node()
	private Node firstNode;
	private int size = 0;

	public boolean add(Object T)
	{
		if (this.firstNode == null)
		{
			this.firstNode = new Node(T, null);
			this.size = 1;
			return true;
		}
		else
		{
			this.firstNode = new Node(T,this.firstNode);
			this.size += 1;
			return true;
		}
	}
	
	public Object get(int index)
	{
		Node currentNode = firstNode;
		for (int i = 0; i<index; i++)
		{
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getNodeObj();//testing
	}
	
	public boolean contains(Object T)
	{
		if (this.firstNode == null)
		{
			return false;
		}
		else if (this.firstNode.getNodeObj().equals(T))
		{
			return true;
		}
		else
		{
			Node currentNode = firstNode;
			while (currentNode.getNextNode() != null)
			{
				currentNode = currentNode.getNextNode();
				//System.out.println(currentNode.getNodeObj());
				if (currentNode.getNodeObj().equals(T))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	public Object remove (int index)
	{
		Object removableObj = null;
		if (index == 0)
		{
			removableObj = this.firstNode.getNodeObj();
			this.firstNode = this.firstNode.getNextNode();
			//any way to mark the object as OK to destroy?
			size -= 1; 
			return removableObj; 
		}
		else
		{
			Node currentNode = firstNode;
			Node previousNode = null; 
			for (int i = 0; i<index; i++)
			{				
				
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			removableObj = currentNode.getNodeObj();
			previousNode.setNextNode(currentNode.getNextNode()); //Deletion itself; what about last Node?
			this.size -= 1;
			return removableObj; 
		}
	}
	//	 Адвансед задание: сделать LinkedList Iterable.
	
	 public static void main(String[] args) {
		 
		 LinkedList l = new LinkedList(); 
		 l.add("obj1");
		 l.add("obj2");
		 l.add("obj3");
		 l.add("obj4");
		 System.out.println("size is " + l.size);
		 System.out.println(l.get(3));
		 System.out.println("True should be " + l.contains("obj3"));
		 System.out.println("removing " + l.remove(1));
		 System.out.println("False should be " + l.contains("obj3"));
		 System.out.println("new size is " + l.size);
	 }
	 
}