package queue;

public class Queue_Using_LL {
Node front,rear;
	
	
	void enqueue(int data)
	{
		Node newnode = new Node(data);
		if (rear==null) {
			front=rear=newnode;
			return;
		}
		else {
			rear.next=newnode;
			rear=newnode;
			return;
		}
	}
	
	void dequeue()
	{
		if (front==null) {
			return;
		}
		Node temp = front;
			front=front.next;
			
			if (front==null) {
				rear=null;
			}
		
	}
	
	void display()
	{
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp=temp.next;
		}
	}
	
	
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.next=null;
			this.data=data;
		}
	}

	public static void main(String[] args) {
		Queue_Using_LL ll = new Queue_Using_LL();
		ll.enqueue(1);
		ll.enqueue(2);
		ll.enqueue(3);
		ll.dequeue();
		ll.dequeue();
		ll.dequeue();
		ll.enqueue(111);
		ll.display();

	}

}
