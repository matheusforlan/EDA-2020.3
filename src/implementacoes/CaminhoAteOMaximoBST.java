package implementacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaminhoAteOMaximoBST {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		int[] sequenciaInteiros = converteEmInteiros(sequencia);
		
		BST bst = new BST();
		
		insereElementos(sequenciaInteiros, bst);
	    maxBST(sequenciaInteiros, bst);
	    
	}
	
	private static int[] converteEmInteiros(String[] sequencia) {
		
		int[] sequenciaInteiros = new int[sequencia.length];
			
		for (int i = 0; i < sequenciaInteiros.length; i++) {
			
			sequenciaInteiros[i] = Integer.parseInt(sequencia[i]);
		}
			
		return sequenciaInteiros;
			
	}
	
	private static void maxBST(int[] sequenciaInteiros, BST bst) {
		
		String values = "";

        List maxValues = bst.pathToMaxValue();

        for (int i = 0; i < maxValues.size(); i++){
            if (values=="") {
                values += maxValues.get(i);
            } else {
                values += " " + maxValues.get(i);
            }
        }

        System.out.println(values);
		
	}

	private static void insereElementos(int[] sequenciaInteiros, BST bst) {
		
		for(int element: sequenciaInteiros) {
			bst.insert(element);
		}
		
	}

	static class BST{
		
		private Node root;
		
		public BST() {
			this.root = null;
		}
		
		public boolean isEmpty() {
			return this.root==null;
	    }
		
		
		public void insert(int data) {
            if (this.isEmpty()) {
                this.root = new Node(data);
            } else {
                insert(this.root, data);
            }
        }

		private void insert(Node currentNode, int data) {
			
			 if (data < currentNode.getData()){
				 	// se tem espaço para adicionar na esquerda, adiciona.
	                if (currentNode.getLeft()==null){
	                    Node newNode = new Node(data);
	                    currentNode.setLeft(newNode);
	                    newNode.setParent(currentNode);
	                // se n tem espaço, chama recursivamente de novo e nó vira o da esquerda    
	                } else {
	                    insert(currentNode.getLeft(), data);
	                }
	                // data > currentNode.getData()
	            } else {
	            	// se tem espaço para adicionar na direita, adiciona.
	            	if (currentNode.getRight()==null){
	                    Node newNode = new Node(data);
	                    currentNode.setRight(newNode);
	                    newNode.setParent(currentNode);
	            	}
	            	 // se n tem espaço, chama recursivamente de novo e nó vira o da direita
	            	else {
	            		insert(currentNode.getRight(), data);
	            	}	            	
	            }
		
			
		}
		
		public List pathToMaxValue() {
			
            List list = new ArrayList();
            
            int root = this.root.getData();

            list.add(root);

            Node node = this.root;

            while(node.getRight() != null) {
            	
                node = node.getRight();
                list.add(node.getData());

            }

            return list;
        }
	
	}
	
	    static class Node {

	        private int data;
	        private Node left;
	        private Node right;
	        private Node parent;

	        public Node(int data) {
	            this.data = data;
	            this.left = null;
	            this.right = null;
	            this.parent = null;
	        }

	        public int getData() {
	            return data;
	        }

	        public Node getLeft() {
	            return left;
	        }

	        public Node getRight() {
	            return right;
	        }

	        public Node getParent() {
	            return parent;
	        }

	        public void setLeft(Node left) {
	            this.left = left;
	        }

	        public void setRight(Node right) {
	            this.right = right;
	        }

	        public void setParent(Node parent) {
	            this.parent = parent;
	        }
	    }		

}
