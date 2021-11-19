package linked_List;
import linked_List.Simple_Linked_List;
import linked_List.Simple_Linked_List.Node;



public class Merge_Two_Sorted_Llist {

public static void main(String[] args)
{
	Simple_Linked_List s = new Simple_Linked_List();
	s.insert(7);
	s.insert(8);
	s.insert(9);
	s.insert(10);
	s.insert(11);
	s.insert(12);
	s.insert(13);
	
	
	Simple_Linked_List t = new Simple_Linked_List();
	t.insert(1);
	t.insert(3);
	t.insert(4);
	t.insert(5);
	t.insert(6);
	t.insert(9);
	t.insert(18);

	
	s.merge(s.head, t.head);
	int result = s.mergePoint(s.head, t.head);
	System.out.println(result);
			
}

}
