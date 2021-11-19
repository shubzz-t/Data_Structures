package linked_List;

public class Simple_Linked_List {
	Node head;

	// INSERTING NEW NODE
	void insert(int data) {
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newnode;

	}

	void insertStart(int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			return;
		} else {
			newnode.next = head;
			head = newnode;
		}

	}

	void insertAt(int index, int data) {
		Node newnode = new Node(data);
		if (index == 0) {
			insertStart(data);
		} else {
			Node temp = head;

			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}

	void deleteStart() {
		head = head.next;
	}

	void deleteEnd() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}

	void deleteAt(int index) {
		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}

	void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

	void search(int data) {
		int count = 0;
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == data) {
				System.out.println("DATA FOUND AT INDEX :- " + count);
			}
			count++;
			temp = temp.next;
		}
		System.out.println("NO DATA FOUND..");
	}

	Node sort(Node left, Node right) {
		Node result;
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		if (left.data <= right.data) {
			result = left;
			result.next = sort(left.next, right);

		} else {
			result = right;
			result.next = sort(left, right.next);
		}
		return result;
	}

	Node getMiddle(Node head) {
		if (head == null) {
			return head;
		} else {
			Node slow = head;
			Node fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

	}

	Node merge(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMiddle(head);
		Node middleNext = middle.next;
		middle.next = null;

		Node left = merge(head);
		Node right = merge(middleNext);

		Node sorted = sort(left, right);
		return sorted;

	}

	// #################################HACKER RANK

	// Q REVERSE THE ELEMENT OF LINKED LIST
	void reverseElements(Node head) {
		if (head == null) {
			return;
		}
		reverseElements(head.next);
		System.out.println(head.data);
	}

	// Q REVERSE LINKED LIST DIRECTION
	Node reverseDirection(Node head) {
		Node current = head;
		Node next = null;
		Node prev = null;

		if (head == null) {
			return null;
		} else {
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;

			}
			return prev;
		}

	}

	boolean checkCircular(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	// Q COMPARE TWO LINKED LISTS
	boolean compare(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1 == null || head2 == null) {
			return false;
		}
		if (head1.data == head2.data)
			return compare(head1.next, head2.next);
		return false;

	}

	// Q MERGE TWO LINKED LISTS
	Node merge(Node head1, Node head2) {
		Node result;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.data <= head2.data) {
			result = head1;
			result.next = merge(head1.next, head2);
		} else {
			result = head2;
			result.next = merge(head1, head2.next);
		}
		return result;
	}

	// Q GET VALUE OF NODE STARTING FROM TAIL
	int getNodeFromTail(Node head, int position) {
		Node temp = head;
		for (int i = 0; head.next != null; i++) {

			head= head.next;
			if (i >= position) {
				temp = temp.next;
			}
		}
		return temp.data;
	}

	
	//REMOVE DUPLICATE ELEMENTS FROM Linked List
	Node removeDuplicates(Node head) {
		  if(head==null || head.next==null)
		  {return head;}
		  
		    Node temp = head;
		    while(temp.next != null)
		    {
		        if(temp.data != temp.next.data)
		        {
		            temp = temp.next;
		        }
		        else{
		            temp.next = temp.next.next;
		        }
		    }
		  return head;
		   }
	
	//Q FIND THE MERGE POINT OF TWO LINKED LISTS
	int mergePoint(Node headA , Node headB)
	{
		Node currentA = headA;
		Node currentB = headB;
		
		while (currentA != currentB) {
			if (currentA.next == null) {
				currentA=headB;
			}
			else {
				currentA=currentA.next;
			}
			
			if (currentB.next == null) {
				currentB=headA;
			}
			else {
				currentB=currentB.next;
			}
		}
		return currentB.data;
	}

static class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	}

	public static void main(String[] args) {
		

//		s.insertStart(11);
//		s.insertAt(2, 24);
//		s.deleteEnd();
//		s.deleteAt(6);
//		s.search(1223);

		// REVERSED DIRECTION
//		System.out.println("REVERSED DIRECTION OF LINKED LIST");
//		s.head=s.reverseDirection(s.head);

		
	}

}






//reverse doubly linked list
//public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) 
//{
//  DoublyLinkedListNode temp = head;
// DoublyLinkedListNode current = head;
// 
// while(current != null)
// {
//     temp = current.prev;
//     current.prev = current.next;
//     current.next = temp;
//     current = current.prev;
// }
// 
// if(temp!=null)
// {
//     head = temp.prev;
// }
// return head;
//}
 

//INSERTING A NODE IN DOUBLY
//public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
//    DoublyLinkedListNode n = new DoublyLinkedListNode(data);
//   
//    if (head == null) {
//        return n;
//    }
//    else if (data <= head.data) {
//        n.next = head;
//        head.prev = n;
//        return n;
//    }
//    else {
//        DoublyLinkedListNode newnode = sortedInsert(head.next, data);
//        head.next = newnode;
//        newnode.prev = head;
//        return head;
//    }
//    
//    }


