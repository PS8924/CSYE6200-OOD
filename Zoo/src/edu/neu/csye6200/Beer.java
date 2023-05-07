package edu.neu.csye6200;

public class Beer implements AnimalisticAPI {
	String description = "Beer";

	@Override
	public void speak() {
		System.out.println(description);
	}
	
	@Override
	public String toString() {
		return description;
	}
	
	@Override
	public String toString(String str) {
		return description + str;
	}

}