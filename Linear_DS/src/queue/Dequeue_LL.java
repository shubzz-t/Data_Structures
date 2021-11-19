package queue;

public class Dequeue_LL {
	Node front, rear;
	int size;

	public Dequeue_LL() {
		this.front = this.rear = null;
		this.size = 0;
	}

	
	//IS EMPTY FUNCTION
	boolean isEmpty() {
		return (front == null);
	}

	//SIZE FUNCTION
	int size() {
		return size;
	}

	//INSERT AT FRONT FUNCTION
	void insertAtFront(int data) {
		Node newnode = new Node(data);
		if (front == null) {
			front = rear = newnode;
		} else {
			newnode.next = front;
			front.prev = newnode;
			front = newnode;
		}
		size++;
	}

	//InsertAT REAR FUNCTION
	void insertAtRear(int data) {
		Node newnode = new Node(data);
		if (rear == null) {
			front = rear = newnode;
		} else {
			rear.next = newnode;
			newnode.prev = rear;
			rear = newnode;
		}
		size++;
	}

	//DELETE FRONT FUNCTION
	void deleteFront() {

		if (isEmpty()) {
			System.out.println("QUEUE UNDERFLOW");
		} else {
			front = front.next;
			if (front == null) {
				rear = null;
			} else {
				front.prev = null;
			}
		}
		size--;

	}

	//DELETE THE REAR ELEMENT
	void deleteRear() {
		if (isEmpty()) {
			System.out.println("QUEUE UNDERFLOW");
		} else {

			rear = rear.prev;
			if (rear == null) {
				front = null;
			} else {
				rear.next = null;
			}
		}
		size--;
	}

	//GET THE FRONT ELEMENT
	int getFront()
	{
		if (isEmpty()) {
			return -1;
		}
		return front.data;
	}
	
	//GET THE REAR ELEMENT
	int getRear()
	{
		if (isEmpty()) {
			return -1;
		}
		return rear.data;
	}
	
	//DISPLAY THE ELEMETS
	void display()
	{
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp=temp.next;
		}
	}
	class Node {
		Node next, prev;
		int data;

		public Node(int data) {
			this.next = null;
			this.prev = null;
			this.data = data;
		}

	}
///MAIN
	public static void main(String[] args) {
Dequeue_LL d = new Dequeue_LL();
d.insertAtFront(1);
d.insertAtFront(2);
d.insertAtFront(3);
d.insertAtRear(4);
d.insertAtRear(5);
d.insertAtRear(6);
d.deleteFront();
d.deleteRear();
d.deleteFront();
d.deleteRear();
d.deleteFront();
d.deleteRear();
d.deleteFront();
d.deleteRear();
d.insertAtFront(2);
d.insertAtFront(3);
d.insertAtRear(5);
d.insertAtRear(6);

d.display();

	}

}
