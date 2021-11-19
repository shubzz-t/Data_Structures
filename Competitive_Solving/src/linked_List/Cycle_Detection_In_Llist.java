package linked_List;

public class Cycle_Detection_In_Llist {

	public static void main(String[] args) {
		// CHECKING FOR CIRCULAR LINKED LIST
		Simple_Linked_List s = new Simple_Linked_List();
		s.insert(22);
		s.insert(23);
		s.insert(24);
		s.insert(25);
		s.insert(26);
		s.insert(27);
		s.insert(28);
		boolean r = s.checkCircular(s.head);
		System.out.println(r);


	}

}
