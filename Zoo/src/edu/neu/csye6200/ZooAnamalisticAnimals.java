package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class ZooAnamalisticAnimals implements Runnable{

	List<AnimalisticAPI> animallist = new ArrayList<>();

	@Override
	public void run() {
		System.out.println("Implementing Interface!!");
		System.out.println("This is from " + getClass().getSimpleName());
		for (AnimalisticAPI animalisticAPI : animallist) {
			System.out.println(animalisticAPI.toString(" From Overloaded toString method."));
		}
		System.out.println();
	}
	
	public void add(AnimalisticAPI animal) {
		this.animallist.add(animal);
	}
	
	@Override
	public String toString() {
		String str = this.getClass().getName();
		return str;
	}
	
	public static void ZooAnamalistic() {
		ZooAnamalisticAnimals zooAnamalisticAnimals = new ZooAnamalisticAnimals();
		zooAnamalisticAnimals.add(new Panther());
		zooAnamalisticAnimals.add(new Wolf());
		zooAnamalisticAnimals.add(new Beer());
		
		zooAnamalisticAnimals.run();
	}
}