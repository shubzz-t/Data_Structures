package linked_List;

public class Sorted_Llist {
	public static void main(String[] args) {
		Simple_Linked_List s = new Simple_Linked_List();
		s.insert(22);
		s.insert(23);
		s.insert(822);
		s.insert(723);
		s.insert(622);
		s.insert(623);
		s.insert(422);
		s.insert(1223);
		s.insert(2432);
		s.insert(124);
		s.insert(2233);
		s.insert(213);



		// PRINTING SORTED LINKED LIST
		s.head = s.merge(s.head);
      s.print(s.head);

		

	}
}
