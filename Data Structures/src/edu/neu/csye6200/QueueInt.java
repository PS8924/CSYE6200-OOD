package edu.neu.csye6200;

public class QueueInt {

	int capacity;
	int count;
	int front;
	int rear;
	
	int[] arr;
	
	public QueueInt(int size) {
		arr= new int[size];
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
	
	public void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		
		rear = (rear+1)%capacity;
		arr[rear]=element;
		count++;
		
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		front = (front+1)%capacity;
		count--;
		
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}
		return arr[front];
	}
	
	public static void demo() {
		QueueInt queueInt = new QueueInt(3);
		queueInt.enqueue(15);
		queueInt.enqueue(5);
		queueInt.enqueue(10);
		
		System.out.println("Front element in queue is->"+ queueInt.peek());
		
		queueInt.enqueue(4); //Queue is full
		
		queueInt.dequeue();
		queueInt.dequeue();
		
		System.out.println("Front element in queue is->"+ queueInt.peek());
		System.out.println("Size of queue is->"+ queueInt.size());
		
		queueInt.dequeue();
		queueInt.dequeue(); // Queue is empty
		
	}
}
