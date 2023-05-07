package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class ZooAnimals implements Runnable {
		
		List<AnimalAPI> animallist = new ArrayList<>();

		@Override
		public void run() {
			System.out.println("Implementing Concrete Class!!");
			System.out.println("This is from " + getClass().getSimpleName());
			for (AnimalAPI animalAPI : animallist) {
				System.out.println(animalAPI.toString(" From Overloaded toString method."));
			}
			System.out.println();
		}
		
		public void add(AnimalAPI animal) {
			this.animallist.add(animal);
		}
		
		public String toString() {
			return null;
		}
		
		public static void ZooConcrete() {
			ZooAnimals zooAnimals = new ZooAnimals();
			zooAnimals.add(new Rabit());
			zooAnimals.add(new Tiger());
			zooAnimals.add(new Fox());
			
			zooAnimals.run();
		}
		
}