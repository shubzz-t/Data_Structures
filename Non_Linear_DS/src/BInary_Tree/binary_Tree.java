package BInary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binary_Tree {
	static Node root;
	Scanner scan = new Scanner(System.in);

	///////////////// NODE CLASS
	static class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.left = this.right = null;
			this.data = data;
		}
	}

/////////////////////////////////CREATING THE TREE ?????????????????????????????????????????????????/
	Node createTree() {
		Node root = null;
		System.out.println("ENTER DATA:- ");
		int data = scan.nextInt();

		if (data == -1) {
			return null;
		}

		root = new Node(data);
		System.out.println("ENTER THE LEFT DATA FOR " + data);
		root.left = createTree();

		System.out.println("ENTER THE RIGHT DATA FOR " + data);
		root.right = createTree();

		return root;
	}

	/////////////////////////////// INSERTING NODES///////////////////////////////
	// INSERTING NODE INTO TREE
	void insertNode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			root = q.peek();
			q.remove();

			if (root.left == null) {
				root.left = new Node(data);
				break;
			} else {
				q.add(root.left);
			}
			if (root.right == null) {
				root.right = new Node(data);
				break;
			} else {
				q.add(root.right);
			}
		}
	}

	///////////////////////////// TRAVERSALS??????????????????????????????????????????????

	// INORDER TRAVERSAL
	void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(+root.data + " ");
		inOrder(root.right);
	}

	// PREORDER TRAVERSAL
	void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// POSTORDER TRAVERSAL
	void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	// LEVEL ORDER TRAVERSAL
	void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			root = q.poll();
			System.out.print(root.data + " ");

			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}
	}

/////////////////////////COUNTING LEAF NODES???????????????????????????????????????????
	// TO GET NO OF LEAF NODES OF BINARY TREE USING ITERATIVE METHOD
	int getLeafCount(Node root) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			root = q.poll();

			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
			if (root.left == null && root.right == null) {
				count++;
			}
		}
		return count;
	}

	// TO GET NO OF LEAF NODES OF BINARY TREE USING RECURSIVE METHOD
	int getLeafNodes_(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		return getLeafNodes_(root.left) + getLeafNodes_(root.right);
	}

	/////////////////////// COUNTING ALL NODES?????????????????????????
	int countAllNodes(Node root) {
		int count = 1;
		if (root == null) {
			return 0;
		}
		return count += countAllNodes(root.left) + countAllNodes(root.right);
	}

	////////////////////////// TO GET DEPTH & HEIGHT OF THE
	////////////////////////// TREE???????????????????????????????????????
	int maxDepth(Node root) {
		// Root being null means tree doesn't exist.
		if (root == null)
			return 0;

		// Get the depth of the left and right subtree
		// using recursion.
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		// Choose the larger one and add the root to it.
		if (leftDepth > rightDepth)
			return (leftDepth + 1);
		else
			return (rightDepth + 1);
	}

	int maxHeight(Node root) {
		if (root == null) {
			return -1;
		} else {
			int left = maxHeight(root.left); // return the height of leftsubtree
			int right = maxHeight(root.right); // return the height of rightsubtree
			if (left > right) // compare the height of left and right subtree
				return left + 1;
			else
				return right + 1;
		}
	}

	public static void main(String[] args) {

		binary_Tree b = new binary_Tree();

		// USING INSERT NODE TECHNIQUE
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

//		b.insertNode(root, 15);
		b.levelOrder(root);

		// CREATE TREE METHOD
//		Node root = b.createTree();

		// TRAVERSALS
		System.out.println();
		System.out.print("INORDER TRAVERSAL:- ");
		b.inOrder(root);
		System.out.println();
		System.out.print("PREORDER TRAVERSAL :- ");
		b.preOrder(root);
		System.out.println();
		System.out.print("POSTORDER TRAVERSAL :- ");
		b.postOrder(root);
		System.out.println();
		System.out.print("LEVEL ORDER TRAVERSAL :- ");
		b.levelOrder(root);
		System.out.println();

//		// LEAF NODES COUNTING
		System.out.println();
		System.out.print("NO OF LEAF NODES :- ");
		System.out.println(b.getLeafCount(root));
		System.out.print("NO OF LEAF NODES :- ");
		System.out.println(b.getLeafNodes_(root));

//		// COUNTING ALL NODES
		System.out.println();
		System.out.println("NO OF ALL NODES :- " + b.countAllNodes(root));

		// GETTING MAX DEPTH
		System.out.println();
		System.out.println("MAX DEPTH :- " + b.maxDepth(root));

		System.out.println();
		System.out.println("MAX HEIGHT : " + b.maxHeight(root));
	}
}
