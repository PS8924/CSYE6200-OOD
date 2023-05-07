package edu.neu.csye6200;

public class StackInt {
	int top;
	int capacity;
	int [] arr;
	
	public StackInt(int size) {
		arr = new int[size];
		top=-1;
		capacity=size;
	}
	
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return (top== -1);
	}
	
	public boolean isFull() {
		return (top==capacity-1);
	}
	
	public void push(int element) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		top=top+1;
		arr[top]=element;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int element= arr[top];
		top=top-1;
		return element;
	}
	
	public int peek() {
		if(!isEmpty()) {
			return arr[top];
		} else {
			System.out.println("Stack is empty");
		}
		
		return -1;
	}
	
	public static void demo() {
		StackInt stackInt = new StackInt(5);
		stackInt.push(9);
		stackInt.push(4);
		stackInt.push(12);
		stackInt.push(2);
		stackInt.push(8);
		
		System.out.println("Top element in the stack is->"+ stackInt.peek());
		
		stackInt.push(17);
		
		System.out.println("Size of the stack is->"+ stackInt.size());
		
		stackInt.pop();
		stackInt.pop();
		
		System.out.println("Top element in the stack is->"+ stackInt.peek());
	
		stackInt.pop();
		stackInt.pop();
		stackInt.pop();
		
		stackInt.pop();
	}
}
