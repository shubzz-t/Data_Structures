package queue;

public class Circular_Queue_LL {
	Node front, rear;

	
	//////////////////////////////ENQUEUE??????????????????????????????????????????????
	void enqueue(int data) {
		Node newnode = new Node(data);
		//WHEN NO ELEMENT IS PRESENT IN THE QUEUE
		if (front == null) {
			front =rear= newnode;
		}
		//INSERT WHEN THEE ARE MORE ELEMENTS PRESENT IN THE NODE
		else {
			rear.next = newnode;
			rear = newnode;
			rear.next = front;
		}
	}
	
	
	int dequeue()
	{
		//WHEN THE QUEUE IS EMPTY
		if (front==null) {
			System.out.println("QUEUE IS EMPTY.....");
		}
		
		int data;
		
		//WHEN THERE IS ONLY ONE NODE PRESENT IN THE QUEUE
		if (front==rear) {
			data=front.data;
			front=null;
			rear=null;
		}
		//WHEN QUEUE HAS MORE NO OF NODES
		else {
			Node temp = front;
			data = temp.data;
			front=front.next;
			rear.next=front;
		}
		return data;
	}
	
	
	void display()
	{
		if (front==null) {
			System.out.println("EMPTY QUEUE.......");
		}
		else {
System.out.println("QUEUE ELEMENTS :- ");
			Node temp = front;
			do {
				System.out.print(temp.data + " " );
				temp=temp.next;
			} while (temp!=front);
			System.out.println();
		}
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
Circular_Queue_LL q = new Circular_Queue_LL();
q.enqueue(1);
q.enqueue(2);
q.enqueue(3);
q.enqueue(4);
q.enqueue(5);
q.enqueue(6);
q.display();
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
System.out.println("DELETED ELEMENT :- "  + q.dequeue() );
q.display();
	}

}
