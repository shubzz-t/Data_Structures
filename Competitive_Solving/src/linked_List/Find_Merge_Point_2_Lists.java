package linked_List;

import linked_List.Simple_Linked_List.Node;

public class Find_Merge_Point_2_Lists {
	public static void main(String[] args)
	{
		Simple_Linked_List s = new Simple_Linked_List();
		s.insert(22);
		s.insert(23);
		s.insert(24);
		s.insert(25);
		s.insert(26);
		s.insert(27);
		s.insert(28);
		
		
		Simple_Linked_List t = new Simple_Linked_List();
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(25);
		t.insert(26);
		t.insert(27);
		t.insert(28);

		//BOTH LISTS SHOULD BE MERGED FOR THIS
		
		int result = s.mergePoint(s.head, t.head);
		System.out.println(result);
	}

}
