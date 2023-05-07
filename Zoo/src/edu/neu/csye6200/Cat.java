package edu.neu.csye6200;

public class Cat extends AbstractAnimalAPI {
	
	String description = "Cat";

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