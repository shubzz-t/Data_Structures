package stack;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_Queue {
	
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	static int count=0;
	
	void push(int data)
	{
		count++;
		q2.add(data);
		
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> q = q1;
		q1=q2;
		q2=q;
	}
	
	void pop()
	{
		if (q1.isEmpty()) {
			return;
		}
		q1.remove();
		count--;
	}
	
	int top()
	{
		if (q1.isEmpty()) {
			return -1;
		}
		else {
			return q1.peek();
		}
	}
	
	

	public static void main(String[] args) {
		
Stack_Using_Queue s1 = new Stack_Using_Queue();
s1.push(1);
s1.push(2);
s1.push(3);
s1.push(4);
s1.push(5);

System.out.println(s1.top());





	}

}
