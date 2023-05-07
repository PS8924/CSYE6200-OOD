package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class ZooAbstractAnimals implements Runnable{
	
	List<AbstractAnimalAPI> animallist = new ArrayList<>();

	@Override
	public void run() {
		System.out.println("Implementing Abstract Class!!");
		System.out.println("This is from " + getClass().getSimpleName());
		for (AbstractAnimalAPI abstractAnimalAPI : animallist) {
			System.out.println(abstractAnimalAPI.toString(" From Overloaded toString method."));
		}
		System.out.println();
	}
	
	public void add(AbstractAnimalAPI animal) {
		this.animallist.add(animal);
	}
	
	public String toString() {
		return null;
	}
	
	public static void ZooAbstract() {
		ZooAbstractAnimals zooAbstractAnimals = new ZooAbstractAnimals();
		zooAbstractAnimals.add(new Cat());
		zooAbstractAnimals.add(new Cow());
		zooAbstractAnimals.add(new Lion());
		
		zooAbstractAnimals.run();
	}

}