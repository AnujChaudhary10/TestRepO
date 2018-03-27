package com.practice.trees;
/**
 * @author Anujchaudhary
 *
 */
public class TreeFindGivenData {

	public static void main(String[] args) {
		Node n = new Node(5);
		n.left = new Node(4);
		n.left.right = new Node(3);
		n.left.left = new Node(6);
		n.right = new Node(19);
		n.right.left = new Node(10);
		n.right.right = new Node(9);

		System.out.println("check : " + traverse(n, 100, false));

	}

	static boolean traverse(Node node, int data, boolean gotIt) {
		if (node == null) {
			return false;
		}
		if (gotIt) {
			return true;
		}
		if (node.data == data) {
			System.out.println(true);
			return true;
		}
		gotIt = traverse(node.left, data, gotIt);
		System.out.println(node.data);
		gotIt = traverse(node.right, data, gotIt);
		return gotIt;
	}

}
 class Node {
	public Node(int data){
		this.data = data;
	}
int data;
Node left,right;
}
