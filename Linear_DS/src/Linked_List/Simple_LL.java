package Linked_List;


public class Simple_LL {
	Node head;

	// INSERT THE NODE IN LINKED LIST
	void insert(int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newnode;
		}
	}

	// INSERT DATA AT THE BEGINNING
	void insertAtStart(int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
		} else {
			newnode.next = head;
			head = newnode;
		}
	}

	void insertAtIndex(int index, int data) {
		Node newnode = new Node(data);
		if (index == 0) {
			insertAtStart(data);
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}

	// SORTING LINKED LIST

	Node getMiddle(Node head) {
		if (head == null) {
			return head;
		}

		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	Node sortedMerge(Node left , Node right)
	{
		Node result;
		if (left==null) {
			return right;
		}
		if (right==null) {
			return left;
		}
		if (left.data<=right.data) {
			result=left;
			result.next = sortedMerge(left.next, right);
		}
		else {
			result=right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
		
	}

	Node merge(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMiddle(head);
		Node middleNext = middle.next;
		middle.next=null;
		
		Node left = merge(head);
		Node right = merge(middleNext);
		
		Node sorted = sortedMerge(left , right);
		return sorted;
	}

	// PRINT THE DATA IN THE LINKED LIST
	void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}

	}

	// NODES CLASS
	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		Simple_LL ll = new Simple_LL();
		
		ll.insert(3);
		ll.insert(4);
		ll.insert(1);
		ll.insert(32);
		ll.insert(14);
		ll.insert(11);
		ll.insertAtIndex(0, 555);

		ll.head = ll.merge(ll.head);
		ll.print(ll.head);
	}

}
