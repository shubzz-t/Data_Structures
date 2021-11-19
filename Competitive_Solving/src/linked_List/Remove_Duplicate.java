package linked_List;

import linked_List.Simple_Linked_List.Node;

public class Remove_Duplicate {

	public static void main(String[] args) {
		Simple_Linked_List s = new Simple_Linked_List();
		s.insert(1);
		s.insert(2);
		s.insert(2);
		s.insert(4);
		s.insert(4);
		s.insert(4);
		s.insert(7);
		
		s.removeDuplicates(s.head);
		s.print(s.head);
		
	}

}
