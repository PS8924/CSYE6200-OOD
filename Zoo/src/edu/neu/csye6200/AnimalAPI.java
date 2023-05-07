package edu.neu.csye6200;

public class AnimalAPI {
	public void speak() {
		System.out.println("Animal!");
	}
	
	@Override
	public String toString() {
		
		return "This is" + getClass().getSimpleName();
	}
	
	public String toString(String str) {
		System.out.println();
		return "I'm an animal, derived from " + str;
		
	}
}
