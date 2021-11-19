package BInary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import BInary_Tree.binary_Tree.Node;

public class Print_Odd_Level_Nodes {

	////////////////////////////////////////// RECURSION/////////////////////////////////////
	void odd_Nodes(Node root, boolean isOdd) {
		if (root == null) {
			return;
		}

		//BY DEFAULT FOR FIRST LEVEL ITS TRUE
		//IF TRUE THEN PRINT THE DATA
		if (isOdd) {
			System.out.print(root.data + " ");
		}

		//FOR SEND LEVEL IT WILL BECOME FALSE AS NEGATION !ISODD IS PROVIDES
		odd_Nodes(root.left, !isOdd);
		odd_Nodes(root.right, !isOdd);
	}

	//////////////////////////////////// ITERATIVE//////////////////////////////////////////////
	void odd_Nodes(Node root) {
		if (root == null) {
			return;
		}
//EMPTY QUEUE FOR LEVEL ORDER TRAVERSAL
		Queue<Node> q = new LinkedList<binary_Tree.Node>();
		q.add(root);

		boolean isOdd = true;

//FOR THE FIRST LEVEL IS ODD TRUE AS ITS ODD LEVEL
		while (true) {
			int node_Count = q.size(); // COUNT OF ELMENTS INSIDE QUEUE
			if (node_Count == 0) { // WHEN NO ELEMENTS INSIDE QUEUE BREAK
				break;
			}
//TILL THE QUEUE BECOMES EMPTY RUN THE BELOW CONDITIONS
			while (node_Count > 0) {
				Node temp = q.peek();
				if (isOdd == true) { // PRINT THE DATA ONLY IF VALUE IS TRUE
					System.out.print(temp.data + " ");
				}
				q.remove(); // REMOVE THE DATA
				if (temp.left != null) { // STORE THE LEFT CHILD IF NOT NULL
					q.add(temp.left);
				}
				if (temp.right != null) { // STORE THE RIGHT CHILD IF NOT NULL
					q.add(temp.right);
				}
				node_Count--; // DECREMENT THE NODES COUNT IN QUEUE
			}
			isOdd = !isOdd; // MAKE THE VALUE FALSE AS NEXT IS EVEN LEVEL
		}
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
		System.out.println();

		Print_Odd_Level_Nodes p = new Print_Odd_Level_Nodes();

		// RECURSIVE
//		p.odd_Nodes(binary_Tree.root, true);

		// ITERATIVE
		p.odd_Nodes(binary_Tree.root);
	}
}
