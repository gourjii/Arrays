package LinkedList;

import HashSet.HashSet;
import java.util.Iterator;

public class LinkedList {//implements Iterable{ // https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html

	private Node firstNode;
	private int size = 0;
	private int hash = 0; // created only for first ever element and used only in HashSet

	public boolean add(Object T)
	{
		if (this.firstNode == null)
		{
			this.firstNode = new Node(T, null);
			this.size = 1;
			this.hash = T.hashCode();
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
		if (this.firstNode == null) {return false;}
		else if (this.firstNode.getNodeObj().equals(T)) {return true;}
		else
		{
			Node currentNode = firstNode;
			while (currentNode.getNextNode() != null)
			{
				currentNode = currentNode.getNextNode();
				//System.out.println(currentNode.getNodeObj());
				if (currentNode.getNodeObj().equals(T)) {return true;}
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
	

	/*public Iterator iterator()
	{
		Iterator a = new Iterator();
		return a;
	}*/
	
	public int getHash()
	{
		return this.hash;
	}
	
	
	
	public static void main(String[] args) {
		 
		 LinkedList l = new LinkedList(); 
		 l.add("obj1");
		 l.add("obj2");
		 l.add("obj3");
		 l.add("obj4");
		 
		 System.out.println("size is " + l.size);
		 System.out.println(l.get(3));
		 System.out.println("True is " + l.contains("obj3"));
		 System.out.println("removing " + l.remove(1));
		 System.out.println("False is " + l.contains("obj3"));
		 System.out.println("new size is " + l.size);
		 
		 System.out.println("---------HashSet--------");
		 HashSet hashSet = new HashSet();
		 hashSet.add("hash1");
		 hashSet.add("hash2");
		 hashSet.add("hash3");
		 hashSet.add("hash4");
		 System.out.println("False is " + hashSet.add("hash2"));
		 l = (LinkedList) hashSet.firstListNode.getNodeObj();
		 System.out.println(l.get(0));
	 }
	 
}