package queue;

import java.util.ArrayList;

 class Circular_Queue_Array {

	int size, front, rear;

	ArrayList<Integer> queue = new ArrayList<Integer>();

	public Circular_Queue_Array(int size) {
		this.size = size;
		this.front = this.rear = -1;
	}

	
	///////////////////////////////ENQUEUE????????????????????????????????????????
	void enqueue(int data) {
		//// CONDITION FOR FULL QUEUE
		if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
			System.out.println("FULL QUEUE!!!!!!!!FULL QUEUE!!!!!!!!");
		}
		// EMPTY QUEUE
		else if (front == -1) {
			front = 0;
			rear = 0;
			queue.add(rear, data);
		}

		// TO ADD DATA WHEN QUEUE IS FULL BUT STARTING DATA IS EMPTY OR QEQUEUED
		else if (rear == size - 1 && front != 0) {
			rear = 0;
			//WHEN QUEUE WILL START FROM 0 THEN THE PREVIOUS DEQUEUED ELEMENTS THAT ARE NOT NEEDED HAS TO BE SET(UPDATE)
			queue.set(rear, data);
		}

		else {
			rear = (rear + 1);

			// ADDING NEW ELEMENT IF FRONT IS SMALLER THAN EQUAL TO REAR
			if (front <= rear) {
				queue.add(rear, data);
			} else {
				///WHEN FRONT IS GREATER THAN EQUAL TO REAR THEN PERVIOUS DATA WH HAVE TO UPDATE 
				queue.set(rear, data);
			}
		}
	}

	
///////////////////////////////DEQUEUE????????????????????????????????????????
	int dequeue()
	{
		//IF THE QUEUE IS EMPTY
		if (front==-1) {
			System.out.println("EMPTY QUEUE!!!!!!!");
			return -1;
		}
		
		//TO RETURN WHICH ELEMENT TO BE REMOVED
		int temp = queue.get(front);
		
		//IF ONLY ONE ELEMEMT  IS PRESENT AND THAT IS BEING REMOVED THEN
		if (front==rear) {
			front=-1;
			rear=-1;
		}
		//WHEN THE FORNT REMOVES THE LAST ELEMENT THEN AGAIN IT WILL COME TO FIRST ELEMENT
		else if (front==size-1) {
			front=0;
		}
		//IF FRONT IS NOT AT LAST THEN REMOVE(LEAVE CURRENT AND MOVE FORWARD) CURRENT AND MOVE FORWARD
		else {
			front=front+1;
		}
		return temp;
	}
	
///////////////////////////////DISPLAY????????????????????????????????????????
	void displayQueue() {
		//FOR EMPTY QUEUE
		if (front == -1) {
			System.out.println("QUEUE IS EMTY!!!!!!");
		}

		//WHEN REAR HAS NOT STARTED AGAIN FROM ZERO
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.println(queue.get(i));
			}
		}

		
		else {
			//WHEN QUEUE IS SMALLER THAN FRONT THEN AFTER FRONT THIS LOOPS WILL PRINT ELEMENTS
			for (int i = front; i <= size - 1; i++) {
				System.out.println(queue.get(i));
			}
			//BEFORE REAR THIS LOOP WILL PRINT ELEMENTS FROM 0 TO REAR
			for (int i = 0; i <= rear; i++) {
				System.out.println(queue.get(i));
			}
		}
	}

	public static void main(String[] args) {
		Circular_Queue_Array q = new Circular_Queue_Array(7);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(1);
		q.enqueue(5);
		
System.out.println("REMOVED : - " + q.dequeue());
q.enqueue(1);
q.displayQueue();
	}

}
