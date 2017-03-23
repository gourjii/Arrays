package HashSet;

import LinkedList.LinkedList;
import LinkedList.Node;

public class HashSet {

	public Node firstListNode; //update to private after testing
		
	private int getListNodeHash (Node a)
	{
		LinkedList b = (LinkedList) a.getNodeObj();
		return b.getHash();
	}
	
	public boolean add(Object T)
	{
		LinkedList currentList = new LinkedList();
		Node currentListNode;
		int currentHash = T.hashCode();
		
		if (this.firstListNode == null)
		{
			currentList.add(T);
			firstListNode = new Node(currentList, null);
			return true;
		}
		else if (getListNodeHash(firstListNode) == currentHash)
		{
			// hash matches: check and Add new element 
			currentList =  (LinkedList) firstListNode.getNodeObj();
			if (currentList.contains(T)) {return false;}
			else
			{
				currentList.add(T);
				return true;
			}
		}

		currentListNode = firstListNode;
		while (currentListNode.getNextNode() != null)
		{
			currentListNode = currentListNode.getNextNode();
			if (getListNodeHash(currentListNode) == currentHash)
			{
				// hash matches: check and Add new element
				currentList =  (LinkedList) currentListNode.getNodeObj();
				if (currentList.contains(T)) {return false;}
				else
				{
					currentList.add(T);
					return true;
				}
			}
		}
		//Nothing matched, adding new Node with list to the beginning
		currentList = new LinkedList();
		currentList.add(T);
		firstListNode = new Node(currentList, firstListNode);
		return true;
	}
//		boolean contains(T object);
//		T remove(T object);
	
}