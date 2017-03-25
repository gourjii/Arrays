package linkedList;

import java.util.NoSuchElementException;

//import java.util.Iterator;

public class LinkedList {//implements Iterable{ // https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html

	protected Node firstNode;
	protected int size = 0; // add checks if index is above size etc.

	public int getSize() {return size;}
	
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
		if (index > size - 1) {throw new NoSuchElementException();}
		Node currentNode = firstNode;
		for (int i = 0; i<index; i++)
		{
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getNodeObj();//testing
	}
	
	public boolean contains(Object T)
	{
		if (this.firstNode == null) {return false;}
		else if (this.firstNode.getNodeObj().equals(T)) {return true;}
		else
		{
			Node currentNode = firstNode;
			while (currentNode.getNextNode() != null)
			{
				currentNode = currentNode.getNextNode();
				if (currentNode.getNodeObj().equals(T)) {return true;}
			}
			return false;
		}
	}
	
	public Object remove (int index)
	{
		if (index > size - 1) {throw new NoSuchElementException();}
		Object removableObj = null;
		if (index == 0)
		{
			removableObj = this.firstNode.getNodeObj();
			if (this.size == 1) 
				{
					this.firstNode = null;
					this.size = 0;
					return removableObj;
				}
			
			this.firstNode = this.firstNode.getNextNode();
			//any way to mark the object as OK to destroy?
			size -= 1; 
			return removableObj; 
		}
		Node currentNode = firstNode;
		Node previousNode = null; 
		for (int i = 0; i<index; i++)
		{				
			
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		removableObj = currentNode.getNodeObj();
		if (currentNode.getNextNode() == null)
		{
			previousNode.setNextNode(null);
			size -= 1;
			return removableObj; 
		}
		previousNode.setNextNode(currentNode.getNextNode()); //Deletion itself; what about last Node?
		this.size -= 1;
		return removableObj; 
	}
	
	//	 Адвансед задание: сделать LinkedList Iterable.
	

	/*public Iterator iterator()
	{
		Iterator a = new Iterator();
		return a;
	}*/
	
}