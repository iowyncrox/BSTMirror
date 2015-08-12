public class BST<T extends Comparable<T>> {

	private Node<T> root;

	public BST() {
		root = null;
	}

	private int compare(T x, T y) {
		return x.compareTo(y);
	}

	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return data.toString();
		}

	}

	public void insert(T data) {
		root = insert(data, root);
	}

	private Node<T> insert(T data, Node<T> currentPointer) {

		if (currentPointer == null) {
			return new Node<T>(data);
		}

		if (compare(data, currentPointer.data) == 0) {
			return currentPointer;
		}

		if (compare(data, currentPointer.data) < 0) {
			currentPointer.left = insert(data, currentPointer.left);
		} else {
			currentPointer.right = insert(data, currentPointer.right);
		}

		return currentPointer;
	}

	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node<T> currentPointer) {
		if (currentPointer != null) {
			System.out.print(currentPointer + " ");
			preOrderHelper(currentPointer.left);
			preOrderHelper(currentPointer.right);
		}
	}

	public void mirrorBST() {
		root = mirrorHelper(root);
	}

	private Node<T> mirrorHelper(Node<T> currentPointer) {
		if (currentPointer == null
				|| (currentPointer.left == null && currentPointer.right == null)) {
			return currentPointer;
		}

		Node<T> temp = currentPointer.left;
		currentPointer.left = currentPointer.right;
		currentPointer.right = temp;

		mirrorHelper(currentPointer.left);
		mirrorHelper(currentPointer.right);

		return currentPointer;
	}

	public static void main(String[] args) {
		Integer[] a = { 7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10 };
		BST<Integer> bst = new BST<Integer>();
		for (Integer n : a)
			bst.insert(n);

		bst.preOrderTraversal();
		System.out.println();

		bst.mirrorBST();

		bst.preOrderTraversal();
		System.out.println();

	}
}