package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******Queue Data Structure for int data types******");
		QueueInt.demo();
		
		System.out.println("******Queue data structure for a Generic T data type******");
		QueueGeneric.demo();
		
		System.out.println("******Stack data structure for int data types******");
		StackInt.demo();
		
		System.out.println("******Stack data structure for a Generic T data type******");
		StackGeneric.demo();
	}
}

//Output
//Queue is empty
//******Stack data structure for int data types******
//Top element in the stack is->8
//Stack is full
//Size of the stack is->5
//Top element in the stack is->12
//Stack is empty
//******Stack data structure for a Generic T data type******
//Size of the stack is->5
//Top element in the stack is->8.7
//Stack is full
//Top element in the stack is->Soniya
//Stack is empty