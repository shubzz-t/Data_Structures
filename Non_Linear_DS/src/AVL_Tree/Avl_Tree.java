package AVL_Tree;


public class Avl_Tree {
	Node root;

	class Node {
		int height, data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.height = 1;
		}

	}

	////////////////////////////////////// MAIN INSERT
	////////////////////////////////////// FUNCTION??????????????????????????????????????
	Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		} else
			return root;

		root.height = 1 + max(height(root.left), height(root.right));

		int balance = get_Balance_Factor(root);

		// RIGHT ROTATION FOR LEFT-LEFT TREE
		if (balance > 1 && data < root.left.data) {
			return rotate_Right(root);
		}

		// LEFT ROTATION FOR RIGHT-RIGHT TREE
		if (balance < -1 && data > root.right.data) {
			return rotate_Left(root);
		}

		// LEFT-RIGHT ROTATION FOR LEFT-RIGHT TREE
		if (balance > 1 && data > root.left.data) {
			root.left = rotate_Left(root.left);
			return rotate_Right(root);
		}

		// RIGHT-LEFT ROTATION FOR RIGHT-LEFT TREE
		if (balance < -1 && data < root.right.data) {
			root.right = rotate_Right(root.right);
			return rotate_Left(root);
		}

		return root;
	}

	private Node rotate_Left(Node root) {
		Node rNode = root.right; // TAKING NODE WHICH WE WANT AS ROOT AFTER ROTATION IN RNODE
		Node temp = rNode.left; // RnODE.LEFT IS A NULL NODE

		// ROTATING THE TREE
		rNode.left = root; // TAKING INITIAL ROOT TO THE LEFT OF THE SUBROOT TO BALANCE
		root.right = temp; // ROOTS RIGHT WHICH HAS SUBROOT SETTING THAT AS NULL

		root.height = 1 + max(height(root.left), height(root.right));
		rNode.height = 1 + max(height(root.left), height(root.right));

		return rNode;
	}

	private Node rotate_Right(Node root) {
		Node lNode = root.left; // TAKING NODE WHICH WE WANT AS ROOT AFTER ROTATION IN LNODE
		Node temp = lNode.right; // LnODE.RIGHT IS THE NULL NODE

		// ROTATING THE TREE
		lNode.right = root; // TAKING THE INITIAL ROOT TO THE RIGHT OF THE SUBROOT TO BALANCE
		root.left = temp; // ROOTS LEFT WHICH WAS SUBROOT SETTING THAT AS NULL

		// UPDATING HEIGHTS
		root.height = 1 + max(height(root.left), height(root.right));
		lNode.height = 1 + max(height(lNode.left), height(lNode.right));

		return lNode;
	}

	// GETTING THE BALANCE FACTOR WHICH IS DIFFERENCE BETWEEN RIGHT AND LEFT SUBTREE
	private int get_Balance_Factor(Node root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) - height(root.right);
	}

	// GETTING THE MAX BETWEEN THE TWO LEFT AND RIGHT NODES OF SPECIFIC ROOT
	private int max(int left, int right) {
		return (left > right) ? left : right;
	}

	// GETTING THE HEIGHT OF EVERY NODE
	private int height(Node root) {
		if (root == null) {
			return 0;
		}
		return root.height;
	}

	// PREORDER TRAVESAL
	void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		Avl_Tree tree = new Avl_Tree();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 11);

		System.out.println("PREORDER TRAVERSAL");
		tree.preorder(tree.root);
	}
}