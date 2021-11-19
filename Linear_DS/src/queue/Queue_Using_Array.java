package queue;


class Array_Queue {
	int[] queue;
	int front , rear, capacity;

	public Array_Queue(int cap) {
	    front=rear=0;
	    capacity=cap;
	    queue = new int[capacity];
	}
	
	
	void enqueue(int data)
	{
		if (capacity==rear) {
			System.out.println("QUEUE IS FULL....");
			return;
		}
		else {
			queue[rear] = data;
			rear++;
			return;
		}
	}
	
	void dequeue()
	{
		if (front==rear) {
			System.out.println("QUEUE IS EMPTY...");
			return;
		}
		else {
			for (int i = 0; i < rear-1 ; i++) {
				queue[i]=queue[i+1];
			}
			if (rear<capacity) {
				queue[rear]=0;
				rear--;
			}
			return;
		}
		
	}
	
	
	void display()
	{
		if (front==rear) {
			System.out.println("QUEUE IS EMTPTY");
			return;
		}
		else {
			for (int i = 0; i < rear-1 ; i++) {
				System.out.println(queue[i] + " ");
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		Array_Queue a = new Array_Queue(20);
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(7);
		a.dequeue();
		a.display();
				
	}
}










