package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class QueueGeneric<T> {

	int capacity;
	int count;
	int front;
	int rear;
	
	List<T> list1;
	
	public QueueGeneric(int size) {
		list1= new ArrayList<>();
		capacity= size;
		front=0;
		rear=-1;
		count=0;			
	}

	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	
	public boolean isFull() {
		return (size()==capacity);
	}
	
	public void enqueue(T element) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		
		rear = (rear+1)%capacity;
		list1.add(rear,element);
		count++;
		
	}
	
	public void dequeue() {
		
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		front = (front+1) % capacity; 
		count--;
		
	}
	
	public T peek() {
		if (isEmpty()) {
			System.exit(1);
		}
		return list1.get(front);
	}
	
	public static void demo() {
		QueueGeneric queueGeneric = new QueueGeneric(3);
		queueGeneric.enqueue(15);
		queueGeneric.enqueue("Erice");
		queueGeneric.enqueue(78.0);
		
		System.out.println("Front element in queue is->"+ queueGeneric.peek());
		
		queueGeneric.enqueue(4); //Queue is full
		
		queueGeneric.dequeue();
		
		System.out.println("Front element in queue is->"+ queueGeneric.peek());
		
		queueGeneric.dequeue();
		
		System.out.println("Front element in queue is->"+ queueGeneric.peek());
		
		System.out.println("Size of queue is->"+ queueGeneric.size());
		
		queueGeneric.dequeue();
		queueGeneric.dequeue(); // Queue is empty
		
	}
	
}
