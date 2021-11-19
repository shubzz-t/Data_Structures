package BInary_Tree;

import java.util.ArrayList;

import BInary_Tree.binary_Tree.Node;

public class Ancestors_To_Given_Node {
	boolean print_Ancestors(Node root, int x) {

		if (root == null) {
			return false;
		}

		if (root.data == x) {
			return true;
		}
		if (print_Ancestors(root.left, x) || print_Ancestors(root.right, x)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
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

		Ancestors_To_Given_Node a = new Ancestors_To_Given_Node();
		System.out.println();
		a.print_Ancestors(binary_Tree.root, 4);
	}

}
