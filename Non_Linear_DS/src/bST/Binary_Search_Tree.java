package bST;


public class Binary_Search_Tree {
	public Node root;

	//////////// INSERTING THE NODE
	public void insert(int data) {
		root = insertNode(root, data);
	}

	Node insertNode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (root.data > data) {
			root.left = insertNode(root.left, data);
		} else if (root.data < data) {
			root.right = insertNode(root.right, data);
		}
		return root;
	}

	// INSERTING WITH LOOP
	void insert(Node root, int data) {
		Node newnode = new Node(data);
		if (root == null) {
			root = newnode;
			return;
		}
		Node prev = null;
		Node temp = root;
		while (temp != null) {
			if (temp.data > data) {
				prev = temp;
				temp = temp.left;
			} else if (temp.data < data) {
				prev = temp;
				temp = temp.right;
			}
		}
		if (prev.data > data) {
			prev.left = newnode;
		} else {
			prev.right = newnode;
		}
	}

	///////// DELETING THE NODE
	Node delete(Node root, int data) {
		if (root == null) {
			return root;
		}

		// IF DATA SMALLER THAN ROOT DATA GO TO LEFT SIDE
		if (data < root.data) {
			root.left = delete(root.left, data);
		}
		// IF DATA GREATER THAN ROOT DATA GO TO RIGHT SIDE
		else if (data > root.data) {
			root.right = delete(root.right, data);

			// CONDITION WHEN DATA IS NOT GREATER NOR SMALL MEANS IT IS EQUAL THAN
			// HERE ROOT IS THE NODE WHICH WE WANT TO DELETE
		} else {
			// CHECK IF THE ROOT WITH DATA(TO BE DELETED) HAS 2 CHILDRENS
			if (root.left != null && root.right != null) {
				int lmax = max(root.left);
				root.data = lmax;
				root.left = delete(root.left, lmax);
				return root;
				// WHEN THE ROOT HAS ONLY LEFT CHILD
			} else if (root.left != null) {

				return root.left;
				// WHEN THE ROOT HAS ONLY RIGHT CHILD
			} else if (root.right != null) {

				return root.right;
			}
			// WHEN THE ROOT DOESNT HAS ANY CHILD
			else {

				return null;
			}
		}
		return root;

	}

	// DELETING THE NODE OPTIMIZED SOLUTION
	Node delete_(Node root, int data) {
		if (root == null) {
			return root;
		}

		// CONDITIONS TO GO TO THE NODE WHICH WE WANT TO DELETE
		// IF SMALLER THAN ROOT NODE
		if (data < root.data) {
			root.left = delete(root.left, data);
			return root;
		}
		// IF NODE GREATER THAN ROOT NODE
		else if (data > root.data) {
			root.right = delete(root.right, data);
			return root;
		}

		// FROM NOW THE ROOT NODE IS THE NODE WHICH WE WANT TO DELETE
		// WHEN THE ROOT HAS LEFT OR RIGHT CHILD ONLY
		if (root.left == null) {
			Node temp = root.right;
			return temp;
		} else if (root.right == null) {
			Node temp = root.left;
			return temp;
		}
		// WHEN THE ROOT HAS TWO CHILDS OR NO CHILDS THEN
		else {
			Node succP = root;
			Node succ = root.right;
			// GETTING THE RIGHT CHILDS LEFTMOST NODE TO REPLACE DELETED NODE AS
			// IT WILL BE THE GREATER NODE THAN THE DELETED ONE WHICH WILL FIT ITS PLACE
			while (succ.left != null) {
				succP = succ;
				succ = succ.left;
			}

			// DELETING THE LEFTMOST NODE AS WE WANT TO TAKE IN DELETED NODES PLACE
			if (succP != root) {
				succP.left = succ.right;
			}
			// WHEN THE NODE DOESNT HAVE LEFTMOST NODE OR ROOT WITHOUT NODES
			else {
				succP.right = succ.right;
			}
			// REPLACE THE DELETED NODE BY LEFTMOST NODE
			root.data = succ.data;
			return root;
		}
	}

	private int max(Node root) {
		if (root.right != null) {
			return max(root.right);
		} else {

			return root.data;
		}
	}

	///////////////// INORDER TRAVERSAL
	 public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);

		}

	}

	/////////////// SEARCHING THE NODE
	String search(Node root, int dataa) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.data == dataa) {
			return "DATA FOUND  " + root;
		}
		// Key is smaller than root's key
		if (root.data > dataa) {
			return search(root.left, dataa);
		}
		// Key is greater than root's key
		return search(root.right, dataa);

	}

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;

		}
	}

	public static void main(String[] args) {
		Binary_Search_Tree b = new Binary_Search_Tree();
		b.insert(10);
		b.insert(6);
		b.insert(8);
		b.insert(2);
		b.insert(12);
		b.insert(11);
		b.insert(13);
		b.insert(b.root, 14);
		b.insert(b.root, 15);
		b.insert(b.root, 3);

		b.inOrder(b.root);
		System.out.println();

		// DELETE
//		b.delete(b.root, 10);

		// OPTIMIZED DELETE
		b.delete_(b.root, 14);

		b.delete_(b.root, 10);
		

		System.out.println("AFTER DELETE.....");

		b.inOrder(b.root);
		System.out.println();

		// SEARCH
//		System.out.println(b.search(b.root, 18));
	}
}
