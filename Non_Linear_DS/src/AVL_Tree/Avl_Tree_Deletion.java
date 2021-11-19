package AVL_Tree;

import AVL_Tree.Avl_Tree.Node;


public class Avl_Tree_Deletion {

	// DELETION OPERATION SAME LIKE DELETING A NODE FROM BST
	Node delete(Node root, int data) {
		if (root == null) {
			return root;
		}

		if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		}
		// ROOT IS THE NODE WHICH WE WANT TO DELETE THEN
		else {
			// IF LEFT OR RIGHT NODE IS PRESENT OR NO NODE IS PRESENT
			if (root.left == null || root.right == null) 
			{
				Node temp = null;

				// IF ROOT.LEFT IS NULL LIKE TEMP THEN STORE ROOT.RIGHT IN TEMP ELSE STORE
				// ROOT.LEFT
				if (temp == root.left) {
					temp = root.right;
				} else {
					temp = root.left;
				}
				// WHEN THE ROOT DOESNT HAVE ANY LEFT OR RIGHT CHILD
				if (temp == null) {
					temp = root;
					root = null;
				}else {
					root = temp;          //STORE LEFT OR RIGHT CHILD OF ROOT IN ROOTS PLACE
				}
			}
			else 
				//WHEN THE ROOT HAS BOTH THE CHILDS
			{
				//GET THE MINIMUM LEFT CHILD VALUE OF ROOT TO REPLACE WITH ROOT
				Node temp = minValue(root.right);

				//STORE THAT VALUE AT ROOTS PLACE
				root.data = temp.data;
                //DELETE THE DATA WHERE IT WAS PRESENT BEFORE
				root.right = delete(root.right, temp.data);
			}
		}
		//BALANCING CODE AFTER DELETION 
		if (root == null) {
			return root;
		}

		//GETTING THE HEIGHT OF THE NODE COMPARING BOTH ITS CHILDS
		root.height = 1 + max(height(root.left), height(root.right));

		//GETTING THE BALANCE FOR THE NODE WHICH IS DIFFERENCE OF HEIGHTS OF TWO CHILDS
		int balance = get_Balance_Factor(root);

		//CONDITION WHEN LEFT-LEFT TREE FORMS AFTER DELETION
		if (balance > 1 && get_Balance_Factor(root.left) >= 0) {
			return rotate_Right(root);
		}
		//CONDITION WHEN LEFT-RIGHT TREE FORMS AFTER DELETION
		if (balance > 1 && get_Balance_Factor(root.left) < 0) {
			root.left = rotate_Left(root.left);
			return rotate_Right(root);
		}
		//CONDITION WHEN RIGHT-RIGHT TREE FORMS AFTER DELETION
		if (balance < -1 && get_Balance_Factor(root.right) <= 0) {
			return rotate_Left(root);
		}
		//CONDITION WHEN RIGHT-LEFT TREE FORMS AFTER DELETION
		if (balance < -1 && get_Balance_Factor(root.right) > 0) {
			root.right = rotate_Right(root.right);
			return rotate_Left(root);
		}
		return root;
	}

	//RIGHT ROATION
	private Node rotate_Right(Node root) {
		Node lNode = root.left;
		Node temp = lNode.right;

		lNode.right = root;
		root.left = temp;

		root.height = 1 + max(height(root.left), height(root.right));
		lNode.height = 1 + max(height(lNode.left), height(lNode.right));

		return lNode;
	}

	//LEFT ROTATION
	private Node rotate_Left(Node root) {
		Node rNode = root.right;
		Node temp = rNode.left;

		rNode.left = root;
		root.right = temp;

		root.height = 1 + max(height(root.left), height(root.right));
		rNode.height = 1 + max(height(rNode.left), height(rNode.right));

		return rNode;
	}

	//GET BALANCE FACTOR WHICH IS DIFFERENCE OF TWO CHILDS HEIGHT
	private int get_Balance_Factor(Node root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) - height(root.right);
	}

	//MAX  ELEMENT COMPARED TOP BOTH LEFT AND RIGHT CHILDS
	private int max(int left, int right) {

		return (left > right) ? left : right;
	}

	//GETTING THE HEIGHT OF THE NODE 
	private int height(Node root) {
		if (root == null) {
			return 0;
		}
		return root.height;
	}

	//GETTING THE MINIMUM VALUE FROM THE RIGHT SUBTREE PPPPPP
	private Node minValue(Node right) {
		Node current = right;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {
		Avl_Tree_Deletion a = new Avl_Tree_Deletion();
		Avl_Tree b = new Avl_Tree();

		b.root = b.insert(b.root, 10);
		b.root = b.insert(b.root, 20);
		b.root = b.insert(b.root, 30);
		b.root = b.insert(b.root, 40);
		b.root = b.insert(b.root, 50);
		b.root = b.insert(b.root, 60);
		b.root = b.insert(b.root, 70);
		b.root = b.insert(b.root, 80);
		b.root = b.insert(b.root, 90);
		b.root = b.insert(b.root, 60);

		a.delete(b.root, 50);
		System.out.println("INORDER");
		a.inOrder(b.root);

	}

}
