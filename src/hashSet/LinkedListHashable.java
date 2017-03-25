package hashSet;

import java.util.NoSuchElementException;

import linkedList.LinkedList;
import linkedList.Node;

public class LinkedListHashable extends LinkedList{

	public int containsPosition(Object T)
	{
		if (this.size == 0) {throw new NoSuchElementException();}
		else if (this.firstNode.getNodeObj().equals(T)) {return 0;}
		
		Node currentNode = this.firstNode;
		int index = 0;
		while (index < this.size - 1)
		{
			currentNode = currentNode.getNextNode();
			index += 1;
			if (currentNode.getNodeObj().equals(T)) {return index;}
		}
		throw new NoSuchElementException();
	}
}
