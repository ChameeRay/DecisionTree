package com.web.tree;

public class Tree {
	private class Node{
		private String data; 
		private Node leftChild; 
		private Node rightChild;
		
		public Node() {
			this.data = new String("");  
			this.leftChild = null; 
			this.rightChild = null; 
		}

		
		public void setData(String data) {
			this.data = data; 
		}
		
		public String getData() {return this.data; } 
		
		public boolean hasChilds() {
			return this.leftChild != null && this.rightChild != null; 
		}
	}

	/***************************************************************************************************************/
	private Node root;  
	
	public Tree() {
		this.root = null; 
	}
	
	private Node goThroughAndAdd(Node crr, String data, String sequence) {
		if(crr == null) {
			Node res = new Node(); 
			res.setData(data);
			return res;  
		}
		else {
			Node tmp = new Node(); 
			char currentChar = sequence.charAt(0);
			if(currentChar == '0') {
				tmp.leftChild = this.goThroughAndAdd(crr.leftChild,  data, sequence.substring(1));
				tmp.rightChild = crr.rightChild;
			}
			else {
				tmp.rightChild = this.goThroughAndAdd(crr.rightChild, data, sequence.substring(1));
				tmp.leftChild = crr.leftChild;
			}
			tmp.setData(crr.data);
			return tmp; 
		}
	}
	/***************************************************************************************************************/
	public void addItem(String data, String sequence) {   
		if(this.root == null) { 
			this.root = new Node(); 
			this.root.setData(data);
		}
		else {
			char currentChar = sequence.charAt(0);
			if(currentChar == '1')  
				this.root.rightChild = this.goThroughAndAdd(this.root.rightChild,  data, sequence.substring(1));
			else
				this.root.leftChild = this.goThroughAndAdd(this.root.leftChild, data, sequence.substring(1));
		}
	}
	/***************************************************************************************************************/
	private void nodeDisplay(Node crr) {
		if(crr != null) {
			System.out.print(crr.data + " ");
			System.out.print("\n LEFT de "+crr.data+"  --->   ");
			nodeDisplay(crr.leftChild);
			System.out.print("\n RIGHT de "+crr.data+"  --->   ");
			nodeDisplay(crr.rightChild);
		}
	}
	/***************************************************************************************************************/
	public void display() {
		this.nodeDisplay(this.root);
	}
	/***************************************************************************************************************/
	
	private String getChilds(Node currentNode, String sequence) {
		if(currentNode == null) {
			return "";
		}
		else {
			if(sequence.length() == 1) {
				char currentChar = sequence.charAt(0);
				if(currentChar == '0') {
					if(currentNode.leftChild.hasChilds())
						return currentNode.leftChild.leftChild.data + "   " + currentNode.leftChild.rightChild.data; 
					return "Noeud terminal"; 
				}
				else {
					if(currentNode.rightChild.hasChilds())
						return currentNode.rightChild.leftChild.data + "   " + currentNode.rightChild.rightChild.data; 
					return "Noeud terminal";
				}
			}
			else {
				char currentChar = sequence.charAt(0);
				if(currentChar == '0') { 
					return getChilds(currentNode.leftChild, sequence.substring(1));
				}
				else {
					return getChilds(currentNode.rightChild, sequence.substring(1)); 
				}
			}
			
		}
	}
	
	/***************************************************************************************************************/
	private String getDataByPath(Node currentNode, String path) {
		if(path.length() == 0) {
			return currentNode.getData();
		}
		else {
			char currentChar = path.charAt(0); 
			if(currentChar == '0') {
				return this.getDataByPath(currentNode.leftChild, path.substring(1));
			}
			else {
				return this.getDataByPath(currentNode.rightChild, path.substring(1));
			}
		}
	}

	/***************************************************************************************************************/

	public String getData(String path) {
		return this.getDataByPath(this.root, path); 
	}
	
	/***************************************************************************************************************/
	
	public String computeNewChild(String predSequence, String currentChoice) {
		String fullPath = predSequence.concat(currentChoice);
		return getChilds(this.root, fullPath);
	}
	
	/***************************************************************************************************************/

}


