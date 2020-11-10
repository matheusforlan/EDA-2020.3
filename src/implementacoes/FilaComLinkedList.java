package implementacoes;

import java.util.Scanner;

public class FilaComLinkedList {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        Queue fila = new Queue();
	        
	        String acao = sc.nextLine();

	        
	        while(!(acao.equals("end"))) {
				
				
				if(acao.contains("print")){
					fila.content();
				}
				else if(acao.contains("element")){
					fila.element();
				}			
				else if(acao.contains("remove")) {
					fila.remove();
				}
				
				else if(acao.contains("add")){
					String[] separador = acao.split(" ");
					fila.add(separador[1]);
					
				} else if(acao.contains("search")){
					String[] separador = acao.split(" ");
					fila.search(separador[1]);
				}
				
				acao = sc.nextLine();
				
			}
	    }

	    static class Queue {

	        private LinkedList list;

	        public Queue() {
	            this.list = new LinkedList();
	        }

	        public void add(String value) {
	        	
	            if (isEmpty()) {
	                this.list.insertFirst(value);
	            } else {
	                this.list.insert(value);
	            }
	            
	        }

	        public void remove() {
	        	
	            if (this.isEmpty()) {
	                System.out.println("empty");
	            } else {
	                this.list.remove();
	            }
	        }

	        public void element() {
	        	
	            if (isEmpty()) {
	                System.out.println("empty");
	            } else {
	                System.out.println(this.list.getHead().getData());
	            }
	            
	        }

	        public void search(String value) {
	        	
	            System.out.println(this.list.search(value, 0));
	            
	        }

	        public void content() {
	        	
	            if (isEmpty()) {
	                System.out.println("empty");
	            } else {
	                System.out.println(this.list.toString());
	            }
	        }

	        public boolean isEmpty() {
	            boolean answer = false;

	            if (this.list.size() == 0) {
	                answer = true;
	            }

	            return answer;
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

	            } else {

	                this.getNext().insert(value);
	            }
	        }

	        public void insertFirst(String value) {
	            this.setData(value);
	            this.setNext(new LinkedList());
	            this.getNext().setPrevious(this);
	            this.setHead(this);
	        }



	        public void remove() {

	            if (!this.isEmpty()) {

	                if (this.size()==1) {
	                    this.head = null;
	                }

	                this.setData(this.getNext().getData());
	                this.setNext(this.getNext().getNext());


	            }
	        }

	        public int size() {
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

