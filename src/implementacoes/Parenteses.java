package implementacoes;

import java.util.Scanner;

public class Parenteses {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack pilha = new Stack();
		String entrada = sc.nextLine();
		System.out.println(confereParenteses(entrada, pilha));
				
		sc.close();
		
	}
	
	public static String confereParenteses(String entrada, Stack pilha){
				
		String valido = "S";
		
		String[] parentesesSeparados = entrada.split("");
		
		for(int i = 0; i < parentesesSeparados.length; i++) {
			
			if(parentesesSeparados[i].equals("(")) {
				pilha.push(")");
			}
			
			else if(parentesesSeparados[i].equals(")")) {
				
				if(pilha.isEmpty()){
					valido = "N";
					break;
				} else {
					pilha.pop();
				}
			}			
		}
		
		if(!pilha.isEmpty()) {
			
			valido = "N";
		}
		
		return valido;
		
	}
	
	 static class Stack {
		 	
		 
	        private LinkedList list;
	        
	        public Stack(){
	            this.list = new LinkedList();
	        }
	        
	        public boolean isEmpty(){
	            boolean answer = false;

	            if (this.list.size() == 0) {
	                answer = true;
	            }

	            return answer;
	        }
	        
	        public void push(String value) {
	        	
	                this.list.insert(value);
	                
	        }
	        
	        public void pop(){
	        	
	            if(!this.isEmpty()) {	            	
	                this.list.remove();	                
	            }	            	            
	        }
	 }
	
	static class LinkedList {

        private String data;
        private LinkedList head;
        private LinkedList next;
        private LinkedList previous;

        public LinkedList() {}

        public LinkedList(String data) {
            this.data = data;
        }


        public boolean isEmpty() {
            boolean answer = false;

            if (this.data==null) {
                answer = true;
            }

            return answer;
        }

        public void insert(String value) {
        	
            if (this.isEmpty()) {

                this.setData(value);
                this.setNext(new LinkedList());
                this.getNext().setPrevious(this);
                this.setHead(this);
                
            } else {
                this.getNext().insert(value);
            }
        }


        public void remove() {

            if (!this.isEmpty()) {

                if (this.size()==1) {
                    this.head = null;
                    this.setData(this.getNext().getData());
                    this.setNext(this.getNext().getNext());
                }  else if (this.getNext().isEmpty()) {
                    this.setData(this.getNext().getData());
                    this.setNext(this.getNext().getNext());
                } else {
                    this.getNext().remove();
                }
                
            }
            
            
        }

        public int size(){
            int value = 0;

            if (!this.isEmpty()) {
                value = 1 + this.getNext().size();
            }

            return value;
        }

        public int search(String value, int index) {
            int result = -1;

            if (value!=null) {

                if (!this.isEmpty()) {

                    if (this.getData().equals(value)) {
                        result = index;
                    } else {
                        result = this.next.search(value, index+1);
                    }
                }
            }

            return result;
        }

        public String toString() {
            String result = "";

            if (!this.isEmpty()) {

                if (this.getNext().isEmpty()) {
                    result += this.getData();
                } else {
                    result += this.getData() + " " + this.getNext().toString();
                }
            }

            return result;
        }
        
        public String getData() {
            return data;
        }

        public LinkedList getNext() {
            return next;
        }

        public LinkedList getPrevious() {
            return previous;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setNext(LinkedList next) {
            this.next = next;
        }

        public void setPrevious(LinkedList previous) {
            this.previous = previous;
        }

        public LinkedList getHead() {
            return this.head;
        }

        public void setHead(LinkedList head) {
            this.head = head;
        }
       
    }	    
	
}
