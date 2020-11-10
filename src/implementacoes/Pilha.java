package implementacoes;

import java.util.Scanner;



public class Pilha {
		
	private int top = -1;
	
		
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Pilha pilha = new Pilha();
		
		String[]array = new String[size];
		
		
		String acao = sc.nextLine();
		
		while(!(acao.equals("end"))) {
			
			
			if(acao.equals("print")){
				pilha.print(array);
			}
			else if(acao.equals("peek")){
				pilha.peek(array);
			}			
			else if(acao.equals("pop")) {
				pilha.pop(array);
			}
			
			else if(acao.contains("push")){
				String[] separador = acao.split(" ");
				pilha.push(array, separador[1]);
				
			}
			
			acao = sc.nextLine();
			
		}
				
	}
	
	public void  push(String[] array, String element){
			
			if(this.isFull(array)){
				System.out.println("full");
				return;
			} else {
				this.top ++;
				array[this.top] = element;	
			}
				
		}
	
	public boolean isFull(String[] array) {
			
			return this.top == (array.length -1);
			
		}
	
	public void pop(String[] array){
			
		if(isEmpty()){
			System.out.println("empty");
			return;
		}
		else {
			this.top --;
		}
	
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public void peek(String[] array){
			
				
			if(isEmpty()) {
				System.out.println("empty");
				return;
			} else {
				System.out.println(array[this.top]);
			}			
		}
	
	public void print(String[] array) {
		
		if(isEmpty()) {
			System.out.println("empty");
			return;
		} else {
			for(int i = 0; i <= this.top; i++) {
				if(i != this.top) {
					System.out.print(array[i] + " ");
				} else {
					System.out.println(array[i]);
				}
			}
			
		}
	}
}
	
	

	

