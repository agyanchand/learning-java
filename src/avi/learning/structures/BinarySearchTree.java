package avi.learning.structures;

public class BinarySearchTree {
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.addData(8);
		bst.addData(10);
		bst.addData(2);
		bst.addData(4);
		bst.addData(11);
		bst.addData(1);
		bst.addData(9);
		
		bst.printPreOrderTree();
		bst.printInOrderTree();
		bst.printPostOrderTree();
	}
	
	static class BST {
		private Node root;
		
		public void addData(int data) {
			if(root == null) {
				root = new Node(data, null);
			} else {
				addData(data, root, null, false);
			}
		}
		
		public void printPreOrderTree() {
			printPreOrderTree(root);
			System.out.println();
		}
		
		public void printInOrderTree() {
			printInOrderTree(root);
			System.out.println();
		}
		
		public void printPostOrderTree() {
			printPostOrderTree(root);
			System.out.println();
		}
		
		private void printPreOrderTree(Node node) {
			if(node != null) {
				System.out.print(node.data + ", ");
				printPreOrderTree(node.left);
				printPreOrderTree(node.right);
			}
		}
		
		private void printInOrderTree(Node node) {
			if(node != null) {
				printInOrderTree(node.left);
				System.out.print(node.data + ", ");
				printInOrderTree(node.right);
			}
		}
		
		private void printPostOrderTree(Node node) {
			if(node != null) {
				printPostOrderTree(node.left);
				printPostOrderTree(node.right);
				System.out.print(node.data + ", ");
			}
		}

		private void addData(int data, Node node, Node parent, boolean right) {
			if(node == null) {
				node = new Node(data, parent);
				if(right) {
					parent.right = node;
				} else {
					parent.left = node;
				}
			} else if (data > node.data) {
				addData(data, node.right, node, true);
			} else if (data < node.data) {
				addData(data, node.left, node, false);
			}
		}
		
		private class Node {
			Node parent,
				left,
				right;
			int data;
			
			public Node(int data, Node parent) {
				this.data = data;
				this.parent = parent;
			}
		}
	}
}

