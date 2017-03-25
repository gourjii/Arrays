package App;

import hashSet.HashSet;
import linkedList.LinkedList;

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
		ArraysApp.testLinkedList();
		ArraysApp.testHashSet();
	}
}
