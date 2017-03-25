package hashSet;

import java.util.NoSuchElementException;

//import linkedList.LinkedList;

public class HashSet {

	private final int hashTabSize = 1000;
	private LinkedListHashable[] hashTab = new LinkedListHashable[hashTabSize];
	
	public boolean add(Object T)
	{
		int objBucket = T.hashCode()%hashTabSize;
		if (this.hashTab[objBucket] == null) //bucket is empty
			{
			this.hashTab[objBucket] = new LinkedListHashable();
			this.hashTab[objBucket].add(T);
			return true;
			}
		else if (this.hashTab[objBucket].contains(T)) // obj is in the bucket
			{return false;}
		
		this.hashTab[objBucket].add(T); //obj is not in the bucket
		return true;
	}

	public boolean contains(Object T)
	{
		int objBucket = T.hashCode()%this.hashTabSize;
		if (this.hashTab[objBucket] == null) {return false;} //bucket is empty
		else if (this.hashTab[objBucket].contains(T)) 
			{return true;} // obj is in the bucket
		return false; //obj is not in the bucket
	}

	public boolean remove(Object T)
	{
		int objBucket = T.hashCode()%this.hashTabSize;
		try
		{
			int index = this.hashTab[objBucket].containsPosition(T);
			this.hashTab[objBucket].remove(index);
			return true;
		}
		catch (NoSuchElementException t) {return false;}
	}
	
}
