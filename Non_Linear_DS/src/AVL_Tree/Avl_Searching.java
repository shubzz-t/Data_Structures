package AVL_Tree;

import AVL_Tree.Avl_Tree.Node;
import BInary_Tree.binary_Tree;

public class Avl_Searching {
	
	
//	Node find(Node root , int key) {
//	    Node current =root;
//	    while (current != null) {
//	        if (current.data == key) {
//	            break;
//	        }
//	        current = current.data < key ? current.right : current.left;
//	    }
//	    return current;


	
	public boolean contains(Node root , Integer value) {
	    Node current = root;

	    while (current != null) {
	        int comparison = value.compareTo(current.data);
	        if (comparison == 0) {
	            return true;
	        } else if (comparison < 0) {
	            current = current.left;
	        } else { //comparison > 0
	            current = current.right;
	        }
	    }

	    return false;
	}
	public static void main(String[] args) {
		Avl_Searching s = new Avl_Searching();
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
		
		System.out.println(s.contains(b.root, 37));

	}

}
