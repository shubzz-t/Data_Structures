package linked_List;

public class Get_Node_Val_From_Tail {

	public static void main(String[] args) {
		Simple_Linked_List s = new Simple_Linked_List();
		s.insert(22);
		s.insert(23);
		s.insert(24);
		s.insert(25);
		s.insert(26);
		s.insert(27);
		s.insert(28);
		
		int result = s.getNodeFromTail(s.head, 3);
		System.out.println(result);
		

	}

}
