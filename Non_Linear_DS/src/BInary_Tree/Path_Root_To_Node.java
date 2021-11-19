package BInary_Tree;

import java.util.ArrayList;

import BInary_Tree.binary_Tree.Node;
import bST.Binary_Search_Tree;

public class Path_Root_To_Node {

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	//PRINTING PATH
	void print_Path(Node root, int x) {
		ArrayList<Integer> l = new ArrayList<Integer>();

		//IF WE HAVE THE PATH PRINT IT
		if (hasPath(root, l, x)) {
			System.out.println();
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i) + "-->");
			}
		} 
		//IF PATH IS NOT THERE
		else {
			System.out.println("NO PATH AVAILABLE FOR " + x);
		}
	}
	
	

	//CHECKING IF THE NODE HAS PATH AND STORING NODE DATA IN ARRAY IF HAVING PATH
	private boolean hasPath(Node root, ArrayList<Integer> l, int x) {
	
		//IF ROOT IS NULL NO PATH RETURN FALSE
		if (root == null) {
			return false;
		}
		
        //ADD THE DATA TO THE ARRAY
		l.add(root.data);

		//IF ROOT DATA AND THE GIVEN DATA IS EQUAL RETURN TRUE
		if (root.data == x) {
			return true;
		}

		//CHECK IF THE REQUIRED DATA IS IN THE LEFT SIDE OR RIGHT SIDE IF FALSE THEN NO ELEMENT WILL
		//BE ADDED TO THE ARRAY
		//THE CONDITION WHICH IS FALSE THAT CONDITION ELEMENT WILL NOT BE ADDED , ELEMENT WITH THE TRUE CONDITIONS WILL BE ADDED
		if (hasPath(root.left, l, x) || hasPath(root.right, l, x)) {
			return true;
		}

		//  // required node does not lie either in the 
        // left or right subtree of the current node
        // Thus, remove current node's value from 
        // 'arr'and then return false  
		l.remove(l.size() - 1);
		return false;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//DISTANCE FROM ROOT TO THE GIVEN  NODE
	
	int findDistance(Node root , int x)
	{
		//IF NULL RETURN -1
		if (root == null) {
			return -1;
		}
		
		//DISTANCE AS -1
		int dist = -1;
		
		//IF ANY ONE CONDITION TRUE THE RETURN +1
		//1ST CONDN WILL BE TRUE WHEN WE GET THE NODE TILL WHICH WE WANT TO GET DISTANCE TILL WE GET THAT OTHER TWO WILL ALWAYS BE FALSE ONLY
		if ((root.data==x) || 
				(dist = findDistance(root.left, x)) >= 0 ||  
				(dist= findDistance(root.right, x)) >=0)  
		{
			return dist +1;
		}
		return dist;
	}
	
	
	
	public static void main(String[] args) {
		binary_Tree b = new binary_Tree();

		// USING INSERT NODE TECHNIQUE
		binary_Tree.root = new Node(1);
		binary_Tree.root.left = new Node(2);
		binary_Tree.root.right = new Node(3);
		binary_Tree.root.left.left = new Node(4);
		binary_Tree.root.left.right = new Node(7);
		binary_Tree.root.right.left = new Node(12);
		binary_Tree.root.right.right = new Node(13);

		b.preOrder(binary_Tree.root);

		Path_Root_To_Node p = new Path_Root_To_Node();
		
		
		p.print_Path(binary_Tree.root, 7);
		System.out.println();
		System.out.println("DISTANCE IS :- " + p.findDistance(binary_Tree.root, 7));

	}

}
