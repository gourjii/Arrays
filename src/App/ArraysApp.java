package App;

import hashSet.HashSet;
import treeSet.StringType;
import linkedList.LinkedList;
import treeSet.TreeSet;

public class ArraysApp {

	public static void testLinkedList() //only for testing purposes
	{
		System.out.println("---------LinkedList--------");
		LinkedList l = new LinkedList(); 
		l.add("obj1");
		l.add("obj2");
		l.add("obj3");
		l.add("obj4");		
		System.out.println("value with index==3 is: " + l.get(3));
		System.out.println("Contains: True is " + l.contains("obj3"));
		System.out.println("Removing: obj3 is " + l.remove(1));
		System.out.println("Contains: False is " + l.contains("obj3"));
	}
	
	public static void testHashSet() //only for testing purposes
	{
		System.out.println("---------HashSet--------");
		HashSet hashSet = new HashSet();
		hashSet.add("hash1");
		hashSet.add("hash2");
		hashSet.add("hash3");
		hashSet.add("hash4");
		System.out.println("Add: False is " + hashSet.add("hash2"));
		System.out.println("Contains: True is " + hashSet.contains("hash3"));
		System.out.println("have I removed it? " + hashSet.remove("hash3"));
		System.out.println("False is " + hashSet.contains("hash3"));
	}
	
	public static void main(String[] args) {	
		//ArraysApp.testLinkedList();
		//ArraysApp.testHashSet();
		
		TreeSet tree = new TreeSet();
		tree.add(new StringType("delta"));
		tree.add(new StringType("xylophone"));
		tree.add(new StringType("hotel"));
		
		
		System.out.println(tree.root.getMoreNode().getLessNode());
		
		System.out.println("current root is " + tree.root.getNodeObj().getValue()
				+ ", 2: " + tree.root.getMoreNode().getNodeObj().getValue()
				+ " 3: " + tree.root.getMoreNode().getLessNode().getNodeObj().getValue()); 
		//System.out.println("adding 2nd val: " + tree.add(text));
		//text.setValue("delta");
		//tree.add(text)
		//System.out.println("added successfully");
		//System.out.println("1: " + tree.root.getNodeObj());
		//+ " 3: " + tree.root.getMoreNode().getLessNode().getNodeObj());
	}
}
