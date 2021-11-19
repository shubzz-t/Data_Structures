package BInary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import BInary_Tree.binary_Tree.Node;

public class Full_Nodes {

	//////////////////////////TO PRINT FULL NODES
	//RECURSIVE
	void print_FullNodes(Node root)
	{
		if (root == null) {
			return;
		}
		print_FullNodes(root.left);
		if (root.left != null && root.right!=null) {
			System.out.print(root.data + " ");
		}
		print_FullNodes(root.right);
	}
	
	
	
	//ITERATIVE
	void print_FullNodes_(Node root)
	{
		if (root==null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<binary_Tree.Node>();
		q.add(root);
		
		while (!q.isEmpty()) {
			root = q.poll();
			
			if (root.right!=null && root.right!=null) {
				System.out.print(root.data+" ");
			}
			if (root.left!=null) {
				q.add(root.left);
			}
			if (root.right!=null)
		     q.add(root.right);	
		}
		}
	
	
	
//////////////////////////////////TO COUNT FULL NODES???????????????????????????????????
                               // RECURSIVE
	int countFullNodes(Node root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			count++;
		}
		count += countFullNodes(root.left) + countFullNodes(root.right);
		return count;
	}

                              // ITERATIVE
	int countFullNodes_(Node root) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			root = q.poll();

			if (root.left != null && root.right != null) {
				count++;
			}
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}
		return count++;

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
		
		
		Full_Nodes f = new Full_Nodes();
		
//		// FULL NODES COUNTING
		System.out.println();
		System.out.println("NO OF FULL NODES ARE :- " + f.countFullNodes(binary_Tree.root));
		System.out.println("NO OF FULL NODES ARE :- " + f.countFullNodes_(binary_Tree.root));

		//PRINTING FULL NODES
		f.print_FullNodes(binary_Tree.root);
		System.out.println();
		f.print_FullNodes_(binary_Tree.root);
	}

}
