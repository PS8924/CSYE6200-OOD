package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class StackGeneric<T> {
	int top;
	int capacity;
	List<T> list1;
	
	public StackGeneric(int size) {
		this.list1 = new ArrayList<>();
		this.capacity = size;
		this.top = -1;
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
	
	public void push(T element) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		top = top +1;
		list1.add(top,element);
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
			list1.remove(top);
			top = top - 1;
		if(top >= 0)
		{
		 return list1.get(top);
		}
		return null;
	}
	
	public T peek() {
		if(!isEmpty()) {
			return list1.get(top);
		} else {
			System.exit(1);
		}
		
		return null;
	}
	
	public static void demo() {
		StackGeneric stackGeneric = new StackGeneric(5);
		stackGeneric.push(9);
		stackGeneric.push("Neel");
		stackGeneric.push(12.6);
		stackGeneric.push("Soniya");
		stackGeneric.push(8.7);
		
		System.out.println("Size of the stack is->"+ stackGeneric.size());
		System.out.println("Top element in the stack is->"+ stackGeneric.peek());
		
		stackGeneric.push(17); // Stack is full
		
		stackGeneric.pop();
		System.out.println("Top element in the stack is->"+ stackGeneric.peek());
		
		stackGeneric.pop();
		stackGeneric.pop();
		stackGeneric.pop();
		stackGeneric.pop();
		
		stackGeneric.pop(); // Stack is empty
	}
	
}
