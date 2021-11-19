package linked_List;

public class Compare_Two_Llist {
	public static void main(String[] args) {
		// COMPARE TWO LISTS
		Simple_Linked_List t = new Simple_Linked_List();
		t.insert(22);
		t.insert(23);
		t.insert(822);
		t.insert(723);
		t.insert(622);
		t.insert(623);
		t.insert(422);
		t.insert(1223);
		t.insert(2432);
		t.insert(124);
		t.insert(2233);
		t.insert(213);
		
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
//		s.insert(213);

		boolean compare = t.compare(s.head, t.head);
		System.out.println(compare);
		
	}
}
