import java.util.ArrayList;

public class BST {
	
	private class Node {
		Node left, right;
		int key, val;
		public Node(Node left, Node right, int key, int val) {
			this.left = left;
			this.right = right;
			this.key = key;
			this.val = val;
		}
	}
	
	private Node root;
	
	private ArrayList<Integer> in_order;
	
	public BST() {
		root = null;
		in_order = new ArrayList<Integer>();
	}
	
	public void put(int key, int val) {
        this.root = insert(root, key, val);
    }
	
	/**
	 * @param key is the total server time
	 * @param val is the customer number (val will always be unique)
	 * @return
	 */
	public Node insert(Node cur, int key, int val) {
		if(cur == null) {
			return new Node(null, null, key, val);
		}
		if(key > cur.key) {
			cur.right = insert(cur.right, key, val);
		}else if(key < cur.key) {
			cur.left = insert(cur.left, key, val);
		}else {
			if(val >= cur.val) {
				cur.right = insert(cur.right, key, val);
			}
			else {
				cur.left = insert(cur.left, key, val);
			}
		}
		return cur;
	}
	
	public ArrayList<Integer> get_serve_order() {
		this.in_order.clear();
		in_order(root);
		return this.in_order;
	}
	
	public void in_order(Node root) {
		if(root != null) {
			in_order(root.left);
			this.in_order.add(root.val);
			in_order(root.right);
		}
	}
	
	

}
