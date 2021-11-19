package queue;

import java.util.Stack;


public class Queue_Using_Stack {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	void enqueue(int data)
	{
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		s1.push(data);
		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	int dequeue()
	{
		if (s1.isEmpty()) {
			System.out.println("EMPTY...");
		}
		
		int x = s1.pop();
		return x;
	}
	
	public static void main(String[] args)
	{
		Queue_Using_Stack stack = new Queue_Using_Stack();
		stack.enqueue(1);
		stack.enqueue(3);
		stack.enqueue(4);
		stack.enqueue(5);
		stack.enqueue(6);
		
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
		System.out.println(stack.dequeue());
	
		stack.enqueue(333);
		System.out.println(stack.dequeue());
	}
}
