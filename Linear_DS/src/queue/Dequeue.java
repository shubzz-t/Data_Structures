package queue;

public class Dequeue {
	static final int MAX = 100;
	int rear;
	int front;
	int size;
	int[] arr;

	public Dequeue(int size) {
		arr = new int[MAX];
		this.size = size;
		this.front = -1;
		this.rear = 0;
	}

	// TO CHECK QUEUE IS FULL OR NOT
	boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	// TO CHECK IS EMPTY
	boolean isEmpty() {
		return front == -1;
	}

	// TO INSERT FRONT FRONT END
	void insertFront(int data) {
		if (isFull()) {
			System.out.println("QUEUE OVERLOADED");
		}
		// WHEN QUEUE IS TOTALLY EMPTY
		if (front == -1) {
			front = 0;
			rear = 0;
		}
		// WHEN FRONT IS AT THE FIRST POSITION WHEN INSERTING THEN
		else if (front == 0) {
			front = size - 1;
		}
		// WHEN FRONT IS IN THE ANY POSITION IN QUEUE EXCEPT 0 AND SIZE-1
		else {
			front = front - 1;
		}
		arr[front] = data;
	}

	void insertRear(int data) {
		if (isFull()) {
			System.out.println("QUEUE OVERLOADED");
		}
		// WHEN QUEUE IS EMPTY
		if (front == -1) {
			rear = 0;
			front = 0;
		}
		// WHEN REAR IS AT THE LAST INDEX
		else if (rear == size - 1) {
			rear = 0;
		}
		// WHEN REAR IS ANYWHERE EXCEPT 0 AND SIZE-1
		else {
			rear = rear + 1;
		}
		// INSERT AT REAR
		arr[rear] = data;
	}

	void deleteFront() {
		if (isEmpty()) {
			System.out.println("QUEUE UNDERFLOW");
		}
		// WHEN ONLY ONE ELEMENT IS THERE AND AFTER DELETING IT
		if (front == rear) {
			rear = -1;
			front = -1;
		}
		// WHEN FRONT REACHES THE LAST ELEMENT WHILE DELETING THEN START FROM FIRST
		// ELEMENT
		else if (front == size - 1) {
			front = 0;
		}
		// increment front by '1' to remove current front value from Deque
		else {
			front = front + 1;
		}
	}

	void deleteRear() {
		if (isEmpty()) {
			System.out.println("QUEUE UNDERFLOW");
		}
		// WHEN ONLY ONE ELEMENT IS INSERTED AND TO DELETE IT
		if (front == rear) {
			front = -1;
			rear = -1;
		}
		// WHEN BY DELETING REAR REACHES 0 INDEX THEN REAR = SIZE-1
		else if (rear == 0) {
			rear = size - 1;
		}
		// WHEN REAR IS AT MIDDLE EXCEPT STARTING 0 INDEX OR LAST INDEX
		else {
			rear = rear - 1;
		}
	}

	int getFront() {
		if (isEmpty()) {
			System.out.println("QUEUE UNDERFLOW....");
		}
		return arr[front];
	}

	int getRear() {
		if (isEmpty() || rear < 0) {
			System.out.println("QUEUE UNDERFLOW...");
		}
		return arr[rear];
	}

	public static void main(String[] args) {
      Dequeue d = new Dequeue(10);
      d.insertFront(1);
      d.insertFront(2);
      d.insertRear(3);
d.insertRear(6);
d.deleteRear();
d.deleteFront();
     System.out.println( d.getFront());
      System.out.println(d.getRear());
	}

}
