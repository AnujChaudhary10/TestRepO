
package com.practice.trees;

import java.util.Stack;

/**
 * @author Anujchaudhary
 *
 */
public class PrintBorderOfTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(100);
		printLeftAndLeafNodes(root);
		printRightNode(root);
	}
	
	static void printLeftAndLeafNodes(Node root){
		Stack<Node> nodes
		 =  new Stack<>();
		if(root == null)
			return;
		while(root != null){
			nodes.push(root);
			if(root.left != null || root.right != null)
				System.out.println(root.data);
			root = root.left;
			
		}
		
		while(!nodes.isEmpty()){
			Node n = nodes.pop();
			if( n != null){
			if(n.left == null && n.right == null)
				System.out.println(n.data);
			if(n.right != null){
				n = n.right;
				nodes.push(n);
				while(n != null){
				n = n.left;
				nodes.push(n);
				}
			}
			}
			
		}
	}
	
	static void printRightNode(Node root){
		Stack<Node> n =  new Stack<>();
		while(root != null){
			root = root.right;
			n.push(root);
		}
		while(!n.isEmpty()){
			Node node = n.pop();
			if(node != null && (node.left != null || node.right != null))
				System.out.println(node.data);
		}
	}

}
