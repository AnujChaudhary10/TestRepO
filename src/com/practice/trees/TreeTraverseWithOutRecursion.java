/**
 * @authorAnujchaudhary
 */
package com.practice.trees;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Anujchaudhary
 *
 */
public class TreeTraverseWithOutRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n = new Node(5);
		n.left = new Node(4);
		n.left.right = new Node(3);
		n.left.right.right = new Node(100);
		n.left.right.left = new Node(101);
		n.left.left = new Node(6);
		n.right = new Node(19);
		n.right.left = new Node(10);
		n.right.right = new Node(9);
		traverseInorder(n);
		System.out.println("inOrder");
		printInorder(n);
		System.out.println("inOrder");
		printPostorder(n);
		System.out.println("postOrder");
		printPreorder(n);
		System.out.println("preOrder");
		traversePostOrder(n);
	}

	static void traverseInorder(Node node) {
		if (Objects.isNull(node))
			return;

		Stack<Node> leftNodes = new Stack<>();
		while (node != null) {
			leftNodes.push(node); // push all left node
			node = node.left;
		}
		while (!leftNodes.isEmpty()) {
			Node n = leftNodes.pop();
			System.out.print(n.data + " ");
			if (Objects.nonNull(n.right)) {
				n = n.right;
				while (n != null) {
					leftNodes.push(n);
					n = n.left;
				}
			}
		}

	}
	static void traversePostOrder(Node node) {
		if (Objects.isNull(node))
			return;

		Stack<Node> leftNodes = new Stack<>();
		while (node != null) {
			leftNodes.push(node); // push all left node
			node = node.left;
		}
		while (!leftNodes.isEmpty()) {
			Node n = leftNodes.pop();
			if (Objects.nonNull(n.right)) {
				n = n.right;
				while (n != null) {
					leftNodes.push(n);
					n = n.left;
				}
			}
			
		}

	}
	static void traversePreOrder(Node node) {
		if (Objects.isNull(node))
			return;

		Stack<Node> leftNodes = new Stack<>();
		while (node != null) {
			leftNodes.push(node); // push all left node
			node = node.left;
		}
		while (!leftNodes.isEmpty()) {
			Node n = leftNodes.pop();
			if (Objects.nonNull(n.right)) {
				n = n.right;
				while (n != null) {
					leftNodes.push(n);
					n = n.left;
				}
			}
		}

	}

	static void printPostorder(Node node) {
		if (node == null)
			return;

		printPostorder(node.left);

		printPostorder(node.right);

		System.out.print(node.data + " ");
	}

	static void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);

		System.out.print(node.data + " ");

		printInorder(node.right);
	}

	static void printPreorder(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");

		printPreorder(node.left);

		printPreorder(node.right);
	}

}
