package treeSet;

public class StringType implements Comparable<StringType>{
	String value;

	public StringType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	} 
	
	public int compareTo(StringType b)
	{
		return this.value.compareTo(b.value);
	}
}
