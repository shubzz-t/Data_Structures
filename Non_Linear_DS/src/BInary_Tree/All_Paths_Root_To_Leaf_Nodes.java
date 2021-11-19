package BInary_Tree;

import BInary_Tree.binary_Tree.Node;

public class All_Paths_Root_To_Leaf_Nodes {

	//FUNCTION DEFINING ARRAY AND CALLING THE RECURSION FUNCTION
	void print_paths(Node root) {
		int arr[] = new int[1000];
		print_recursion(root, arr, 0);
	}

	//RECURSION FUNCTION
	private void print_recursion(Node root, int[] arr, int arrlen) {
		//BASE CASE FOR RECURSION TERMINATION
		if (root == null) {
			return;
		}

		//INSERTING THE ROOT ELEMENTS TO ARRAY
		arr[arrlen] = root.data;
		arrlen++;   //INCREASING ARR LENGTH COUNT

		//WHEN ROOT DOESNT HAVE LEFT AND RIGHT CHILD PRINT PATH
		if (root.left == null && root.right == null) {
			printarray(arr, arrlen);
		}
		//IF ROOT HAVING CHILDS TRAVERSE TILL LAST NODE
		else {
			print_recursion(root.left, arr, arrlen);
			print_recursion(root.right, arr, arrlen);
		}

	}

	//PRINTING ARRAY
	private void printarray(int[] arr, int arrlen) {
		System.out.println();
		for (int i = 0; i < arrlen; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
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
		
		All_Paths_Root_To_Leaf_Nodes l = new All_Paths_Root_To_Leaf_Nodes();
		l.print_paths(binary_Tree.root);
	}

}
