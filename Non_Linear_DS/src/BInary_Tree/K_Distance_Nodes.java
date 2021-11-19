package BInary_Tree;

import BInary_Tree.binary_Tree.Node;

public class K_Distance_Nodes {
	
	 void print_K_Distant(Node root , int k)
	{
		if (root==null || k<0) {
			return;
		}
		
		if (k==0) {
			System.out.print(root.data + " ");
			return;
		}
		print_K_Distant(root.left, k-1);
		print_K_Distant(root.right, k-1);
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
		
K_Distance_Nodes k = new K_Distance_Nodes();
System.out.println();
System.out.println("NODES AT K DISTANCE :- ");
k.print_K_Distant(binary_Tree.root, 2);
	}

}
